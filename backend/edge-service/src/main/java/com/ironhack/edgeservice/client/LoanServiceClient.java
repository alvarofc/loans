package com.ironhack.edgeservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "loan-service")
public interface LoanServiceClient {
}
