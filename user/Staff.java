
package user;
import exception.InvalidDataException; 

public abstract class Staff implements IStaff {
    private String id;
    private String username;
    private String password;
    private String gender;
    private boolean active;

    public Staff(String id, String username, String password, String gender) 
        throws InvalidDataException {

        setId(id);
        setUsername(username);
        setPassword(password);
        setGender(gender);    

        this.active = true;
    }

    @Override
    public abstract boolean can(String action);

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    protected String getPassword() {
        return password;
    }

    @Override
    public String getGender() {
        return gender;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public boolean checkPassword(String input) {
        return password != null && password.equals(input);
    }

    public void deactivate() {
        active = false;
    }

    public void setId(String id) throws InvalidDataException {
        if (id == null || id.trim().isEmpty()) {
            throw new InvalidDataException("Staff ID cannot be empty.");
        }

        id = id.trim();

        if (id.length() != 6) {
            throw new InvalidDataException("Staff ID must be exactly 6 digits.");
        }

        try {
            Integer.parseInt(id); 
        } catch (NumberFormatException e) {
            throw new InvalidDataException("Staff ID must contain only numbers.");
        }

        this.id = id;
    }

    public void setUsername(String username) throws InvalidDataException {
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidDataException("Username cannot be empty.");
        }
        username = username.trim();
        for (int i = 0; i < username.length(); i++) {
            if (!Character.isLetter(username.charAt(i))) {
                throw new InvalidDataException("Username must contain only letters.");
            }
        }
        this.username = username;
    }

    public void setPassword(String password) throws InvalidDataException {
        if (password == null || password.length() < 6) {
            throw new InvalidDataException("Password must be at least 6 digits.");
        }
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isDigit(password.charAt(i))) {
                throw new InvalidDataException("Password must contain only numbers.");
            }
        }
        this.password = password;
    }

    public void setGender(String gender) throws InvalidDataException {
        if (gender == null || gender.trim().isEmpty()) {
            throw new InvalidDataException("Gender cannot be empty.");
        }

        gender = gender.trim();

        if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")) {
            this.gender = gender;
        } else {
            throw new InvalidDataException("Gender must be 'Male' or 'Female' only.");
        }
    }
    

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Staff)) return false;

        Staff other = (Staff) obj;
        return id != null && id.equals(other.id);
    }

    @Override
    public String toString() {
        return "Staff {id=" + id +
        ", username=" + username + 
        ", gender=" + gender + 
        ", active=" + active + "}";
    }

}

