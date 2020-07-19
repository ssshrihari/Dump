package Scratch;
abstract class abs{
    int a = 10;
    private int b;
    public int c;
    protected  int d;
    private void method1() {
        System.out.println("In method 1");
    }
    public void method2() {
        System.out.println("In method 2");
        System.out.println(a);
    }
    protected void method4() {
        System.out.println("In method 4");
    }
    abstract void method3();
}
interface Pp{
    private void sum(){
        System.out.println("In Pp");

    }
}
interface aaaBb extends Pp{
    public void sum();
}
interface Aa extends Pp {
    public void run();

}
class Cc implements  aaaBb,Aa{
    @Override
    public void sum() {

    }

    @Override
    public void run() {

    }
}
public class Inheritance extends abs {
    public static void main(String[] args) {
        Inheritance obj = new Inheritance();
        obj.method3();
        System.out.println(obj.a);
        obj.a = 20;
        System.out.println(obj.a);
        obj.method2();
        Inheritance obj2 = new Inheritance();
        obj2.method2();
    }
    @Override
    public void method3() {
        System.out.println("Overriden In method 3");

    }
}
