import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Call_Center {
    private static final int CALLS = 60;
    private static final Queue <String> phoneCalls = new ArrayBlockingQueue<>(CALLS);
    private static final int PAUSE = 100;
    private static final int ANSWER = 3000;

    public void call() {
        try{
            for (int i = 0; i < CALLS; i++) {
                phoneCalls.offer("Звонок №" + i);
                System.out.println("Поступил звонок №" + i);
                Thread.sleep(PAUSE);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takingCall() {
        while(!phoneCalls.isEmpty()) {
            try {
                Thread.sleep(ANSWER);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (phoneCalls.peek() != null) {
                System.out.println("Оператор " + Thread.currentThread().getName() + " ответил на звонок " + phoneCalls.poll());
            } else {
                Thread.currentThread().interrupt();
                System.out.println("Оператор прекратил свою работу, звонки кончились");
            }

        }
    }

}
