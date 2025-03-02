package fitness.FitFlow.service;

import fitness.FitFlow.model.FitnessSubscription;
import fitness.FitFlow.model.User;
import fitness.FitFlow.repo.SubscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {
    @Autowired
    SubscriptionRepo subscriptionRepo;

    public String save(FitnessSubscription fitnessSubscription) {
        try{
            Optional<FitnessSubscription> res=subscriptionRepo.findById(fitnessSubscription.getSubscriptionId());
            if(res.isEmpty()){
                subscriptionRepo.save(fitnessSubscription);
            }
            else {
                return "Subscription plan already exist please check ID";
            }
        }
        catch (Exception e){
            return "Subscription plan already exist please check ID";
        }

        return "Subscription plan save successfully";

    }

    public List<FitnessSubscription> findAllSubscription() {
        return subscriptionRepo.findAll();
    }

    public Optional<FitnessSubscription> getSubscriptionByFitnessId(int fitnessId) {
        return subscriptionRepo.findById(fitnessId);
    }

    public String deleteSubscriptionByFitnessId(int fitnessId) {
        subscriptionRepo.deleteById(fitnessId);
        return "Subscription deleted";
    }

    public String updateSubscription(FitnessSubscription fitnessSubscription) {

        Optional<FitnessSubscription> result = subscriptionRepo.findById(fitnessSubscription.getSubscriptionId());

        if (result.isPresent()) {
            subscriptionRepo.deleteById(fitnessSubscription.getSubscriptionId());
            subscriptionRepo.save(fitnessSubscription);
        } else {
            return "User not found for your given details::" + fitnessSubscription.getSubscriptionId();
        }
        return "User update successfully";
    }
}
