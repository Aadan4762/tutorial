package com.adan.Microservices.service;

import com.adan.Microservices.dto.MicroserviceRequest;
import com.adan.Microservices.dto.MicroserviceResponse;

import java.util.List;

public interface MicroserviceService {

    public void createMicroservice(MicroserviceRequest microserviceRequest);
    public List<MicroserviceResponse> getAllMicroservice();


}
