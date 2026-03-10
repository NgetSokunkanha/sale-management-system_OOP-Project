package user;
public class Manager extends Staff {
    private double bonus;

    public Manager(String id, String username, String password, String gender, double bonus) {
        super(id, username, password, gender);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        if (bonus >= 0) {
            this.bonus = bonus;
        } else {
            this.bonus = 0;
        }
    }

    @Override
    public boolean can(String action) {
        if (action == null) return false;
        return action.equals(controller.MiniMartShop.CREATE_PRODUCT) ||
            action.equals(controller.MiniMartShop.VIEW_REPORT) ||
            action.equals(controller.MiniMartShop.VIEW_ORDER) ||
            action.equals(controller.MiniMartShop.UPDATE_DELIVERY_STATUS);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Manager)) return false;
        Manager other = (Manager) obj;
        return super.equals(obj) && this.bonus == other.bonus;
    }

    @Override
    public String toString() {
        return super.toString() + " Manager [bonus=" + bonus + "]";
    }   
  
}