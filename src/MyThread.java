
import java.util.Random;

public class MyThread implements Runnable {

    public String ThreadName;

    public MyThread(String ThreadName) {
        this.ThreadName = ThreadName;
    }

    @Override
    public void run() {

        System.out.println("Поток " + ThreadName + " выполняется");

        int millisecond = 0;

        try {
            millisecond = new Random().nextInt(3000);
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Поток " + ThreadName + " закончил выполнение за " + millisecond + " миллисекунд");

    }
}
