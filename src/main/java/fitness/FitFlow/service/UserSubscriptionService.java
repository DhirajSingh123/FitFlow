package fitness.FitFlow.service;

import fitness.FitFlow.model.FitnessSubscription;
import fitness.FitFlow.model.User;
import fitness.FitFlow.model.UserSubscription;
import fitness.FitFlow.repo.SubscriptionRepo;
import fitness.FitFlow.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSubscriptionService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    SubscriptionRepo subscriptionRepo;

    public UserSubscription getUserSubscriptionById(int id) {


        Optional<User> user = userRepo.findById(id);
        UserSubscription userSubscription = new UserSubscription();
        Optional<FitnessSubscription> subscriptionDetail=null;

        if(user.isPresent()){
            int subId= user.get().getSubscriptionId();
            subscriptionDetail=subscriptionRepo.findById(subId);
            if(subscriptionDetail.isPresent()){
                userSubscription = prepareUserSubscription(user.get(),subscriptionDetail.get());
            }

        }


        return userSubscription;
    }

    private UserSubscription prepareUserSubscription(User user, FitnessSubscription subscriptionDetail) {

        UserSubscription userSubscription=new UserSubscription();
        userSubscription.setName(user.getName());
        userSubscription.setSubscriptionPlan(subscriptionDetail.getSubscriptionPlan());
        userSubscription.setFitnessId(user.getFitnessId());
        userSubscription.setSubscriptionOffer(subscriptionDetail.getSubscriptionOffer());
        userSubscription.setGetSubscriptionDetails(subscriptionDetail.getSubscriptionDetails());

        return userSubscription;
    }


}
