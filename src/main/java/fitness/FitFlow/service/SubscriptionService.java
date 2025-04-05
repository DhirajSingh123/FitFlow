package fitness.FitFlow.service;

import fitness.FitFlow.model.Subscription;
import fitness.FitFlow.repo.SubscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {
    @Autowired
    SubscriptionRepo subscriptionRepo;

    public String save(Subscription subscription) {
        try{
//            Optional<Subscription> res=subscriptionRepo.findById(subscription.getSubscriptionId());
//            if(res.isEmpty()){
                subscriptionRepo.save(subscription);
//            }
//            else {
//                return "Subscription plan already exist please check ID";
//            }
        }
        catch (Exception e){
            return e.getMessage();
        }

        return "Subscription plan save successfully";

    }

    public List<Subscription> getAllSubscription() {
        return subscriptionRepo.findAll();
    }

    public Subscription getSubscriptionById(int subscriptionId) {
        try {
            Optional<Subscription> res = subscriptionRepo.findById(subscriptionId);
            return res.orElseThrow(() -> new RuntimeException("Subscription not found with id: " + subscriptionId));
        }
        catch (Exception e){
            return null;

        }
    }

    public String deleteSubscriptionByFitnessId(int subscriptionId) {
        Optional<Subscription> res = subscriptionRepo.findById(subscriptionId);
        if(res.isPresent()){
            subscriptionRepo.deleteById(subscriptionId);
            return "Subscription deleted";
        }
        return "Subscription not found";
    }

    public String updateSubscription(Subscription subscription) {

        Optional<Subscription> result = subscriptionRepo.findById(subscription.getSubscriptionId());

        if (result.isPresent()) {
            subscriptionRepo.deleteById(subscription.getSubscriptionId());
            subscriptionRepo.save(subscription);
        } else {
            return "User not found for your given details::" + subscription.getSubscriptionId();
        }
        return "User update successfully";
    }
}
