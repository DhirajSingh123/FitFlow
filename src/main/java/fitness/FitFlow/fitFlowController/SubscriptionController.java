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
    public List<FitnessSubscription> getAllUsers(){
        return subscriptionService.findAllSubscription();
    }

    @GetMapping("/getSubscription/{id}")
    public Optional<FitnessSubscription> getFitnessSubscription(@PathVariable int fitnessId){
        return subscriptionService.getSubscriptionByFitnessId(fitnessId);
    }

    @DeleteMapping("/deleteSubscription/{id}")
    public String deleteUser(@PathVariable int fitnessId){
        return subscriptionService.deleteSubscriptionByFitnessId(fitnessId);
    }

    @PutMapping("/updateSubscription")
    public String updateUser(@RequestBody FitnessSubscription fitnessSubscription){
        return subscriptionService.updateSubscription(fitnessSubscription);
    }
}
