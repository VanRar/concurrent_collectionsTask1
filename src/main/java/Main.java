import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {

        User user = new User();
        Support support = new Support();

        ConcurrentLinkedQueue<String> requestList = new ConcurrentLinkedQueue<>();

        Thread userRequest = new Thread(() -> user.request(60, requestList));
        userRequest.start();

        Thread supportCloseRequest1 = new Thread(() -> support.closeRequest(requestList, userRequest));
        Thread supportCloseRequest2 = new Thread(() -> support.closeRequest(requestList, userRequest));
        Thread supportCloseRequest3 = new Thread(() -> support.closeRequest(requestList, userRequest));

        supportCloseRequest1.start();
        supportCloseRequest2.start();
        supportCloseRequest3.start();
        //ну по сути они сами закроются по завершению
    }
}