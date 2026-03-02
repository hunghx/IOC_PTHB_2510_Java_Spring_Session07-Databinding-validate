package ra.edu.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.edu.model.ErrorResponseDto;
import ra.edu.model.UserDtoRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    // api nhận dữ lệu và validate

    @PostMapping
    public ResponseEntity<?> postUser(@Valid @RequestBody UserDtoRequest request, BindingResult result){
        // xử lí lỗi nếu có
        if (result.hasErrors()){
//            List<FieldError> errors = result.getFieldErrors();
//            errors.get(0).getField(); // lấy tên trường
//            errors.get(0).getDefaultMessage();// thông báo lỗi
            Map<String, String> map = new HashMap<>();

            result.getFieldErrors().forEach(er->{
                map.put(er.getField(), er.getDefaultMessage());
            });

            ErrorResponseDto err = ErrorResponseDto.builder()
                    .code(400)
                    .message("INVALID FIELD")
                    .details(map)
                    .build();
            return ResponseEntity.badRequest().body(err);
        }
//        HttpStatus.CONFLICT // 409
        return ResponseEntity.ok("success");

    }
}
