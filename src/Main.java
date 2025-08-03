import java.util.concurrent.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Random random = new Random();

        // 100 users trying to book random seats
        for (int i = 1; i <= 100; i++) {
            int seat = random.nextInt(50); // random seat between 0-49
            executor.execute(new UserBookingTask(bookingSystem, "User-" + i, seat));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Execution interrupted.");
        }

        System.out.println("\nAll booking attempts completed.");
    }
}
