package com.example.springbootapp.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillingResponse {

    @JsonProperty("call_count")
    private int callCount;
    @JsonProperty("block_count")
    private long blockCount;
}
