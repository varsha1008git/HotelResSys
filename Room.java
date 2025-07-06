public class Room {
    private String roomId;
    private String type;
    private double pricePerNight;
    private boolean isAvailable;
    public Room(String roomId, String type, double pricePerNight) {
        this.roomId = roomId;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
    }
    public String getRoomId() {
        return roomId;
    }
    public String getType() {
        return type;
    }
    public double getPricePerNight() {
        return pricePerNight;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public double calculatePrice(int nights){
        return nights*pricePerNight;
    }
    public void bookRoom(){
        isAvailable=false;
    }
      public void makeAvailable() {
        isAvailable = true;
    }
}
