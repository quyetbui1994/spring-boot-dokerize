package com.example.springbootapp.service;

import com.example.springbootapp.exceptionhandler.exception.UserNotFoundException;
import com.example.springbootapp.model.request.BillingRequest;
import com.example.springbootapp.model.response.BillingResponse;
import com.example.springbootapp.repository.CallBillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallBillingService {
    @Autowired
    private CallBillingRepository callBillingRepository;

    public BillingResponse calculate(String userName, BillingRequest request) {
        var bill = callBillingRepository.findByUserName(userName).orElseThrow(() -> {
            throw new UserNotFoundException("not found");
        });
        bill.setCallCount(bill.getCallCount() + 1);
        bill.setBlockCount(bill.getBlockCount() + request.getCallDuration()/30000 + (request.getCallDuration()%30000 != 0 ? 1 : 0));
        callBillingRepository.save(bill);
        return BillingResponse.builder().callCount(bill.getCallCount())
                .blockCount(bill.getBlockCount()).build();
    }

    public BillingResponse findBill(String userName) {
        var bill = callBillingRepository.findByUserName(userName).orElseThrow(() -> {
            throw new UserNotFoundException("not found");
        });
        return BillingResponse.builder().callCount(bill.getCallCount())
                .blockCount(bill.getBlockCount()).build();
    }
}
