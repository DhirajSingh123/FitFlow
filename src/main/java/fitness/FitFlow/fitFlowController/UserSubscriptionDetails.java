package fitness.FitFlow.fitFlowController;

import fitness.FitFlow.model.UserSubscription;
import fitness.FitFlow.service.UserSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSubscriptionDetails {

    @Autowired
    UserSubscriptionService userSubscriptionService;

    @GetMapping("/userSubDetails/{phoneNo}")
    public UserSubscription getUserSubscription(@PathVariable String phoneNo){

        return userSubscriptionService.getUserSubscriptionById(phoneNo);
    }


}
