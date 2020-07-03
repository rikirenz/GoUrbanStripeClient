package me.riccardo.candido.GoUrbanStripeClient;

import java.util.HashMap;
import java.util.Map;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Refund;
import com.stripe.model.Source;

public class StripeClient {

    String chargeId;

    public StripeClient() {
        Stripe.apiKey = "sk_test_4eC39HqLyjWDarjtT1zdp7dc";
        this.chargeId = null;
    }

    public boolean submitChargeToStripe(Transaction currT) {
        try {
            // owner and source creation
            Map<String, Object> sourceParams = new HashMap<>();
            Map<String, Object> ownerParams = new HashMap<>();
            Map<String, Object> paramsCharge = new HashMap<>();

            // create source and owner
            sourceParams.put("type", "card");
            sourceParams.put("currency", "eur");
            sourceParams.put("token", "tok_at");
            ownerParams.put("email", currT.getEmailAddress());
            sourceParams.put("owner", ownerParams);
            Source s = Source.create(sourceParams);

            // create charge
            paramsCharge.put("amount", currT.getAmount());
            paramsCharge.put("currency", "eur");
            paramsCharge.put("source", s.getId());
            paramsCharge.put("capture", false);
            paramsCharge.put("description", "GoUrban Charge");
            Charge c = Charge.create(paramsCharge);
            this.chargeId = c.getId();
            return c.getStatus().equals("succeeded");
        } catch (StripeException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean submitCaptureToStripe() {
        try {
            if (this.chargeId == null) return false;
            Charge c = Charge.retrieve(this.chargeId);
            Charge newC = c.capture();
            return newC.getStatus().equals("succeeded");
        } catch (StripeException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean submitRefundToStripe()  {
        try {
            if (this.chargeId == null) return false;
            Map<String, Object> params = new HashMap<>();
            params.put("charge", this.chargeId);
            Refund r = Refund.create(params);
            return r.getStatus().equals("succeeded");
        } catch (StripeException e) {
            e.printStackTrace();
            return false;
        }
    }
}