package me.riccardo.candido.GoUrbanStripeClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class GoUrbanStripeClientApplication {

	public static void main(String[] args) {
		// init spring boot
		SpringApplication.run(GoUrbanStripeClientApplication.class, args);

		System.out.println("Welcome to the GoUrban Client for Stripe!");
		Transaction currTransaction = collectUserInputs();
		System.out.println("Transaction started");
		System.out.println("Transaction: " +  currTransaction.toString());


		System.out.println("Transaction ended");
	}

	public static Transaction collectUserInputs() {
		Scanner keyboard = new Scanner(System.in);
		String mailAddress = "";
		Double amount = 0.0;
		Boolean refund = false;

		while (true) {
			System.out.println("Please enter your mail address");
			mailAddress = keyboard.nextLine().trim();
			if (InputValidator.mailAddressInputValidation(mailAddress) == false) continue;
			break;
		}

		while (true) {
			System.out.println("Please enter the amount you would like to transfer (€)");
			String userAmount = keyboard.nextLine().trim();
			if (InputValidator.amountValidation(userAmount) == false) continue;
			amount = Double.valueOf(userAmount);
			break;
		}

		while (true) {
			System.out.println("Write C to capture it or R to refund it.");
			String userChoice = keyboard.nextLine().trim();
			if (InputValidator.CorR(userChoice) == false) continue;
			refund = userChoice.toUpperCase().equals("R");
			break;
		}


		return new Transaction(mailAddress, amount, refund);
	}
}
