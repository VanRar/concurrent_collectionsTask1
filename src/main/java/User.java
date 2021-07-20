import java.util.concurrent.ConcurrentLinkedQueue;

public class User {
    private static final int REQUEST_PAUSE = 1000;

    public User() {
    }

    public void request(int count, ConcurrentLinkedQueue<String> requestList) {
        for (int i = 0; i < count; i++) {
            //сздаём заявку
            requestList.add("Пользователь №" + i + " оставил заявку");
            System.out.println("Пользователь №" + i + " оставил заявку"); //дублируем в консоль
            try {
                Thread.sleep(REQUEST_PAUSE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
