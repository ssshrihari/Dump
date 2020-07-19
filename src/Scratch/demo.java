package Scratch;

class exmp{
    static exmp instance = new exmp();
    private exmp(){
    }
    public static exmp getInstance(){
        return instance;
    }

}
public class demo {
    public static void main(String[] args) {

          exmp obj = exmp.getInstance();
          System.out.println(obj);
    }
}
