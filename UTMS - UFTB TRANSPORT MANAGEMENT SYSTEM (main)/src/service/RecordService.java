package service;

import model.Assignment;
import storage.FileManager;

public class RecordService {

    public static void saveRecord(Assignment assignment) {
        FileManager.save(assignment.toFileString());
    }

    public static String loadRecords() {
        return FileManager.load();
    }
}
