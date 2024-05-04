package org.example.finalproject.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.finalproject.API.ApiResponse;
import org.example.finalproject.Model.Requests;
import org.example.finalproject.Service.RequestsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/requests")
@RequiredArgsConstructor
public class RequestsController {
    private final RequestsService requestsService;


     @GetMapping("/get")
    public ResponseEntity getAllRequests(){
        return ResponseEntity.status(200).body(requestsService.getAllRequests());
    }


    @PostMapping("/add")
    public ResponseEntity addRequests(@RequestBody @Valid Requests request){
        requestsService.addRequest(request);
        return ResponseEntity.status(200).body(new ApiResponse("Request added successfully"));
    }


    @PutMapping("/update/{requestId}")
    public ResponseEntity updateRequests(@PathVariable Integer requestId , @RequestBody @Valid Requests request){
        requestsService.updateRequest(requestId,request);
        return ResponseEntity.status(200).body(new ApiResponse("Request updated successfully"));
    }


    @DeleteMapping("/delete/{requestId}")
    public ResponseEntity deleteRequests(@PathVariable Integer requestId ){
        requestsService.deleteRequest(requestId);
        return ResponseEntity.status(200).body(new ApiResponse("Request deleted successfully"));
    }


    @PutMapping("/assign/{requestId}")
    public ResponseEntity assign(@PathVariable Integer requestId) {
          requestsService.assign(requestId);
         return ResponseEntity.status(200).body("assign");
    }
}
