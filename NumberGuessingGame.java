import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        System.out.println("Zkus uhodnout číslo 1-100: ");

        while (true) {

            Scanner numScanner = new Scanner(System.in);

            try {
                int userNumber = numScanner.nextInt();
                if (userNumber >= 1 && userNumber <= 100) {
                    if (userNumber == randomNumber) {
                        System.out.println("Vyhrál si! Uhodnul si správné číslo!");
                        break;
                    } else if (userNumber < randomNumber) {
                        System.out.println("Číslo je větší. Hádej znovu.");
                    } else {
                        System.out.println("Číslo je menší. Hádej znovu.");
                    }

                }else {
                    System.out.println("Zadej správné číslo!");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Zadej validní číslo!");
            }




        }


    }
}
