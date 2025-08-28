

public class BuilderTutotial {

    public static void main(String[] args) {
Member member = new Member.Builder()
        .name("이름")
        .age(10)
        .build();

System.out.println(member);
    }

}

