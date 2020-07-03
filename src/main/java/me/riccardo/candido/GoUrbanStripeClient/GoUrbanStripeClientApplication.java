package me.riccardo.candido.GoUrbanStripeClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GoUrbanStripeClientApplication {

	public static void main(String[] args) {
		// init spring boot. I have added it but we do not need it
		// SpringApplication.run(GoUrbanStripeClientApplication.class, args);
		System.out.println("             _    _      _                 _ ");
		System.out.println("            | |  | |    | |               | |");
		System.out.println("  __ _  ___ | |  | |_ __| |__   __ _ _ __ | |");
		System.out.println(" / _` |/ _ \\| |  | | '__| '_ \\ / _` | '_ \\| |");
		System.out.println("| (_| | (_) | |__| | |  | |_) | (_| | | | |_|");
		System.out.println(" \\__, |\\___/ \\____/|_|  |_.__/ \\__,_|_| |_(_)");
		System.out.println("  __/ |                                      ");
		System.out.println(" |___/                                       ");


		while (true) {
			System.out.println("Welcome to the GoUrban Client for Stripe!");

			// Owner and Charge sub
			Transaction currTransaction = InputCollector.collectUserInputs();
			System.out.println("Transaction started");
			StripeClient sc = new StripeClient();
			sc.submitChargeToStripe(currTransaction);
			System.out.println("Transaction ended");

			// Capture or Refund sub
			if (InputCollector.confirmationFromUser()) {
				if (sc.submitCaptureToStripe()) System.out.println("Capture confirmed!");
				else System.out.println("Capture failed; we are sorry. There has been an issue.");
			} else {
				if (sc.submitRefundToStripe()) System.out.println("Refund confirmed!");
				else System.out.println("Refund failed; we are sorry. There has been an issue.");
			}
		}
	}
}
