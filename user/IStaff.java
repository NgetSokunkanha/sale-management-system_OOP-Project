package user;

public interface IStaff {

    String getId();
    String getUsername();
    boolean checkPassword(String input);
    String getGender();
    
    boolean can(String action);

}