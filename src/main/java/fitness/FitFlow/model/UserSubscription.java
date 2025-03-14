package fitness.FitFlow.model;

import java.util.Date;


public class UserSubscription {
    private String name;
    private String phoneNo;
    private String subscriptionPlan;
    private String subscriptionOffer;
    private String getSubscriptionDetails;
    private int amountPaid;
    private int daysRemains;
    private Date subExpiryDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getSubExpiryDate() {
        return subExpiryDate;
    }

    public void setSubExpiryDate(Date subExpiryDate) {
        this.subExpiryDate = subExpiryDate;
    }

    public int getDaysRemains() {
        return daysRemains;
    }

    public void setDaysRemains(int daysRemains) {
        this.daysRemains = daysRemains;
    }

    @Override
    public String toString() {
        return "UserSubscription{" +
                "name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", subscriptionPlan='" + subscriptionPlan + '\'' +
                ", subscriptionOffer='" + subscriptionOffer + '\'' +
                ", getSubscriptionDetails='" + getSubscriptionDetails + '\'' +
                ", amountPaid=" + amountPaid +
                ", daysRemains=" + daysRemains +
                ", subExpiryDate=" + subExpiryDate +
                '}';
    }
}
