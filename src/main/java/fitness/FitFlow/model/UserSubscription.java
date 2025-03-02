package fitness.FitFlow.model;

import org.springframework.stereotype.Component;


public class UserSubscription {
    private int fitnessId;
    private String name;
    private String subscriptionPlan;

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

    @Override
    public String toString() {
        return "UserSubscription{" +
                "fitnessId=" + fitnessId +
                ", name='" + name + '\'' +
                ", subscriptionPlan='" + subscriptionPlan + '\'' +
                '}';
    }
}
