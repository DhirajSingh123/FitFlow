package fitness.FitFlow.model;

import org.springframework.stereotype.Component;


public class UserSubscription {
    private int fitnessId;
    private String name;
    private String subscriptionPlan;
    private String subscriptionOffer;
    private String getSubscriptionDetails;

    public int getFitnessId() {
        return fitnessId;
    }

    public void setFitnessId(int fitnessId) {
        this.fitnessId = fitnessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(String subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public String getSubscriptionOffer() {
        return subscriptionOffer;
    }

    public void setSubscriptionOffer(String subscriptionOffer) {
        this.subscriptionOffer = subscriptionOffer;
    }

    public String getGetSubscriptionDetails() {
        return getSubscriptionDetails;
    }

    public void setGetSubscriptionDetails(String getSubscriptionDetails) {
        this.getSubscriptionDetails = getSubscriptionDetails;
    }

    @Override
    public String toString() {
        return "UserSubscription{" +
                "fitnessId=" + fitnessId +
                ", name='" + name + '\'' +
                ", subscriptionPlan='" + subscriptionPlan + '\'' +
                ", subscriptionOffer='" + subscriptionOffer + '\'' +
                ", getSubscriptionDetails='" + getSubscriptionDetails + '\'' +
                '}';
    }
}
