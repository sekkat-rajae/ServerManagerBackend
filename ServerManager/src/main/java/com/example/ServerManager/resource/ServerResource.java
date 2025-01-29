package com.example.ServerManager.resource;

import com.example.ServerManager.enumaration.Status;
import com.example.ServerManager.model.Response;
import com.example.ServerManager.model.Server;
import com.example.ServerManager.repository.ServerRepo;
import com.example.ServerManager.service.implementation.serverServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerResource {
    private  final serverServiceImp serverService;
    private  final ServerRepo serverRepo;

    @GetMapping("/list")
    public ResponseEntity<Response> getServers(){
        return ResponseEntity.ok(

                Response.builder()
                        .timeStamp(LocalDate.now())
                        .data(Map.of("servers", serverService.list(30)))
                        .message("servers retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @GetMapping("/ping/{ipAddress}")
    public ResponseEntity<Response> pingServer(@PathVariable("ipAddress") String ipAddress) throws IOException {
        Server server= serverService.ping(ipAddress);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDate.now())
                        .data(Map.of("server", server))
                        .message(server.getStatus()== Status.SERVER_UP? "Ping success": "Ping failed")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @PostMapping("/save")
    public ResponseEntity<Response> saveServer(@RequestBody @Valid Server server){
        serverRepo.save(server);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDate.now())
                        .data(Map.of("server", server))
                        .message(server.getStatus()== Status.SERVER_UP? "Ping success": "Ping failed")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> pingServer(@PathVariable("id") Long id)  {
        return ResponseEntity.ok(

                Response.builder()
                        .timeStamp(LocalDate.now())
                        .data(Map.of("server", serverService.get(id)))
                        .message("server retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteServer(@PathVariable("id") Long id)  {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDate.now())
                        .data(Map.of("server deleted", serverService.delete(id)))
                        .message("server deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @GetMapping(path = "/image/{fileName}", produces = IMAGE_PNG_VALUE )
    public byte[] getServerImage(@PathVariable("fileName") String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/Downloads/images/" + fileName));
    }
}
