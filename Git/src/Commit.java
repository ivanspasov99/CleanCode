package Resources;

import Drives.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Commit {
    private String str;
    private String hash;
    private String date;
    private Stage stage; // every commit has own stage , that was problem with files revert

    public Commit(Commit other) {
        this.str = other.str;
        this.hash = other.hash;
        this.date = other.date;
    }

    public Commit(String message, Stage stage) {
        this.str = message;
        this.date = generateDateString();
        hash = Hash.hexDigest(date + message);
        this.stage = stage;
    }

    public String getMessage() {
        return str;
    }

    private String generateDateString() {
        LocalDateTime dateTime = LocalDateTime.now();
        // cool thing to format by pattern
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm yyyy");
        return dateTime.format(dateTimeFormatter);


    }

    public String getHash() {
        return hash;
    }

    public String getDate() {
        return date;
    }

    public Stage getCommitStage() {
        return stage;
    }
    // put in StringFormatter??

}
