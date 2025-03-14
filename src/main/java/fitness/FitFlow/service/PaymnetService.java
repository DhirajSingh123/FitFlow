package fitness.FitFlow.service;

import fitness.FitFlow.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.xml.crypto.Data;


@Service
public class PaymnetService {

    @Autowired
    UserService userService;

    public String getTotalAmount() {
        int total =0;
        List<User> listUser=userService.findAllUsers();

        for(User user:listUser){
            total =total+user.getAmount();
        }
        return "Total Payment are:"+ total;

    }

    public String getAmountByMonth(String month) {
        int total = 0;
        List<User> listUser = userService.findAllUsers();

        // Define the formatter to match "yyyy-MM" (Year-Month format)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

        for (User user : listUser) {
            if (user.getJoiningDate() != null) {
                // Convert java.util.Date to LocalDate
                LocalDate joiningDate = user.getJoiningDate().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();

                // Format joining date to "yyyy-MM" and compare with input month
                if (joiningDate.format(formatter).equals(month)) {
                    total += user.getAmount();
                }
            }
        }
        return "Total Payment are:"+ total+" for month of "+ month;
    }



}
