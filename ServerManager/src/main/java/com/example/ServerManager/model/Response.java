package com.example.ServerManager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.net.http.HttpClient;
import java.time.LocalDate;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/* I created the response class to structure HTTP responses.*/

@Data /* is a convenient shortcut annotation that bundles the features of @ToString,
         @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together */
@SuperBuilder /* Allows us to use the Builder pattern, meaning we can create an instance of Response using .builder() */
@JsonInclude(NON_NULL) /* If a field is null, it won’t be included in the JSON response.*/
public class Response {
    protected LocalDate timeStamp;
    protected  int statusCode;
    protected HttpStatus status;
    protected String reason;
    protected String message;
    protected String developerMessage;
    protected Map<?,?> data;
}
