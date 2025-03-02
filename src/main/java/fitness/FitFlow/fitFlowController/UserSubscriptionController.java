package fitness.FitFlow.fitFlowController;

import fitness.FitFlow.model.UserSubscription;
import fitness.FitFlow.service.UserSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSubscriptionController {

    @Autowired
    UserSubscriptionService userSubscriptionService;

    @GetMapping("/userSubDetails/{id}")
    public UserSubscription getUserSubscription(@PathVariable int id){

        return userSubscriptionService.getUserSubscriptionById(id);
    }


}
