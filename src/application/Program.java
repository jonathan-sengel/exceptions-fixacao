package application;

import entities.execptions.DomainException;
import entities.model.Account;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jow
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double initialBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimite = sc.nextDouble();

            Account account = new Account(number, holder, initialBalance, withdrawLimite);

            System.out.println("");
            System.out.print("Enter amount for withdraw: ");
            double amount = sc.nextDouble();
            account.withdraw(amount);
            System.out.println("New balance: " + String.format("%.2f", account.getBalance()));

        } catch (DomainException error) {
            System.out.println(error.getMessage());
        } catch (RuntimeException error) {
            System.out.println("Unexpected error");
            error.printStackTrace();
        } finally {
            sc.close();
        }
    }

}
