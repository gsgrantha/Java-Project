package storage;

import java.io.*;

public class FileManager {

    private static final String FILE_PATH =
            System.getProperty("user.dir") + File.separator + "data" + File.separator + "records.txt";

    public static void save(String data) {
        try {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs(); // auto-create folder if missing
            FileWriter fw = new FileWriter(file, true);
            fw.write(data + System.lineSeparator());
            fw.close();
            System.out.println("✅ Data saved to: " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String load() {
        StringBuilder sb = new StringBuilder();
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return "No records found!";
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            br.close();
        } catch (IOException e) {
            return "Error reading records!";
        }
        return sb.toString();
    }
}
