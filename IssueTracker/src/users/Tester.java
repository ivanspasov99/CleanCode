package users;

import users.enums.TesterType;


import users.enums.UserRole;

public class Tester extends User {

    private final UserRole ROLE;
    private final TesterType TESTER_TYPE;

    public Tester(String name, String country, String company, TesterType testerType) throws IllegalArgumentException {

        super(name, country, company);

        ROLE = UserRole.Tester;
        TESTER_TYPE = testerType;

    }

    public TesterType getTesterType() {
        return TESTER_TYPE;
    }
    public UserRole getRole() {
        return ROLE;
    }
}
