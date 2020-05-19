package moduleTest;

import java.util.Objects;

public class SingletonTest {

    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingletonTest that = (SingletonTest) o;
        return age == that.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.sin;
        Singleton s2 = Singleton.sin;
        System.out.println(s1 == s2);
        Object a = new Object();
        String s = "a";
        String c = "a";
        System.out.println(s==c);


        s.toCharArray();

    }



}
