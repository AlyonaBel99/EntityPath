import com.ginsberg.junit.exit.ExpectSystemExitWithStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("Should get result when Field String and Entity Name is true")
    void shouldGetResult() {
        Assertions.assertEquals(Solution.getResult("Stwswtpptpttpwpp","Swamper"),15);
    }

    @Test
    @DisplayName("Should not get result when Field String is false")
    @ExpectSystemExitWithStatus(0)
    void shouldNotGetResultField() {
        Solution.getResult("Stws","Human");
    }

    @Test
    @DisplayName("Should not get result when Entity Name is false")
    @ExpectSystemExitWithStatus(0)
    void shouldNotGetResultEntity() {
        Solution.getResult("Stwswtpptpttpwpp","Hu");
    }
}