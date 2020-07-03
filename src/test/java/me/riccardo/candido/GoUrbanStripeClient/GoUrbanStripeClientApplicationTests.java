package me.riccardo.candido.GoUrbanStripeClient;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static me.riccardo.candido.GoUrbanStripeClient.InputValidator.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class GoUrbanStripeClientApplicationTests {


	/* *
	* Here I am going to test only the class InputValidator
	* */

	@Test
	public void test_empty_mail_validation(){
		String mail = "";
		assertFalse(mailAddressInputValidation(mail));
	}

	@Test
	public void test_wrong_mail_validation(){
		String mail = "goUrban@";
		assertFalse(mailAddressInputValidation(mail));
	}

	@Test
	public void test_correct_mail_validation(){
		String mail = "riccardo@goUrban.com";
		assertTrue(mailAddressInputValidation(mail));
	}

	@Test
	public void test_empty_amount_validation(){
		String amount = "";
		assertFalse(amountValidation(amount));
	}

	@Test
	public void test_wrong_amount_validation(){
		String amount = "213##";
		assertFalse(amountValidation(amount));
	}

	@Test
	public void test_correct_amount_validation(){
		String amount = "1234";
		assertTrue(amountValidation(amount));
	}


	@Test
	public void test_empty_user_input_validation(){
		String userInput = "";
		assertFalse(CorR(userInput));
	}

	@Test
	public void test_wrong_user_input_validation(){
		String userInput = "ccc";
		assertFalse(CorR(userInput));
	}

	@Test
	public void test_correct_mail_validation_R(){
		String userInput = "R";
		assertTrue(CorR(userInput));
	}

	@Test
	public void test_correct_mail_validation_C(){
		String userInput = "c";
		assertTrue(CorR(userInput));
	}
}
