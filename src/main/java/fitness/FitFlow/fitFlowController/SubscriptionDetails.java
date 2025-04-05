package fitness.FitFlow.fitFlowController;

import fitness.FitFlow.model.Subscription;
import fitness.FitFlow.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionDetails {


    @Autowired
    SubscriptionService subscriptionService;

    @PostMapping("/saveSubscription")
    public String saveSubscription(@RequestBody Subscription subscription){
        return subscriptionService.save(subscription);
    }

    @GetMapping("/getSubscriptions")
    public List<Subscription> getAllSubscription(){
        return subscriptionService.getAllSubscription();
    }

    @GetMapping("/getSubscription/{id}")
    public Subscription getSubscriptionById(@PathVariable int id){
        return subscriptionService.getSubscriptionById(id);
    }

    @DeleteMapping("/deleteSubscription/{id}")
    public String deleteSubscriptionById(@PathVariable int id){
        return subscriptionService.deleteSubscriptionByFitnessId(id);
    }

    @PutMapping("/updateSubscription")
    public String updateSubscription(@RequestBody Subscription subscription){
        return subscriptionService.updateSubscription(subscription);
    }
}
