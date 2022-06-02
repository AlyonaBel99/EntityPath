import com.ginsberg.junit.exit.ExpectSystemExitWithStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class EntityTest {

    @Test
    @DisplayName("Should read Entity When Entity Name is a Human")
    void shouldReadEntityDateHuman() {
        Entity entity = new Entity("Human");
        entity.reader();
        List<String> expected1 = Arrays.asList("s","w","t","p");
        List<String> expected2 = Arrays.asList("5","2","3","1");
        List<List<String>> expected = List.of(expected1,expected2);
        Assertions.assertEquals(entity.getEntityDate(),expected);
    }

    @Test
    @DisplayName("Should read Entity When Entity Name is a Swamper")
    void shouldReadEntityDateSwamper() {
        Entity entity = new Entity("Swamper");
        entity.reader();
        List<String> expected1 = Arrays.asList("s","w","t","p");
        List<String> expected2 = Arrays.asList("2","2","5","2");
        List<List<String>> expected = List.of(expected1,expected2);
        Assertions.assertEquals(entity.getEntityDate(),expected);
    }

    @Test
    @DisplayName("Should read Entity When Entity Name is a Woodman")
    void shouldReadEntityDateWoodman() {
        Entity entity = new Entity("Woodman");
        entity.reader();
        List<String> expected1 = Arrays.asList("s","w","t","p");
        List<String> expected2 = Arrays.asList("3","3","2","2");
        List<List<String>> expected = List.of(expected1,expected2);
        Assertions.assertEquals(entity.getEntityDate(),expected);
    }

    @Test
    @DisplayName("Should Not Read Entity When Entity Name is null or cannot invalid")
    @ExpectSystemExitWithStatus(0)
    void shouldNotReadEntityDate() {
        Entity entity = new Entity(null);
        entity.reader();
    }
}