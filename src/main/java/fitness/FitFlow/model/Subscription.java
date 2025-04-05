package fitness.FitFlow.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "subscription")
@Component
public class Subscription {
    @Id
    @Column(name = "subscriptionId")
    private Integer subscriptionId;

    @Column(name = "subscriptionPlan")
    private String subscriptionPlan;

    @Column(name = "subscriptionOffer")
    private String subscriptionOffer;

    @Column(name = "subscriptionDetails")
    private String subscriptionDetails;

    private int subscriptionDiscount;

    private int subscriptionPrice;

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
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

    public String getSubscriptionDetails() {
        return subscriptionDetails;
    }

    public void setSubscriptionDetails(String subscriptionDetails) {
        this.subscriptionDetails = subscriptionDetails;
    }

    public int getSubscriptionDiscount() {
        return subscriptionDiscount;
    }

    public void setSubscriptionDiscount(int subscriptionDiscount) {
        this.subscriptionDiscount = subscriptionDiscount;
    }

    public int getSubscriptionPrice() {
        return subscriptionPrice;
    }

    public void setSubscriptionPrice(int subscriptionPrice) {
        this.subscriptionPrice = subscriptionPrice;
    }
}
