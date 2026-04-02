package user;

public class Delivery extends Staff{
    private String vehicleType;

    public Delivery(String id, String username, String password, String gender, String vehicleType) 
        throws exception.InvalidDataException {
        super(id, username, password, gender);
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) throws exception.InvalidDataException {
        if (vehicleType != null && !vehicleType.trim().isEmpty()) {
            this.vehicleType = vehicleType.trim();
        } else {
            throw new exception.InvalidDataException("Vehicle type cannot be null or empty.");
        }
    }

    @Override
    public boolean can(String action) {
        if (action == null) return false;

        return action.equals(controller.MiniMartShop.VIEW_REPORT) ||
               action.equals(controller.MiniMartShop.VIEW_ORDER) ||
               action.equals(controller.MiniMartShop.UPDATE_DELIVERY_STATUS);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Delivery)) return false;
        Delivery other = (Delivery) obj;
        return super.equals(obj) &&
               this.vehicleType.equals(other.vehicleType);
    }

    @Override
    public String toString() {
        return super.toString() + " Delivery [vehicleType=" + vehicleType + "]";
    }   
}