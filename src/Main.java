import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Thread> threads = new ArrayList<>();
    static final int NUMBEROFTHREADS = 5;
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String task = null;

        while (true) {
            System.out.println("**********************" +
                    "\nКоманды:" +
                    "\n\t1 - запустить потоки " +
                    "\n\t" + "2 - закончить выполнение программы" +
                    "\n**********************\n ");

            try {
                task = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (task.equals("1")) {

                for (int i = 0; i < NUMBEROFTHREADS; i++) {
                    threads.add(new Thread(new MyThread(String.valueOf(i))));
                    threads.get(i).start();
                }

                for (Thread thread : threads)
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            } else if (task.equals("2"))
                break;
            else
                System.out.println("Такой комманды не существует! ");

        }
    }
}
