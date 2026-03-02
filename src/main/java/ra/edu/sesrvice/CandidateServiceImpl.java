package ra.edu.sesrvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.model.dto.CandidateCreateDTO;
import ra.edu.model.entity.Candidate;
import ra.edu.repository.ICandidateRepository;

@Service
public class CandidateServiceImpl {
    @Autowired
    private ICandidateRepository candidateRepository;
    public Candidate create(CandidateCreateDTO request){
        Candidate entity = Candidate.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .age(request.getAge())
                .yearsOfExperience(request.getYearsOfExperience())
                .build();
        return candidateRepository.save(entity);
    }
}
