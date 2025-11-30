import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        startGame();
    }
    static void startGame() {
        while (true) {
            playRound();
            System.out.print("Хотите сыграть ещё раз? (y/n): ");
            String answer = scanner.nextLine().trim();
            while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
                System.out.print("Введите только y или n: ");
                answer = scanner.nextLine().trim();
            }
            if (answer.equalsIgnoreCase("n")) {
                System.out.println("Спасибо за игру!");
                break;
            }
        }
    }
    static void playRound() {
        int secret = random.nextInt(100) + 1; // число 1–100
        int attempts = 0;

        System.out.println("\nЯ загадал число от 1 до 100. Попробуй угадать!");

        while (true) {
            System.out.print("Ваш ответ: ");
            String input = scanner.nextLine().trim();

            if (!input.matches("\\d+")) {
                System.out.println("Ошибка: нужно вводить только числа!");
                continue;
            }
            int guess = Integer.parseInt(input);
            attempts++;
            if (guess > secret) {
                System.out.println("Слишком большое!");
            } else if (guess < secret) {
                System.out.println("Слишком маленькое!");
            } else {
                System.out.println("✔️ Вы угадали число!");
                System.out.println("Количество попыток: " + attempts);
                break;
            }
        }
    }
}