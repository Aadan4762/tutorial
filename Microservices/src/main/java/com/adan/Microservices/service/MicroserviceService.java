package com.adan.Microservices.service;

import com.adan.Microservices.dto.MicroserviceRequest;
import com.adan.Microservices.dto.MicroserviceResponse;

import java.util.List;

public interface MicroserviceService {

    void createMicroservice(MicroserviceRequest microserviceRequest);
    List<MicroserviceResponse> getAllMicroservice();
    MicroserviceResponse getMicroserviceById(int id);
    boolean updateMicroservice(int id, MicroserviceRequest microserviceRequest);
    boolean deleteMicroservice(int id);


}
