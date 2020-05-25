package users;

import validators.Validator;

// we need to add more Users with different roles/properties

public class User {

    private String name;

    public User(String name) throws IllegalArgumentException {

        Validator.validateNullValues(name);
        this.name = name;

    }

    public String getName() {
        return name;
    }
}
