package Drives;

import Files.File;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stage {
    private List<File> arr1 = new ArrayList<File>(); // forCommit
    private List<File> arr2 = new ArrayList<File>(); // forRemoval

    public Stage() {

    }
    public Stage(Stage other) {
        // it will not work with collection because of limited capacity
        for (File file : other.arr1) {
            this.arr1.add(new File(file));
        }
        for (File file : other.arr2) {
            this.arr2.add(new File(file));
        }
    }
    public List<File> getArr1() {
        return arr1;
    }
    public List<File> getArr2() {
        return arr2;
    }
}
