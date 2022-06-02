import com.ginsberg.junit.exit.ExpectSystemExitWithStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class FieldTest {

    @Test
    @DisplayName("Should Not Validate Field String When String is null or invalid characters or size not 16")
    @ExpectSystemExitWithStatus(0)
    void shouldNotValidateFieldString() {
        Field field = new Field("Stwswtpt1p");
        field.validateFieldString();
    }

    @Test
    @DisplayName("Should Change Field String into square")
    void shouldToArraySquare() {
        Field field = new Field("Stwswtpptpttpwpp");
        List<List<String>> expected = List.of(Arrays.asList("s","w","t","p"),Arrays.asList("3","3","2","2"));
        field.setCostOfMove(expected);
        int[][] arr = new int[][]{{3,2,3,3},{3,2,2,2},{2,2,2,2},{2,3,2,2}};
        Assertions.assertArrayEquals(field.toArraySquare(),arr);
    }

    @Test
    @DisplayName("Should Not Change Field String into square When invalid characters")
    @ExpectSystemExitWithStatus(0)
    void notShouldToArraySquare() {
        Field field = new Field("StwswtpLtpttpwpp");
        List<List<String>> expected = List.of(Arrays.asList("s","w","t","p"),Arrays.asList("3","3","2","2"));
        field.setCostOfMove(expected);
        field.toArraySquare();
    }
}