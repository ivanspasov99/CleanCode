package users;

import validators.Validator;

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
