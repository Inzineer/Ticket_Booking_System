class TicketBookingSystem {
    private final boolean[] seats = new boolean[50]; // false = available, true = booked
    private final Object lock = new Object();

    // Try to book a specific seat number
    public boolean bookSeat(int seatNumber, String user) {
        if (seatNumber < 0 || seatNumber >= seats.length) {
                System.out.println(user + " tried to book invalid seat " + seatNumber);
                return false;
            }
        synchronized (lock) {
            if (!seats[seatNumber]) {
                seats[seatNumber] = true;
                System.out.println(user + " successfully booked seat " + (seatNumber + 1));
                return true;
            } else {
                System.out.println(user + " failed to book seat " + (seatNumber + 1) + " (Already Booked)");
                return false;
            }
        }
    }
}

