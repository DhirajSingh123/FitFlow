package fitness.FitFlow.fitFlowController;

import fitness.FitFlow.model.User;
import fitness.FitFlow.service.PaymnetService;
import fitness.FitFlow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    PaymnetService paymentService;

    @GetMapping("/totalAmount")
    public String getTotalAmount(){
        return paymentService.getTotalAmount();
    }

    @GetMapping("/amount/{month}")
    public String getAmountByMonth(String month){
        return paymentService.getAmountByMonth(month);
    }
}
