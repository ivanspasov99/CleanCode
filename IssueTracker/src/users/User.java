package users;

public class User {
    private String userName;

    public User(String userName) {
        //validators.ValidateNullValues.validatePar(new Object[] { userName });
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
