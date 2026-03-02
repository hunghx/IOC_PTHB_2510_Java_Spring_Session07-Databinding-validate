package ra.edu.model;

import java.time.LocalDateTime;

public class ResponseSuccesDto<T> {
    private int code;
    private String message;
    private T data;
    private LocalDateTime timestamp = LocalDateTime.now();
}
