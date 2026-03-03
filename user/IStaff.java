package user;

public interface IStaff {

    String getId();
    String getUsername();
    boolean checkPassword(String input);
    String getGender();
    String getRole();
    
    boolean can(String action);

}