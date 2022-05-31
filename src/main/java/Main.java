import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String square = scanner.nextLine();
        String entity = scanner.nextLine();
        System.out.println(Solution.getResult(square,entity)); //("Stwswtpptpttpwpp", "Human");
    }
}

