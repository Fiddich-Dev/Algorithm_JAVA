

public class Lecture {

    private String code;
    private String codeSection;
    private String name;
    private String professor;
    private String type;
    private String time;
    private String place;
    private String credit;
    private String target;
    private String notice;
    private String department;

    public Lecture() {
    }

    public Lecture(String code, String codeSection, String name, String professor, String type, String time, String place, String credit, String target, String notice, String department) {
        this.code = code;
        this.codeSection = codeSection;
        this.name = name;
        this.professor = professor;
        this.type = type;
        this.time = time;
        this.place = place;
        this.credit = credit;
        this.target = target;
        this.notice = notice;
        this.department = department;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeSection() {
        return codeSection;
    }

    public void setCodeSection(String codeSection) {
        this.codeSection = codeSection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "code='" + code + '\'' +
                ", codeSection='" + codeSection + '\'' +
                ", name='" + name + '\'' +
                ", professor='" + professor + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", place='" + place + '\'' +
                ", credit='" + credit + '\'' +
                ", target='" + target + '\'' +
                ", notice='" + notice + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
