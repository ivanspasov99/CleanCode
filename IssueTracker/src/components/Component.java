package components;

import users.enums.User;

import validators.Validator;

public class Component {

    private String name;
    private String abbreviation;

    private User creator;

    public Component(String name, String abbreviation, User creator) throws IllegalArgumentException {
        Validator.validateNullValues(name, abbreviation, creator );

        this.name = name;
        this.abbreviation = abbreviation;

        this.creator = creator;
    }

    public String getName() {
        return name;
    }
    public String getAbbreviation() {
        return abbreviation;
    }

    public User getCreator() {
        return creator;
    }
}
