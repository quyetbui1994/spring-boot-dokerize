package com.example.springbootapp.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
public class BillingRequest {
    @PositiveOrZero
    @JsonProperty("call_duration")
    private long callDuration;
}
