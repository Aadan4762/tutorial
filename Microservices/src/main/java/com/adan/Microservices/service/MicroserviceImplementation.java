package com.adan.Microservices.service;

import com.adan.Microservices.dto.MicroserviceRequest;
import com.adan.Microservices.dto.MicroserviceResponse;
import com.adan.Microservices.model.Microservice;
import com.adan.Microservices.repository.MicroserviceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MicroserviceImplementation implements MicroserviceService{

    private final MicroserviceRepository microserviceRepository;
    @Override
    public void createMicroservice(MicroserviceRequest microserviceRequest) {

        Microservice microservice = Microservice.builder()
                .name(microserviceRequest.getName())
                .price(microserviceRequest.getPrice())
                .build();
        microserviceRepository.save(microservice);
        log.info("Microservice {} is saved",microservice.getId());

    }

    @Override
    public List<MicroserviceResponse> getAllMicroservice() {
        List<Microservice> microservices = microserviceRepository.findAll();
        return microservices.stream().map(this::mapToMicroserviceResponse).toList();
    }

    private MicroserviceResponse mapToMicroserviceResponse(Microservice microservice) {
        return MicroserviceResponse.builder()
                .id(microservice.getId())
                .name(microservice.getName())
                .price(microservice.getPrice())
                .build();
    }
}
