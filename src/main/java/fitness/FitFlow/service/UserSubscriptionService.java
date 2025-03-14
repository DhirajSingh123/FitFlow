package fitness.FitFlow.service;

import fitness.FitFlow.model.Subscription;
import fitness.FitFlow.model.User;
import fitness.FitFlow.model.UserSubscription;
import fitness.FitFlow.repo.SubscriptionRepo;
import fitness.FitFlow.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class UserSubscriptionService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    SubscriptionRepo subscriptionRepo;

    public UserSubscription getUserSubscriptionById(String phoneNo) {


        Optional<User> user = userRepo.findByPhoneNo(phoneNo);
        UserSubscription userSubscription = new UserSubscription();
        Optional<Subscription> subscriptionDetail=null;

        if(user.isPresent()){
            int subId= user.get().getSubscriptionId();
            subscriptionDetail=subscriptionRepo.findById(subId);
            if(subscriptionDetail.isPresent()){
                userSubscription = prepareUserSubscription(user.get(),subscriptionDetail.get());
            }

        }


        return userSubscription;
    }

    private UserSubscription prepareUserSubscription(User user, Subscription subscriptionDetail) {

        UserSubscription userSubscription=new UserSubscription();
        userSubscription.setName(user.getName());
        userSubscription.setSubscriptionPlan(subscriptionDetail.getSubscriptionPlan());
        userSubscription.setPhoneNo(user.getPhoneNo());
        userSubscription.setSubscriptionOffer(subscriptionDetail.getSubscriptionOffer());
        userSubscription.setGetSubscriptionDetails(subscriptionDetail.getSubscriptionDetails());
        userSubscription.setSubExpiryDate(getSubscriptionExpiryDate(user.getJoiningDate(),user.getSubscriptionId()));
        userSubscription.setDaysRemains(getExpiryDays(user.getJoiningDate(),user.getSubscriptionId()));
        userSubscription.setAmountPaid(user.getAmount());
        return userSubscription;
    }

    public Date getSubscriptionExpiryDate(Date joingDate,int subscriptionId){
        Date currentDate = new Date();
        long diffInMillis = joingDate.getTime() - currentDate.getTime();
        int res=(int) TimeUnit.MILLISECONDS.toDays(diffInMillis);
        int remaningDays =0;

        if(subscriptionId==300){
            remaningDays=res+90;
        }
        if(subscriptionId==600){
            remaningDays=res+180;
        }
        else if(subscriptionId==900){
            remaningDays= res+270;
        } else if (subscriptionId==1200) {
            remaningDays=  res+365;

        }
        else if(subscriptionId==100){
            remaningDays=  res+30;
        }

        // Convert milliseconds to days
      return addDaysToDate(remaningDays);
    }

    public int getExpiryDays(Date joingDate,int subscriptionId){
        Date currentDate = new Date();
        long diffInMillis = joingDate.getTime() - currentDate.getTime();
        int res=(int) TimeUnit.MILLISECONDS.toDays(diffInMillis);
        int remaningDays =0;

        if(subscriptionId==300){
            remaningDays=90+res;
        }
        else if(subscriptionId==600){
            remaningDays= 180+res;
        } else if(subscriptionId==900){
            remaningDays= 270+res;
        }
        else if (subscriptionId==1200) {
            remaningDays=  365+res;

        }
        else if(subscriptionId==100){
            remaningDays=  30+res;
        }

        // Convert milliseconds to days
        return remaningDays;
    }

    public static Date addDaysToDate(int days) {
        Calendar calendar = Calendar.getInstance(); // Get current date
        calendar.add(Calendar.DAY_OF_MONTH, days); // Add days
        return calendar.getTime(); // Return updated date
    }
}
