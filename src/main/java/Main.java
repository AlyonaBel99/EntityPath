import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String square = scanner.nextLine();
        String entity = scanner.nextLine();
        Matcher matcher = Pattern.compile("^[A-Za-z]{16}").matcher(square);
        Matcher matcher1 = Pattern.compile("^[A-Za-z]+").matcher(entity);
        if (matcher.matches() && matcher1.matches()) {
            Solution solution = new Solution();
            System.out.println(solution.getResult(square,entity)); //("Stwswtpptpttpwpp", "Human");
        }
        else {
            System.out.println("Input error!!! \nFirst string is " + matcher.matches() +
                    "\nSecond string is " + matcher1.matches());
        }
    }
}
