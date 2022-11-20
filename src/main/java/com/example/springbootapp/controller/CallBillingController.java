package com.example.springbootapp.controller;

import com.example.springbootapp.model.request.BillingRequest;
import com.example.springbootapp.model.response.BillingResponse;
import com.example.springbootapp.service.CallBillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/mobile")
@RequiredArgsConstructor
public class CallBillingController extends AbstractRestController {
    private final CallBillingService callBillingService;

   @PutMapping("/{userName}/call")
    public ResponseEntity<BillingResponse> call(@PathVariable("userName") String userName, @Valid @RequestBody BillingRequest request) {
       return data(callBillingService.calculate(userName, request));
   }

   @GetMapping("/{userName}/billing")
    public ResponseEntity<BillingResponse> billing(@PathVariable("userName") String userName) {
       return data(callBillingService.findBill(userName));
   }

}
