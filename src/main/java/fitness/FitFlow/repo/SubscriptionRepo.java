package fitness.FitFlow.repo;


import fitness.FitFlow.model.FitnessSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepo extends JpaRepository<FitnessSubscription, Integer> {
}
