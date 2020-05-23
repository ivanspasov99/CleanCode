package generators;

public abstract class IdGenerator {
    private static int idCounter;

    public static int generateUniqueId() {
        return  idCounter++;
    }
}
