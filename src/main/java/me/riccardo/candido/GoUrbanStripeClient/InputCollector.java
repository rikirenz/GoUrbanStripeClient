package me.riccardo.candido.GoUrbanStripeClient;

import java.util.Scanner;

public class InputCollector {

    public static boolean confirmationFromUser() {
        Scanner keyboard = new Scanner(System.in);
        Boolean confirmation = false;
        while (true) {
            System.out.println("Write C to capture it or R to refund it.");
            String userChoice = keyboard.nextLine().trim();
            if (!InputValidator.CorR(userChoice)) continue;
            confirmation = userChoice.toUpperCase().equals("C");
            break;
        }
        return confirmation;
    }

    public static Transaction collectUserInputs() {
        Scanner keyboard = new Scanner(System.in);
        String mailAddress = "";
        Integer amount = 0;

        while (true) {
            System.out.println("Please enter your mail address");
            mailAddress = keyboard.nextLine().trim();
            if (!InputValidator.mailAddressInputValidation(mailAddress)) continue;
            break;
        }

        while (true) {
            System.out.println("Please enter the amount you would like to transfer (Euro)");
            String userAmount = keyboard.nextLine().trim();
            if (!InputValidator.amountValidation(userAmount)) continue;
            amount = Integer.valueOf(userAmount);
            break;
        }

        return new Transaction(mailAddress, amount);
    }

}
