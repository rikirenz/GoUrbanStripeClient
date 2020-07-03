package me.riccardo.candido.GoUrbanStripeClient;

public class Transaction {

    private Double amount;
    private String emailAddress;
    private Boolean refund;

    /**
     * Class constructor.
     * @param emailAddress  string for user registration
     * @param amount  amount the user wants to move
     * @param refund  if true the transaction is a
     *               refund otherwise is a capture
     */

    public Transaction (String emailAddress, Double amount, Boolean refund) {
        this.amount = amount;
        this.emailAddress = emailAddress;
        this.refund = refund;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Boolean getRefund() {
        return refund;
    }

    public void setRefund(Boolean refund) {
        this.refund = refund;
    }

    public String toString() {
        return this.getEmailAddress() + ", " + this.getAmount() + ", refund: " + this.getRefund();
    }

}
