import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


class Lecture {
    
    String code;
    String name;
    String professor;
    String type;
    String time;
    String place;
    String credit;
    String target;
    String notice;

    public Lecture() {

    }

    
    public Lecture(String code, String name, String professor, String type, String time, String place, String credit,
            String target, String notice) {
        this.code = code;
        this.name = name;
        this.professor = professor;
        this.type = type;
        this.time = time;
        this.place = place;
        this.credit = credit;
        this.target = target;
        this.notice = notice;
    }


    @Override
    public String toString() {
        return "Lecture [code=" + code + ", name=" + name + ", professor=" + professor + ", type=" + type + ", time="
                + time + ", place=" + place + ", credit=" + credit + ", target=" + target + ", notice=" + notice + "]";
    }

    
    
}


public class FileTest {

    public static Lecture parseLecture(String input) {
        Lecture lecture = new Lecture();

        lecture.code = extractValue(input, "code");
        lecture.name = extractValue(input, "name");
        lecture.professor = extractValue(input, "professor");
        lecture.type = extractValue(input, "type");
        lecture.time = extractValue(input, "time");
        lecture.place = extractValue(input, "place");
        lecture.credit = extractValue(input, "credit");
        lecture.target = extractValue(input, "target");
        lecture.notice = extractValue(input, "notice");

        return lecture;
    }

    private static String extractValue(String input, String key) {
        String pattern = key + "=\"";
        int startIndex = input.indexOf(pattern);
        if (startIndex == -1) return null;

        startIndex += pattern.length();
        int endIndex = input.indexOf("\"", startIndex);
        if (endIndex == -1) return null;

        return input.substring(startIndex, endIndex);
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("output.txt"));

        for(String line : lines) {
            Lecture lecture = parseLecture(line);        
            System.out.println(lecture);
        }    
    }
}
