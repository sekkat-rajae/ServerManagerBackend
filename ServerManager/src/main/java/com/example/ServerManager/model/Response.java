package com.example.ServerManager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.net.http.HttpClient;
import java.time.LocalDate;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data /* is a convenient shortcut annotation that bundles the features of @ToString,
         @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together */
@SuperBuilder
@JsonInclude(NON_NULL)
public class Response {
    protected LocalDate timeStamp;
    protected  int statusCode;
    protected HttpStatus status;
    protected String reason;
    protected String message;
    protected String developerMessage;
    protected Map<?,?> data;
}
