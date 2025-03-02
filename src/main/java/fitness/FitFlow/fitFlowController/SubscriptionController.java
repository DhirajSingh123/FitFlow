package fitness.FitFlow.fitFlowController;

import fitness.FitFlow.model.FitnessSubscription;
import fitness.FitFlow.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SubscriptionController {


    @Autowired
    SubscriptionService subscriptionService;

    @PostMapping("/saveSubscription")
    public String saveSubscription(@RequestBody FitnessSubscription fitnessSubscription){
        return subscriptionService.save(fitnessSubscription);
    }

    @GetMapping("/getSubscriptions")
    public List<FitnessSubscription> getAllSubscription(){
        return subscriptionService.getAllSubscription();
    }

    @GetMapping("/getSubscription/{id}")
    public FitnessSubscription getSubscriptionById(@PathVariable int fitnessId){
        return subscriptionService.getSubscriptionById(fitnessId);
    }

    @DeleteMapping("/deleteSubscription/{id}")
    public String deleteSubscriptionById(@PathVariable int fitnessId){
        return subscriptionService.deleteSubscriptionByFitnessId(fitnessId);
    }

    @PutMapping("/updateSubscription")
    public String updateSubscription(@RequestBody FitnessSubscription fitnessSubscription){
        return subscriptionService.updateSubscription(fitnessSubscription);
    }
}
