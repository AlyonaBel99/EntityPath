import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static constant.Square.SIZE;

public class Field {

    private String fieldString;
    private List<List<String>> costOfMove;

    public Field(String fieldString) {
        this.fieldString = fieldString;
    }

    public void setCostOfMove(List<List<String>> costOfMove) {
        this.costOfMove = costOfMove;
    }

    public void validateFieldString() {
        Matcher matcher = Pattern.compile("^[A-Za-z]{16}").matcher(this.fieldString);
        if (!matcher.matches()) {
            System.out.println("Field string Сonnot invalid characters or empty," +
                    " can only contain letters and size equals to 16");
            System.exit(0);
        }
    }

    public int[][] toArraySquare () {
        int[][] result = new int[SIZE][SIZE];
        fieldString = fieldString.toLowerCase();
        for(int i=0; i < SIZE; i++){
            for (int j=0; j < SIZE; j++){
                char a = fieldString.charAt(j + i*4);
                result[i][j] = symbolMoveCost(a);
            }
        }
        return result;
    }

    private int symbolMoveCost (char symbol) {
        try {
            return Integer.parseInt(costOfMove.get(1).get(costOfMove.get(0).indexOf(String.valueOf(symbol))));
        }
        catch (Exception e){
            System.out.println("Input error, symbol '" + symbol + "' not true!");
        }
        System.exit(0);
        return 0;
    }
}
