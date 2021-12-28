/**
 * ClassName : Test<br>
 * Description : Test<br>
 *
 * @author : sj
 * @date : 2021/9/24
 */
public class Test {

    public static class A {
        static int num1 = 100;
        static int num2 = 100;
        static A a = new A();

        public A() {
            num1 = 200;
            num2 = 200;
        }
    }

    public static class B {
        static int num1 = 100;
        static B b = new B();

        public B() {
            num1 = 200;
            num2 = 200;
        }

        static int num2 = 100;
    }

    public static void main(String[] args) {
        System.out.println(A.a.num1 + "  " + A.a.num2);
        System.out.println(B.b.num1 + "  " + B.b.num2);
    }
}
