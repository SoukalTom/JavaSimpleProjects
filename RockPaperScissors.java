import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        String[] rockPaperScissors = {"Kámen", "Nůžky", "Papír"};

        System.out.print("Zahrajeme si hru na 3 výhry. ");
        for (String playMove : rockPaperScissors) {
            System.out.print(playMove + ", ");
        }
        System.out.println("Teď!");

        int playerWinsCount = 0;
        int computerWinsCount = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Napiš Kámen, Nůžky nebo Papír:");
            if (contestantAndComputerPlay(scanner)) {
                playerWinsCount++;
                System.out.println("Skóre je: " + playerWinsCount + "-" + computerWinsCount + " pro tebe.");
                if (playerWinsCount == 3) {
                    System.out.println("Uživatel vyhrál " + playerWinsCount + "-" + computerWinsCount);
                    break;
                }
            } else {
                computerWinsCount++;
                System.out.println("Skóre je: " + playerWinsCount + "-" + computerWinsCount + " pro tebe.");
                if (computerWinsCount == 3) {
                    System.out.println("Počítač vyhrál " + computerWinsCount + "-" + playerWinsCount);
                    break;
                }
            }

        }

        scanner.close();

    }

    private static boolean contestantAndComputerPlay (Scanner scanner) {
        // Získá hodnotu hráče a počítače a posoudí kdo z nich vyhrál

        Random rand = new Random();
        String computerChoice;
        String playerChoice = " ";
        int computerNumber;
        int playerNumber;

        while (true) {
            computerNumber = rand.nextInt(3) + 1;

            computerChoice = switch (computerNumber) {
                case 1 -> "Kámen! ";
                case 2 -> "Nůžky! ";
                case 3 -> "Papír! ";
                default -> " ";
            };

            do {
                // Dohlíží zda uživatel zadal správnou hodnotu
                while (true) {
                    // Získá zadanou hodnotu hráče
                    String input = scanner.nextLine().toLowerCase();
                    if (input.length() >= 5) {
                        playerChoice = input.substring(0,5);
                        break;
                    } else {
                        System.out.println("Zadej správnou hodnotu!");
                    }
                }
                playerNumber = switch (playerChoice) {
                    // Posoudí jakou hodnotu uživatel zadal
                    case "kamen", "kámen" -> 1;
                    case "nuzky", "nůžky", "nužky", "nůzky" -> 2;
                    case "papir", "papír" -> 3;
                    default -> 0;
                };
                if (playerNumber == 0) {
                    System.out.println("Zadej správnou hodnotu!");
                }

            } while (playerNumber == 0);

            if (playerNumber == computerNumber) {
                System.out.println(computerChoice);
                System.out.println("Remíza!");
            } else {
                break;
            }
        }

        // Posoudí kdo vyhrál
        System.out.println(computerChoice);
        if (playerNumber == 1 && computerNumber == 2 ||
            playerNumber == 2 && computerNumber == 3 ||
            playerNumber == 3 && computerNumber == 1) {
            System.out.print("Vyhrál si! ");
            return true;
        } else {
            System.out.print("Prohrál si! ");
            return false;
        }
    }
}