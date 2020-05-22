package Files;

public class File {
    private String str;

    public File(String str) {
        this.str = str;
    }

    public File(File other) {
        this.str = other.str;
    }

    public String getName() {
        return str;
    }

    // override because of contains function in repository class
    // files are same if name is same
    @Override
    public boolean equals(Object obj) {
        File f = (File) obj;
        return this.str.equals(f.getName());
    }

    // we need to make sure that hashcode will return same value for equal() objects
    @Override
    public int hashCode() {
        return str.hashCode();
    }
}
