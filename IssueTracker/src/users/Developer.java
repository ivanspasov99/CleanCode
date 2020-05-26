package users;

import validators.Validator;

public class Developer extends User {

    private final UserRole ROLE;
    private final DeveloperJobPosition JOB_POSITION;

    String techStack;


    public Developer(String name, String country, String company, DeveloperJobPosition position, String techStack) throws IllegalArgumentException {

        super(name, country, company);
        Validator.validateNullValues(techStack);

        ROLE = UserRole.Developer;
        JOB_POSITION = position;

        this.techStack = techStack;
    }

    public UserRole getRole() {
        return ROLE;
    }

    public DeveloperJobPosition getJobPosition() {
        return JOB_POSITION;
    }
}
