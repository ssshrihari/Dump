package Scratch;

interface interf{
    public void run(int a, String b);

    private int stop() {
        System.out.println("Private method of interface is been called");
        return 0;
    }

    default String method(){
        System.out.println("Called deafault method");
        return "string from default method interface ";
    }
}
abstract class A{
    public abstract void run(int a);

    public void add(){
        System.out.println("Add method called");
    }
}
class B extends A{
    @Override
    public void run(int a) {
        System.out.println("In B");

    }
    public void run(int a,String v){
        System.out.println("run method of class B");
    }
}
public class App  extends A implements interf{
    public static void main(String[] args) {

        App obj = new App();
        obj.run(2,"heee");
        obj.run(4,"hello");



    }

    @Override
    public void run(int a, String b) {
          System.out.println("Called Overridden method of Interface");
    }

    @Override
    public void run(int a) {

    }
}
