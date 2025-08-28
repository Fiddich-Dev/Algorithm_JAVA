import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private Integer age;
    private List<String> hobbies;

    private Member(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.hobbies = builder.hobbies;
    }

    public static class Builder {
        private String name;
        private Integer age;
        private List<String> hobbies;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder hobbies(List<String> hobbies) {
            this.hobbies = hobbies;
            return this;
        }

        public Member build() {
            if(this.hobbies == null) {
                this.hobbies = new ArrayList<>();
            }

            return new Member(this);
        }
    }
}
