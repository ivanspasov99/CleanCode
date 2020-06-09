package users;

import validators.Validator;



public abstract class User {

    private String name;
    private String country;
    private String company;

    // add contracts

    public User(String name, String country, String company) throws IllegalArgumentException {

        Validator.validateNullValues(name, country, company);

        this.name = name;
        this.company = company;
        this.country = country;

    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setCompany(String company) {
        this.company = company;
    }


    public String getName() {
        return name;
    }
    public String getCountry() {
        return country;
    }
    public String getCompany() {
        return company;
    }
}
