package user;
public class Admin extends Staff {
    private String departmentName;

    public Admin(String id, String username, String password, String gender, String departmentName) 
        throws exception.InvalidDataException {
        super(id, username, password, gender);
        this.departmentName = departmentName;
    }
    
    public String getDepartmentName() { return departmentName; }

    public void setDepartmentName(String departmentName) throws exception.InvalidDataException {
        if (departmentName != null && !departmentName.trim().isEmpty()) {
            this.departmentName = departmentName.trim();
        } else {
            throw new exception.InvalidDataException("Department name can not be null or empty.");
        }
    }

    @Override
    public boolean can(String action) {
        return true; 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Admin)) return false;
        Admin other = (Admin) obj;
        return super.equals(obj) && this.departmentName.equals(other.departmentName);
    }

    @Override
    public String toString() {
        return super.toString() + " Admin [departmentName=" + departmentName + "]";
    }

    
}


