import static constant.Square.SIZE;

public class Solution {
    private static int[][] arraySquare;
    private static int[][] cellStatus = new int[SIZE][SIZE];
    private static int[][] cellData = new int[SIZE][SIZE];

    public static int getResult(String fieldString, String entityName){
        Entity entity = new Entity(entityName);
        Field field = new Field(fieldString);
        validateEntityAndFiled(entity,field); // проверка входных данных
        entity.reader();// работа с сущностью / сохранение данных
        field.setCostOfMove(entity.getEntityDate());
        arraySquare = field.toArraySquare().clone(); // работа с полем
        return minPathCost(); // расчет минимальной стоимости пути
    }

    private static void validateEntityAndFiled(Entity entity, Field field) {
        entity.validateEntityName();
        field.validateFieldString();
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
        switch (I) { // проверка диапозона// расчет минималного весса для указанной клетки
            case 0 -> {
                putMinCellCost(currentPoss, I + 1, J); // вниз
                if (J == 0) {
                    putMinCellCost(currentPoss, I, J + 1); // вправо
                } else {
                    putMinCellCost(currentPoss, I, J - 1); // влево
                    if (J < SIZE - 1) {
                        putMinCellCost(currentPoss, I, J + 1); // вправо
                    }
                }
            }
            case SIZE - 1 -> {
                putMinCellCost(currentPoss, I - 1, J); // вверх
                putMinCellCost(currentPoss, I, J + 1); // вправо
                if (J > 0) putMinCellCost(currentPoss, I, J - 1); // влево
            }
            default -> {
                putMinCellCost(currentPoss, I - 1, J); // вверх
                putMinCellCost(currentPoss, I + 1, J); // вниз
                if (J == 0) {
                    putMinCellCost(currentPoss, I, J + 1); // вправо
                    break;
                }
                if (J == SIZE - 1) {
                    putMinCellCost(currentPoss, I, J - 1); // влево
                    break;
                }
                putMinCellCost(currentPoss, I, J + 1); // вправо
                putMinCellCost(currentPoss, I, J - 1); // влево
            }
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
}
