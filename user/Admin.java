package user;
public class Admin extends Staff {

    public Admin(Staff s1) {
        super(s1.getId(), s1.getUsername(), s1.getPassword(), s1.getGender(), "Admin");
    }

    @Override
    public boolean can(String action) {
        return true; 
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}


