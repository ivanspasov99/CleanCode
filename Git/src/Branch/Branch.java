package Branch;

import Drives.Drive;
import Files.File;
import bg.sofia.uni.fmi.mjt.git.Commit;
import Drives.Stage;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String name;
    private Commit c = null; // we can use commits.get(commits.size()); for current commit
    private Stage stage;
    private Drive drive;
    private List<Commit> commits = new ArrayList<>();
    public Branch(Branch other, String name) {
        this.name = name;
        this.c = (other.c == null) ? null : new Commit(other.c);
        this.stage = new Stage(other.stage);
        this.drive = new Drive(other.drive);
        for (Commit commit : other.commits)
        {
            this.commits.add(new Commit(commit));
        }
    }
    public Branch(String name) {
        this.name = name;
        this.stage = new Stage();
        this.drive = new Drive();
}
    public String getName() {
        return name;
    }
    public void addCommit(Commit commit) {
        c = commit;
        commits.add(commit);
    }
    public Commit getCurrentCommit() {
        return c;
    }
    public void reset() {
        // GarbColl will do the rest
        this.stage = new Stage();
    }
    public Stage getStage() {
        return stage;
    }
    public List<Commit> getCommits() {
        return commits;
    }
    public void setCurrentCommit(Commit commit) {
        c = commit;
    }
    public Drive getDrive() {
        return drive;
    }
}
