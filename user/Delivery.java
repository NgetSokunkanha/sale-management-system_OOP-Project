package user;

public class Delivery extends Staff{

    public Delivery(Staff s2) {
        super(s2.getId(), s2.getUsername(), s2.getPassword(), s2.getGender(), "Delivery");
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
        return super.equals(obj);
    }

}