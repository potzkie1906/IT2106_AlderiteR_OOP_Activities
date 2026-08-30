import java.util.Scanner;
public class MyNewRepo {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Hello, World!");
            System.out.print("Enter your name: ");
            String name = input.nextLine();
            System.out.println("Nice to meet you, " + name + "!");
        }
    }
}
