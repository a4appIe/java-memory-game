import java.util.Scanner;

class Game {

    // VARIABLEs FOR THE GAME
    private final String name;
    private StringBuilder computer = new StringBuilder();
    private int score;
    private boolean flag = true;
    private final Scanner scanner;

    // CONSTRUCTOR
    public Game(String name, Scanner scanner) {
        this.name = name;
        this.score = 0;
        this.scanner = scanner;
    }

    // GENERATE RANDOM CHARACTER FUNCTION
    private char randChar() {
        return (char)('0' + (int) (Math.random() * 10));
    }

    // GETTING THE INPUT FUNCTION
    private String getInput() {
        System.out.print(">>>  ");
        return scanner.nextLine();
    }

    // DELAY FUNCTION
    private void delay() {
        try {
            Thread.sleep((long) (0.6 * 1000));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    // CLEAR THE CONSOLE FUNCTION
    static void clear() {
        System.out.print("\033[H\033[2J");
    }

    // PRINT THE NEW LINE FUNCTION
    private void newLine() {
        System.out.println();
    }

    // HANDLING GAME-END FUNCTION
    private void gameEnd() {
        System.out.print("wait! we're checking your memory power");
        this.delay();
        System.out.print(".");
        this.delay();
        System.out.print(".");
        this.delay();
        System.out.print(".");
        this.delay();
        System.out.println(".");
        this.delay();
        Game.clear();
        if (this.score < 5) {
            System.out.println(this.name.toUpperCase() + ", your memory power is too low! DUMBOO"
                    + " | your score is only: " + this.score);
            this.newLine();
            System.out.println("keep practicing | keep playing 😊");
            this.newLine();
            System.out.println("bye👋");
        } else if (this.score < 10) {
            this.newLine();
            System.out.println(
                    this.name.toUpperCase() + ", your memory power is average!" + " | your score is: " + this.score);
            this.newLine();
            System.out.println("keep practicing | keep playing 😊");
            this.newLine();
            System.out.println("bye👋");
        } else {
            this.newLine();
            System.out.println(
                    this.name.toUpperCase() + ", your memory power is good!" + " | your score is: " + this.score);

            this.newLine();
            System.out.println("keep practicing | keep playing 😊");
            this.newLine();
            System.out.println("bye👋");
        }

        this.newLine();
    }

    // EASY GAME FUNCTION
    private void easy() {
        while (flag) {
            // APPEND THE CHAR TO COMPUTER VARIABLE
            computer.append(this.randChar());
            this.delay();

            // PRINT THE DISCLAIMER
            System.out.println("Note: Type without spaces!          Score: " + this.score);
            this.newLine();

            // PRINT THE LETTER ONE BY ONE
            System.out.print("check this:- [ ");
            for (int i = 0; i < computer.length(); ++i) {
                this.delay();
                System.out.print(computer.charAt(i) + " ");
                this.delay();
            }
            System.out.print("]");
            this.delay();

            // CLEAR THE CONSOLE
            Game.clear();

            // KEEP DISCLAIMER AND SCORE ON CONSOLE
            System.out.println("Note: Type without spaces!          Score: " + this.score);
            this.newLine();

            // GET INPUT FROM USER
            String input = this.getInput();
            Game.clear();

            // CHECK IF MATCHES WITH COMPUTER
            if (computer.toString().equals(input)) {
                this.score++;
                System.out.println("keep going");
                this.delay();
                Game.clear();
                this.delay();
                flag = true;
            } else {
                flag = false;
                this.gameEnd();
            }
        }
    }

    private void medium() {
        int size = 1;
        final int maxSize = 100;
        while (flag) {
            // APPEND THE CHAR TO COMPUTER VARIABLE
            for (int i = 0; i < size; i++) {
                computer.append(this.randChar());
            }
            size = Math.min(size + 1, maxSize);
            this.delay();

            // // PRINT THE DISCLAIMER
            System.out.println("Note: Type without spaces!          Score: " + this.score);
            this.newLine();

            // // PRINT THE LETTER ONE BY ONE
            System.out.print("try this:- [ ");
            for (int i = 0; i < computer.length(); ++i) {
                this.delay();
                System.out.print(computer.charAt(i) + " ");
                this.delay();
            }
            System.out.print("]");
            this.delay();

            // // CLEAR THE CONSOLE
            Game.clear();

            // // KEEP DISCLAIMER AND SCORE ON CONSOLE
            System.out.println("Note: Type without spaces!          Score: " + this.score);
            this.newLine();

            // // GET INPUT FROM USER
            String input = this.getInput();
            Game.clear();

            // // CHECK IF MATCHES WITH COMPUTER
            if (computer.toString().equals(input)) {
                this.score++;
                computer.setLength(0);
                this.delay();
                this.delay();
                Game.clear();
                this.delay();
                flag = true;
            } else {
                flag = false;
                this.gameEnd();
            }
        }
    }

    private void hard() {
        int size = 1;
        final int maxSize = 100;
        while (flag) {
            // APPEND THE CHAR TO COMPUTER VARIABLE
            for (int i = 0; i < size; i++) {
                computer.append(this.randChar());
            }
            size = Math.min(size + 1, maxSize);
            this.delay();

            // // PRINT THE LETTER ONE BY ONE
            for (int i = 0; i < computer.length(); ++i) {
                System.out.print(">> ");
                this.delay();
                System.out.print(computer.charAt(i) + " ");
                this.delay();
                Game.clear();
            }
            this.delay();

            // // CLEAR THE CONSOLE
            Game.clear();

            // // KEEP DISCLAIMER AND SCORE ON CONSOLE
            System.out.println("Note: Type without spaces!          Score: " + this.score);
            this.newLine();

            // // GET INPUT FROM USER
            String input = this.getInput();
            Game.clear();

            // // CHECK IF MATCHES WITH COMPUTER
            if (computer.toString().equals(input)) {
                this.score++;
                computer.setLength(0);
                this.delay();
                Game.clear();
                this.delay();
                flag = true;
            } else {
                flag = false;
                this.gameEnd();
            }
        }
    }

    // START FUNCTION
    public void start(int input) {
        switch (input) {
            case 1 -> this.easy();
            case 2 -> this.medium();
            case 3 -> this.hard();
            default -> System.out.println("Please make a valid choice next time");
        }
    }
}

public class MemoryGame {

    // GETTING THE NAME OF THE PLAYER
    public static String getName(Scanner scanner) {
        Game.clear();
        System.out.print("Your Good Name 😊 >>   ");
        return scanner.nextLine();
    }

    public static int input(Scanner scanner) {
        System.out.print("Set difficulty 💀 (1: easy, 2: medium, 3: hard) >>   ");
        int difficulty = scanner.nextInt();
        scanner.nextLine();  // Consume the leftover newline character
        return difficulty;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = getName(scanner);
        int input = input(scanner);
        Game game = new Game(name, scanner);
        game.start(input);
        scanner.close();
    }
}
