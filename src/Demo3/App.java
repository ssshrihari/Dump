package Demo3;

public class App {
    public static void main(String[] args)  {
        Thread t1 = new Thread(() -> {
            for(int i=0;i<10;i++){
                System.out.println("hello "+ i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i=0;i<10;i++){
                System.out.println("hello "+ i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("I am in Main");


    }

}
