package me.riccardo.candido.GoUrbanStripeClient;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.math.NumberUtils;


/** Validator checks for user Input.
 * @author Riccardo Candidod
 * @version 1.0
 */
public class InputValidator {


    public static boolean mailAddressInputValidation(String email) {
        if (email == null && email.length() == 0) return false;
        EmailValidator eValidator = EmailValidator.getInstance();
        return eValidator.isValid(email);
    }

    public static boolean amountValidation(String amount) {
        if (amount == null && amount.length() == 0) return false;
        return (NumberUtils.isNumber(amount) && Double.valueOf(amount) > 0);
    }

    public static boolean CorR(String userInput) {
        if (userInput == null && userInput.length() == 0) return false;
        return (userInput.toUpperCase().equals("C") || userInput.toUpperCase().equals("R"));
    }




}
