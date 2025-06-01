import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class createTimetable {

    static int[][] time = new int[7][1440];
    static String[] departments = {"culture", "classicalChinese"};
    static List<Lecture> cultureLectures = new ArrayList<>();
    static List<Lecture> majorLectures = new ArrayList<>();
    static List<Lecture> totalLectures = new ArrayList<>();


    // 알고리즘
    // 전공을 원하는 만큼 넣고 교양을 최대 3개까지

    static int[][] usedTime = new int[7][1440];

    // 포함할 과목
    static List<String> likeLectureCode = new ArrayList<>();
    // 제외할 과목
    static List<String> dislikeLectureCode = new ArrayList<>();

    // 완성된 시간표
    static List<List<Lecture>> makedTimeTable = new ArrayList<>();

    // 원하는 전체 학점

    // 원하는 전공 개수
    static int targetMajorCnt = 5;

    // 원하는 교양 개수
    // 일단 0 ~ 3개까지 가능
    static int targetCultureCnt = 1;


    static long cnt = 0;

    // 전공만 넣어보기
    // 겹치는 학수번호 제외
    // 겹치는 시간 제외
    // 안되는 시간 추가
    static void go(int start, List<Lecture> b, Pair nowLectureCnt) {

        if(nowLectureCnt.major == targetMajorCnt && nowLectureCnt.culture == targetCultureCnt) {
            cnt++;
            makedTimeTable.add(new ArrayList<>(b)); // ← 복사해서 추가
            return;
        }


        for(int i = start + 1; i < totalLectures.size(); i++) {
            if(canAddLectureAboutCode(b, totalLectures.get(i)) && canAddLectureAboutTime(totalLectures.get(i)) && canAddLectureAboutCnt(nowLectureCnt, totalLectures.get(i))) {
                b.add(totalLectures.get(i));
                fillUsedTime(totalLectures.get(i));
                addLectureCnt(totalLectures.get(i), nowLectureCnt);

                go(i, b, nowLectureCnt);

                b.remove(b.size() - 1);
                eraseUsedTime(totalLectures.get(i));
                removeLectureCnt(totalLectures.get(i), nowLectureCnt);
            }
        }
    }

    // 겹치는 학수번호 제외
    static boolean canAddLectureAboutCode(List<Lecture> selectedLectures, Lecture targetLecture) {
        String targetCode = targetLecture.getCode();
        // 1. 이미 같은 코드가 존재하는지 확인
        boolean isDuplicateCode = selectedLectures.stream()
                .map(Lecture::getCode)
                .collect(Collectors.toSet())
                .contains(targetCode);

        if (isDuplicateCode) return false;
        return true;
    }
    // 겹치는 시간 제외
    static boolean canAddLectureAboutTime(Lecture targetLecture) {
        // 2. 시간 겹침 확인
        String[] times = targetLecture.getTime().split(",");
        for (String time : times) {
            if(time.isBlank()) {
                continue;
            }
            int day = dayToInt(time.charAt(0));
            String[] startAndEnd = time.substring(1).split("-");

            int start = Integer.parseInt(startAndEnd[0]) % 100 + Integer.parseInt(startAndEnd[0]) / 100 * 60;
            int end = Integer.parseInt(startAndEnd[1]) % 100 + Integer.parseInt(startAndEnd[1]) / 100 * 60;

            for (int i = start; i < end; i++) {
                if (usedTime[day][i] == 1) return false; // 이미 사용 중인 시간
            }
        }

        return true;
    }
    // 강의 개수 조건 제외
    static boolean canAddLectureAboutCnt(Pair nowLectureCnt, Lecture targetLecture) {
        if(targetLecture.getDepartment().equals("culture")) {
            return nowLectureCnt.culture + 1 <= targetCultureCnt;
        }
        else {
            return nowLectureCnt.major + 1 <= targetMajorCnt;
        }
    }
    // 시간 칠하기
    static void fillUsedTime(Lecture targetLecture) {
        String[] times = targetLecture.getTime().split(",");
        for(String time : times) {
            if(time.isBlank()) {
                continue;
            }
            int day = dayToInt(time.charAt(0));
            String[] startAndEnd = time.substring(1).split("-");
            int start = Integer.parseInt(startAndEnd[0]) % 100 + Integer.parseInt(startAndEnd[0]) / 100 * 60;
            int end = Integer.parseInt(startAndEnd[1]) % 100 + Integer.parseInt(startAndEnd[1]) / 100 * 60;

            for(int i = start; i < end; i++) {
                usedTime[day][i] = 1;
            }
        }
    }
    // 시간 지우기
    static void eraseUsedTime(Lecture targetLecture) {
        String[] times = targetLecture.getTime().split(",");
        for(String time : times) {
            if(time.isBlank()) {
                continue;
            }
            int day = dayToInt(time.charAt(0));
            String[] startAndEnd = time.substring(1).split("-");
            int start = Integer.parseInt(startAndEnd[0]) % 100 + Integer.parseInt(startAndEnd[0]) / 100 * 60;
            int end = Integer.parseInt(startAndEnd[1]) % 100 + Integer.parseInt(startAndEnd[1]) / 100 * 60;

            for(int i = start; i < end; i++) {
                usedTime[day][i] = 0;
            }
        }
    }
    // 강의 개수 추가
    static void addLectureCnt(Lecture targetLecture, Pair p) {
        if(targetLecture.getDepartment().equals("culture")) {
            p.culture++;
        }
        else {
            p.major++;
        }
    }
    // 강의 개수 제거
    static void removeLectureCnt(Lecture targetLecture, Pair p) {
        if(targetLecture.getDepartment().equals("culture")) {
            p.culture--;
        }
        else {
            p.major--;
        }
    }



    public static void main(String[] args) {
        System.out.println("hello");

        mapping();
        totalLectures.addAll(cultureLectures);
        totalLectures.addAll(majorLectures);
        // 듣고 싶은 과목 먼저
        // 안되는 시간 체크
        // 듣고 싶은 과목 추가(전공은 v에 담고, 교양은

        // pair를 만들어서 교양과 전공을 같이 계산할까


        // 듣고 싶은 과목
        Lecture lecture = new Lecture();
        lecture.setCode("KLC2003");
        lecture.setTime("수1630-1745");

        List<Lecture> v = new ArrayList<>();
        Pair nowLectureCnt = new Pair(0, 0);
        v.add(lecture);
        fillUsedTime(lecture);
        nowLectureCnt.major++;

        for(int i = 0; i < 1440; i++) {
            usedTime[4][i] = 1;
        }

        go(-1, v, nowLectureCnt);

        System.out.println("cnt = " + cnt);
        System.out.println("makedTimeTable.size() = " + makedTimeTable.size());


//        System.out.println("-----------majorLecture-------------");
//        for(Lecture majorLecture : majorLectures) {
//            System.out.println(majorLecture.toString());
//        }


//        System.out.println("-----------cultureLecture-------------");
//        for(Lecture cultureLecture : cultureLectures) {
//            System.out.println(cultureLecture.toString());
//        }

    }

    static void mapping() {
        for(String department : departments) {
            InputStream is = createTimetable.class.getClassLoader().getResourceAsStream(department + "Lectures.txt");
            if (is == null) throw new RuntimeException("파일을 찾을 수 없습니다.");

            List<String> lines = new BufferedReader(new InputStreamReader(is)).lines().toList();

            for (String line : lines) {
                Lecture lecture = LectureParser.parseLecture(line);
                lecture.setDepartment(department);
                if(department.equals("culture")) {
                    cultureLectures.add(lecture);
                }
                else {
                    majorLectures.add(lecture);
                }

            }
        }
    }

    static class Pair {
        int major;
        int culture;

        public Pair(int major, int culture) {
            this.major = major;
            this.culture = culture;
        }
    }

    // 문자를 숫자로
    static int dayToInt(char day) {
        switch (day) {
            case '월' : return 0;
            case '화' : return 1;
            case '수' : return 2;
            case '목' : return 3;
            case '금' : return 4;
            case '토' : return 5;
            case '일' : return 6;
            default: throw new IllegalArgumentException("잘못된 요일 문자입니다: " + day);
        }
    }
}

// 전공을 일단 원하는 만큼 만든다

// 원하는 교양을 고른다
// 이미 완성된 전공 시간표중에 안되는 것을 제외한다
//




//평가 항목	설명
//✅ 연강 최소화	같은 날 강의 사이에 빈 시간이 적을수록 좋음 (틈 시간 penalize)
//✅ 하루 수업 적정화	하루 1~2개의 수업이면 너무 효율이 낮음 (점수 낮게)
//✅ 연속 수업 선호	예: 하루에 몰아서 듣는 걸 선호하는 경우
//✅ 오전/오후 수업 선호	사용자 설정 가능 (예: 오전 수업 싫다)
//✅ 빈 시간 최소화	수업 간 공강 시간 최소화

// 싫은 과목 제외

