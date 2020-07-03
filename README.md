# GoUrbanStripeClient

Scope of the project:

- Write a small console client for Stripe for the following scenario:

1 - Ask user for email.

2 - User enters email.

3 - Create customer at stripe with the entered email address (Stripe API key: sk_test_4eC39HqLyjWDarjtT1zdp7dc)

4 - Create a credit card source in stripe with token tok_at and type card and attach it as default source to the created customer.

5 - Ask user for the amount of the charge in Euro.

6 - Create a charge for the requested amount.

7 - Ask the user if he wants to chapture the charge or refund it.

8 - Charge or refund the charge.
