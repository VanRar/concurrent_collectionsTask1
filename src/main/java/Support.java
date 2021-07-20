import java.util.concurrent.ConcurrentLinkedQueue;

public class Support {

    public static final int SUPPORT_SLEEP = 3000;

    public Support() {
    }

    public void closeRequest(ConcurrentLinkedQueue<String> requestList, Thread userRequest) {
        String request;
        //как-то топорно смотриться и или и потом иф, но так работает без null, да ещё и поток запросов передаём)
        while ((request = requestList.poll()) != null || userRequest.isAlive()) {   //!requestList.isEmpty() не подходит
            if (request == null) continue;
            System.out.println(Thread.currentThread().getName() + " закрыл заявку от " + request);
            try {
                Thread.sleep(SUPPORT_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(Thread.currentThread().getName() + " у меня больше заявок нет");
    }

}
