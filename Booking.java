public class Booking {
    private Room room;
    private Customer customer;
    private int nights;
    public Booking(Room room, Customer customer, int nights) {
        this.room = room;
        this.customer = customer;
        this.nights = nights;
    }
    public Room getRoom() {
        return room;
    }
    public Customer getCustomer() {
        return customer;
    }
    public int getNights() {
        return nights;
    }
    
}
