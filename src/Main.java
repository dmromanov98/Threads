import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Thread> threads = new ArrayList<>(); //потоки
    static final int NUMBEROFTHREADS = 50; //количество потоков

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String task = null;

        for (int i = 0; i < NUMBEROFTHREADS; i++)
            threads.add(new Thread(new MyThread(String.valueOf(i)))); //добавление потоков в список

        while (true) {
            System.out.println("**********************" +
                    "\nКоманды:" +
                    "\n\t1 - запустить потоки " +
                    "\n\t" + "2 - закончить выполнение программы" +
                    "\n**********************\n ");

            try {
                task = reader.readLine(); //считывание команды с клавиатуры
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (task.equals("1")) {

                for (Thread thread : threads)
                    thread.start();

//                for (Thread thread : threads)
//                    try {
//                        thread.join(); // ожидание завершения потоков
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

            } else if (task.equals("2"))
                break;
            else
                System.out.println("Такой комманды не существует! ");

            threads.clear();
        }
    }
}
