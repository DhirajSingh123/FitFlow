package fitness.FitFlow.basicsauth;

import fitness.FitFlow.model.User;
import fitness.FitFlow.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;


public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) {

        Optional<User> user= repo.findByPhoneNo(username);
        User u =user.orElseThrow(()-> new UsernameNotFoundException("User not found Exception"));




        return new LoginUser(u);
    }
}
