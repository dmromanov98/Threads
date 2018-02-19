
import java.util.Random;

public class MyThread implements Runnable {

    public String ThreadName; //название потока

    public  MyThread(String ThreadName) {
        this.ThreadName = ThreadName;
    }

    @Override
    public  void run() {

    System.out.println("Поток " + ThreadName + " выполняется");

    int millisecond = 0;

    try {
        millisecond = new Random().nextInt(3000); //время выполнения потока(Получение рандомного числа)
        Thread.sleep(millisecond); //поток засыпает
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    System.out.println("Поток " + ThreadName + " закончил выполнение за " + millisecond + " миллисекунд");

    }
}
