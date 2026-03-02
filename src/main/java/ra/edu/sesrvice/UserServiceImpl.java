package ra.edu.sesrvice;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl {
    private static List<String> emails = Arrays.asList(
            "a@gmail.com","b@gmail.com"
    );

    public boolean existByEmail(String email){
        return emails.contains(email);
    }
}
