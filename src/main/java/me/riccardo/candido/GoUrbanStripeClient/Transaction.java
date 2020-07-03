package me.riccardo.candido.GoUrbanStripeClient;

public class Transaction {

    private Integer amount;
    private String emailAddress;

    /**
     * Class constructor.
     * @param emailAddress  string for user registration
     * @param amount  amount the user wants to move
     *
     */

    public Transaction (String emailAddress, Integer amount) {
        this.amount = amount;
        this.emailAddress = emailAddress;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String toString() {
        return this.getEmailAddress() + ", " + this.getAmount();
    }

}
