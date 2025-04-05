package fitness.FitFlow.fitFlowController;

import fitness.FitFlow.service.PaymnetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentDetails {

    @Autowired
    PaymnetService paymentService;

    @GetMapping("/totalAmount")
    public Integer
    getTotalAmount(){
        return paymentService.getTotalAmount();
    }

    @GetMapping("/amount/{month}")
    public String getAmountByMonth(String month){
        return paymentService.getAmountByMonth(month);
    }
}

