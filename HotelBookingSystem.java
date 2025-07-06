import java.util.*;
public class HotelBookingSystem {
    private List<Room>rooms;
    private List<Customer>customers;
    private List<Booking>bookings;
    public HotelBookingSystem(){
        rooms=new ArrayList<>();
        customers=new ArrayList<>();
        bookings=new ArrayList<>();

    }
    public void addRoom(Room room){
        rooms.add(room);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
public void bookRoom(Room room,Customer customer,int nights){
    if(room.isAvailable()){
        room.bookRoom();
        Booking booking=new Booking(room,customer,nights);
        bookings.add(booking);
        System.out.println("Room booked Successfully");
    }
    else{
        System.out.println("Room is not availbale,Sorry!");
    }
}
public void cancelBooking(String roomId){
    Booking bookingToCancel=null;
    for(Booking booking:bookings){
        if(booking.getRoom().getRoomId().equals(roomId)){
            bookingToCancel=booking;
        }
    }
    if(bookingToCancel != null){
        bookingToCancel.getRoom().makeAvailable();
        bookings.remove(bookingToCancel);
        System.out.println("Booking Cancelled!");
    }
    else{
        System.out.println("No bookings found on that room id");
    }
}
public void showMenu(){
    Scanner sc=new Scanner(System.in);
    while(true){
        System.out.println("***HOTEL BOOKING SYSTEM***");
        System.out.println("1.View Available Rooms");
        System.out.println("2.Book a Room");
        System.out.println("3.Cancel a Booking");
        System.out.println("4.Exit");
        System.out.println("\nEnter the choice!:");

        int choice=sc.nextInt();
        sc.nextLine();
       
        switch(choice){
            case 1:
             System.out.println();
        System.out.println();
            System.out.println("\n ******Available Rooms******");
            for(Room room:rooms){
                if(room.isAvailable()){
                    System.out.println("Room Id: "+room.getRoomId()+", Room Type: "+room.getType()+" ,Room Price Per Night: $"+room.getPricePerNight());
                }
            }
            break;
             
            case 2:
            System.out.println("\n Enter your Name: ");
            String name=sc.nextLine();
             Customer customer = new Customer((customers.size() + 1), name);
            addCustomer(customer);

            
            System.out.println("\nAvailable Rooms:");
             for (Room room : rooms) {
                  if (room.isAvailable()) {
                       System.out.println("Room ID: " + room.getRoomId() + ", Type: " + room.getType() +
                             ", Price per Night: $" + room.getPricePerNight());
                    }
             }
             
             System.out.println("\n Enter the Room Id you want: ");
             String roomId=sc.nextLine();
             Room selectedRoom=null;
             for(Room room:rooms){
                if(room.getRoomId().equals(roomId) && room.isAvailable()){
                  selectedRoom=room;
                  break;
                }
             }

             if(selectedRoom != null){
                System.out.println("\n Enter number of Nights: ");
                int nights=sc.nextInt();
                sc.nextLine();
                double totalCost=selectedRoom.calculatePrice(nights);
                 System.out.printf("Total Cost: $%.2f%n", totalCost);
                 System.out.print("Confirm booking? (Y/N): ");
                 String confirm=sc.nextLine();
                 if(confirm.equalsIgnoreCase("Y")){
                    bookRoom(selectedRoom, customer, nights);
                 }else{
                    System.out.println("Booking is cancelled");
                 }
             }
             else{
                System.out.println("Invalid Selection");
             }
             break;

             case 3:
             System.out.print("\nEnter the Room ID to cancel booking: ");
            String cancelId = sc.nextLine();
            cancelBooking(cancelId);
            break;

            case 4:
                    System.out.println("Thank you for using the Hotel Booking System!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");

        }
    }
}
public static void main(String[] args) {
        HotelBookingSystem system = new HotelBookingSystem();
        system.addRoom(new Room("R001", "Single", 100.0));
        system.addRoom(new Room("R002", "Double", 150.0));
        system.addRoom(new Room("R003", "Suite", 250.0));
        system.addRoom(new Room("R004", "Single", 450.0));
        system.addRoom(new Room("R005", "Suite", 200.0));
        system.showMenu();
    }
}
