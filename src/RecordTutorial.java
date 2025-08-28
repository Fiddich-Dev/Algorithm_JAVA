public class RecordTutorial {

    public static void main(String[] args) {

        // 초기화
        Home home = new Home("서울시", "서대문구");
        // getter
        System.out.println(home.city());
        System.out.println(home.gu());
        // equals
        Home childHome = new Home("서울시", "서대문구");
        System.out.println("home.equals(childHome) : " + home.equals(childHome));
        // hashcode
        System.out.println(home.hashCode());
        System.out.println(childHome.hashCode());
        System.out.println("home.hashCode() == childHome.hashCode() : " + (home.hashCode() == childHome.hashCode()));

        System.out.println("home == childHome : " + (home == childHome));

        // toString
        System.out.println(home.toString());
        System.out.println(childHome.toString());

        Home home2 = new Home(null);
        System.out.println(home2.toString());
    }

    // 선언하기
    public record Home(String city, String gu) {

        // Canonical Constructor (정식 생성자)
//        Home(String city, String gu) {
//            if (city == null || gu == null) {
//                throw new IllegalArgumentException("값이 null이면 안됩니다.");
//            }
//
//            this.city = city;
//            this.gu = gu;
//        }

        // Compact Constructor (축약 생성자)
//        Home {
//            if (city == null || gu == null) {
//                throw new IllegalArgumentException("값이 null이면 안됩니다.");
//            }
//        }

//         Custom Constructor (추가 생성자 / 보조 생성자)
Home(String city) {
    this(city, "전체");

    if (city == null) {
        throw new IllegalArgumentException("값이 null이면 안됩니다.");
    }
}
    }

}
