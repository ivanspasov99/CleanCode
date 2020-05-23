package validators;

public abstract class Validator {

    public static void validateNullValues(Object... parameters) {
        for (Object currentParameter: parameters) {
            if(currentParameter == null) {
                throw new IllegalArgumentException();
            }
        }
    }

}

