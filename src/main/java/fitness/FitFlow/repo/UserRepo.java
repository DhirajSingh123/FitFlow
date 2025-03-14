package fitness.FitFlow.repo;

import fitness.FitFlow.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.phoneNo = :phoneNo")
    Optional<User> findByPhoneNo(@Param("phoneNo") String phoneNo);

    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.phoneNo = :phoneNo")
    void deleteUserByPhoneNo(@Param("phoneNo") String phoneNo);

//    @Query("SELECT u FROM User u JOIN FETCH u.subscription s WHERE u.userId = :userId")
//    UserSubscription findByUserId(int id);

//    @Query("SELECT u FROM User u JOIN FETCH u.subscription s WHERE u.fitnessId = :userId")
//    User findByUserId(@Param("userId") int userId);

}
