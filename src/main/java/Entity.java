import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Entity {
    private String name;
    private List<List<String>> records;

    public Entity(String name) {
        this.name = name;
        reader();
    }

    private void reader() {
        records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(name + ".csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));
            }
        } catch (Exception e) {
            System.out.println("File " + name + " not found!");
            System.exit(0);
        }
    }

    public List<List<String>> getEntityDate() {
        return records;
    }
}
