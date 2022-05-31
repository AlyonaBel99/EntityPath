import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Entity {
    private String name;
    private List<List<String>> records;

    public Entity(String name) {
        this.name = name;
    }

    public void validateEntityName() {
        Matcher matcher = Pattern.compile("^[A-Za-z]+").matcher(this.name);
        if (!matcher.matches()) {
            System.out.println("Entity name Сonnot invalid characters or empty, can only contain letters");
            System.exit(0);
        }
    }

    public void reader() {
        records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("entityData/" + name + ".csv"))) {
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
