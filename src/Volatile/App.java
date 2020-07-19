package Volatile;

import java.util.Scanner;

class Proccessor extends Thread{

    private volatile boolean running = true;

    @Override
    public void run(){
        while(running){
            System.out.println("hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
    public void shutdown(){
        running = false;
    }
}
public class App {
    public static void main(String[] args) {

        Proccessor proc1 = new Proccessor();
        proc1.start();

        System.out.println("Press Return Key");
        Scanner s = new Scanner(System.in);
        s.nextLine();

        proc1.shutdown();



    }
}
