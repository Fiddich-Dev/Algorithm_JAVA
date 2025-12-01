
import java.util.*;
import java.io.*;

public class Test {

    public static void main(String[] args) {
        String a = "";
        String b = " ";
        String c = "\n";
        String d = "abc";
        String e = "\t";

        System.out.println("isEmpty() 결과");
        System.out.println(a.isEmpty()); // true
        System.out.println(b.isEmpty()); // false
        System.out.println(c.isEmpty()); // false
        System.out.println(d.isEmpty()); // false
        System.out.println(e.isEmpty());


        System.out.println("isBlank() 결과");
        System.out.println(a.isBlank()); // true
        System.out.println(b.isBlank()); // true
        System.out.println(c.isBlank()); // true
        System.out.println(d.isBlank()); // false
        System.out.println(e.isBlank());
    }

}



//4 m
//L g
//R o
//R r
//L o

// m
// gm
// gom
// gorm
// goorm
