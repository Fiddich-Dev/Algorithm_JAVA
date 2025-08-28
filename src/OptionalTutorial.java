import java.util.Optional;

public class OptionalTutorial {

    public static void main(String[] args) {

        // 내부 값이 null인 옵셔널 만들기
        Optional<Pair> optional = Optional.empty();
        System.out.println(optional);
        System.out.println("옵셔널의 값이 있나 : " + optional.isPresent());


        // 내부 값이 null이 아님을 보장할때
//        try {
//            Optional<Pair> opPair = Optional.of(null);
//        } catch (NullPointerException e) {
//            System.out.println("NullPointerException 발생");
//        }

        //
        Optional<Pair> opPair = Optional.ofNullable(null);
        Pair pair = opPair.orElse(new Pair(99, 99));
        System.out.println(pair.toString());


//        Optional<Pair> opPair = Optional.ofNullable(null);
//        Pair pair = opPair.orElseGet(() -> new Pair(99, 99));
//        System.out.println(pair.toString());

//        Optional<Pair> opPair = Optional.ofNullable(new Pair(1, 1));
//        Pair pair = opPair.orElseGet(() -> new Pair(99, 99));
//        System.out.println(pair.toString());
//
//
//        Optional<Pair> opPairNull = Optional.ofNullable(null);
//        try {
//            Pair pair = opPairNull.orElseThrow(() -> new NullPointerException("값이 없습니다."));
//        } catch (NullPointerException e) {
//            System.out.println("NullPoint 예외 발생 : " + e.getMessage());
//        }

//        Optional<Pair> opPair = Optional.ofNullable(new Pair(1, 1));
//        Pair pair = opPair.orElseThrow(() -> new NullPointerException("값이 없습니다."));
//        System.out.println(pair.toString());




    }


    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }
}
