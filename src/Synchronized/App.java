package Synchronized;


public class App {
    public synchronized void  increment(){
        count++;
    }

    private int count = 0;
    public static void main(String[] args) {
    App app = new App();
    app.do_work();
    }

    public void do_work(){

    Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=0;i<100000;i++)
                    increment();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=0;i<100000;i++)
                    increment();
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
        System.out.println(count);
    }
}
