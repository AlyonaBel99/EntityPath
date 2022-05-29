import java.util.List;

public class Solution {
    private static List<List<String>> costOfMove;
    private static final int SIZE = 4; // размер поля
    private static int[][] arraySquare; // поле
    private static int[][] cellStatus = new int[SIZE][SIZE];
    private static int[][] cellData = new int[SIZE][SIZE];

    public static int getResult(String square, String entityName){
        // работа с сущностью / сохранение данных
        Entity entity = new Entity(entityName);
        costOfMove = entity.getEntityDate();
        // работа с полем
        arraySquare = toArraySquare(square).clone();
        // расчет минимальной стоимости пути
        return minPathCost();
    }

    private static int minPathCost () {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                if (i == SIZE-1 && j == SIZE-1) break;
                   cellArea(i,j);
            }
        }
        return cellData[SIZE-1][SIZE-1];
    }

    private static void cellArea (int I, int J) {
        int currentPoss = cellData[I][J];
        // проверка диапозона
        switch (I) {
            case 0:
                // расчет минималного весса для указанной клетки
                putMinCellCost(currentPoss, I+1,J); // вниз
                if (J == 0) {
                    putMinCellCost(currentPoss, I,J+1); // вправо
                    break;
                }
                else {
                    putMinCellCost(currentPoss, I,J-1); // влево
                    if (J>0 && J < SIZE-1){
                        putMinCellCost(currentPoss, I,J+1); // вправо
                    }
                }
                break;
            case SIZE-1:
                putMinCellCost(currentPoss, I-1,J); // вверх
                putMinCellCost(currentPoss, I,J+1); // вправо
                if (J > 0) putMinCellCost(currentPoss, I,J-1); // влево
                break;
            default:
                putMinCellCost(currentPoss, I-1,J); // вверх
                putMinCellCost(currentPoss, I+1,J); // вниз
                if (J == 0){
                    putMinCellCost(currentPoss, I,J+1); // вправо
                    break;
                }
                if (J == SIZE-1){
                    putMinCellCost(currentPoss, I,J-1); // влево
                    break;
                }
                    putMinCellCost(currentPoss, I,J+1); // вправо
                    putMinCellCost(currentPoss, I,J-1); // влево
                break;
        }
    }

    private static void putMinCellCost (int cost, int I, int J) {
        int cellNextPoss = cost + arraySquare[I][J];
        if (cellStatus[I][J] == 0) {
            cellData[I][J] = cellNextPoss;
        }
        else
            if (cellNextPoss < cellData[I][J]) {
            cellData[I][J] = cellNextPoss;
            }
        cellStatus[I][J]++;
    }

    private static int[][] toArraySquare (String square) {
        int[][] result = new int[SIZE][SIZE];
        square = square.toLowerCase();
        for(int i=0; i < SIZE; i++){
            for (int j=0; j < SIZE; j++){
                 char a = square.charAt(j + i*4);
                 result[i][j] = move(a);
            }
        }
        return result;
    }

    private static int move (char symbol) {
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
