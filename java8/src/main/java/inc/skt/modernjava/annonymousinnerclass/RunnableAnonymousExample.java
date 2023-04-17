package inc.skt.modernjava.annonymousinnerclass;

public class RunnableAnonymousExample {
    public static void main(String[] args) {
        // Anonymous Inner Class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable Anonymous Inner class");
            }
        }).start();

        // Java 8 Lambda expression
        new Thread(() -> System.out.println("Inside lambda")).start();
    }
}
