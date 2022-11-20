package com.example.springbootapp.service;

import com.example.springbootapp.entity.CallBilling;
import com.example.springbootapp.exceptionhandler.exception.UserNotFoundException;
import com.example.springbootapp.model.request.BillingRequest;
import com.example.springbootapp.repository.CallBillingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CallBillingServiceTest {
    @InjectMocks
    private CallBillingService callBillingService;
    @Mock
    private CallBillingRepository repository;

    @Test
    void call_not_found() {
        var req = new BillingRequest(); req.setCallDuration(1000);
        Mockito.when(repository.findByUserName("quyetbv")).thenReturn(Optional.empty());
        Assertions.assertThrows(UserNotFoundException.class, () -> callBillingService.findBill("quyetbv"));
        Assertions.assertThrows(UserNotFoundException.class, () -> callBillingService.calculate("quyetbv", req));
    }

    @Test
    void call_sucess() {
        var req = new BillingRequest(); req.setCallDuration(70000);
        var bill = new CallBilling();
        bill.setUserName("quyetbv");
        Mockito.when(repository.findByUserName("quyetbv")).thenReturn(Optional.of(bill));
        Mockito.when(repository.save(Mockito.any())).thenReturn(bill);
        var res = callBillingService.findBill("quyetbv");
        Assertions.assertEquals( 0, res.getBlockCount());
        res = callBillingService.calculate("quyetbv", req);
        Assertions.assertEquals( 3, res.getBlockCount());
    }
}
