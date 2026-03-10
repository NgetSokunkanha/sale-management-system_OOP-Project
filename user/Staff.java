
package user;

public abstract class Staff implements IStaff {
    private String id;
    private String username;
    private String password;
    private String gender;
    private boolean active;

    public Staff(String id, String username, String password, String gender) {
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

    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id.trim();
        } else {
            this.id = "UNKNOWN";
        }
    }

    public void setUsername(String username) {
        if (username != null && !username.trim().isEmpty()) {
            this.username = username.trim();
        } else {
            this.username = "user" + this.id;
        }
    }

    public void setPassword(String password) {
        if (password != null && password.length() >= 6) {
            this.password = password;
        } else {
            this.password = "pw" + this.id;
        }
    }

    public void setGender(String gender) {
        if (gender != null &&
           (gender.equalsIgnoreCase("Male") ||
            gender.equalsIgnoreCase("Female"))) {
            this.gender = gender;
        } else {
            this.gender = "Unknown";
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

