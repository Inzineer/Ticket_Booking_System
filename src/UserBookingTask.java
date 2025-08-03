class UserBookingTask implements Runnable {
    private final TicketBookingSystem bookingSystem;
    private final String userName;
    private final int seatToBook;

    public UserBookingTask(TicketBookingSystem system, String userName, int seatToBook) {
        this.bookingSystem = system;
        this.userName = userName;
        this.seatToBook = seatToBook;
    }

    @Override
    public void run() {
        bookingSystem.bookSeat(seatToBook, userName);
    }
}
