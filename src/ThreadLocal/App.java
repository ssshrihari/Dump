package ThreadLocal;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
class ThreadSafeInstance {


    public static ThreadLocal<SimpleDateFormat> threadsafe = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue(){
            return new SimpleDateFormat("dd-mm-yyyy");
        }
        @Override
        public SimpleDateFormat get() {
            return super.get();
        }
    };
}

public class App {
    public static void main(String[] args) {
        int x = Runtime.getRuntime().availableProcessors();
        System.out.println(x);


        ExecutorService executors = Executors.newFixedThreadPool(4);
        for(int i=0; i<1000; i++){
            int id = i;
            executors.execute(() ->{
                SimpleDateFormat date = new App().dateofBirth(id);
                System.out.println(Thread.currentThread().getId()+" is at "+date);
            });
        }
        executors.shutdown();
        System.out.println("All task submitted");
        try {
            executors.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed");
    }

    public SimpleDateFormat dateofBirth(int id) {
        ThreadSafeInstance tsf = new ThreadSafeInstance();
        SimpleDateFormat df = tsf.threadsafe.get();
        return df;
    }
}
