package users;

public class Manager extends User {

    private final UserRole ROLE;

    public Manager(String name, String country, String company) throws IllegalArgumentException {

        super(name, country, company);

        ROLE = UserRole.Manager;

    }

    public UserRole getRole() {
        return ROLE;
    }
}
