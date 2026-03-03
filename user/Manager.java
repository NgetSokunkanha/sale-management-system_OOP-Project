package user;
public class Manager extends Staff {


    public Manager(Staff s1) {
        super(s1.getId(), s1.getUsername(), s1.getPassword(), s1.getGender(), "Manager");
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