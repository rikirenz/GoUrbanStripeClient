# GoUrbanStripeClient

Scope of the project:

- Write a small console client for Stripe for the following scenario:

1 - Ask user for email.

2 - User enters email.

3 - Create customer at Stripe with the entered email address (Stripe API key: sk_test_4eC39HqLyjWDarjtT1zdp7dc)

4 - Create a credit card source in sStripe with token tok_at and type card and attach it as default source to the created customer.

5 - Ask user for the amount of the charge in Euro.

6 - Create a charge for the requested amount.

7 - Ask the user if he wants to capture the charge or refund it.

8 - Charge or refund the charge.

# Riccardo's Notes:

Here what I have done:

- I have created a gradle project. I have imported Spring Boot ( because it was suggested; but I have not used any 
feature of this framework).
- I have imported Apache commons for input validation
- I have imported the Stripe library to perform the operations on credit cards 
- I have created:
    - InputCollector class to take input from the client
    - InputValidator class to validate user inputs (this class have been unit tested; check test package)
    - Transaction class is an object where I store the amount and the owner of the transaction
    - StripeClient class is a Stripe client which takes a transaction as input and calls the Stripe api