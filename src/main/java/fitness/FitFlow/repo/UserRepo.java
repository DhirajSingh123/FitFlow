package fitness.FitFlow.repo;

import fitness.FitFlow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

//    @Query("SELECT u FROM User u JOIN FETCH u.subscription s WHERE u.userId = :userId")
//    UserSubscription findByUserId(int id);

//    @Query("SELECT u FROM User u JOIN FETCH u.subscription s WHERE u.fitnessId = :userId")
//    User findByUserId(@Param("userId") int userId);

}
