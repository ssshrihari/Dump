package Demo1;
class Runner extends Thread{
    public  void  run(){
        for(int i=0;i<10;i++){
            System.out.println("hello "+ i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class app {
    public static void main(String[] args) {

        Runner a= new Runner();

        Runner b = new Runner();
        a.start();
        b.start();

    }
}
