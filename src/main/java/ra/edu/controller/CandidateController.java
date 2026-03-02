package ra.edu.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.edu.model.ErrorResponseDto;
import ra.edu.model.dto.CandidateCreateDTO;
import ra.edu.sesrvice.CandidateServiceImpl;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/candidates")
public class CandidateController {
    @Autowired
    private CandidateServiceImpl candidateService;
    @PostMapping
    public ResponseEntity<?> createCandidate(@Valid @RequestBody CandidateCreateDTO request, BindingResult result){
        if (result.hasErrors()){
            Map<String , String> map = result.getFieldErrors().stream().
                    collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage));
            ErrorResponseDto error = ErrorResponseDto.builder()
                    .code(400)
                    .message("INVALID DATA")
                    .details(map)
                    .build();
            return ResponseEntity.badRequest().body(error);
        }
        return ResponseEntity.ok().body(candidateService.create(request));
    }
}
