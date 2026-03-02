package ra.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.edu.model.entity.Candidate;

public interface ICandidateRepository extends JpaRepository<Candidate, Integer> {

}
