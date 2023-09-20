package com.adan.Microservices.controller;


import com.adan.Microservices.dto.MicroserviceRequest;
import com.adan.Microservices.dto.MicroserviceResponse;
import com.adan.Microservices.service.MicroserviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/microservice")
public class MicroserviceController {

    private final MicroserviceService microserviceService;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMicroservice(@RequestBody MicroserviceRequest microserviceRequest){
        microserviceService.createMicroservice(microserviceRequest);

    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)

    public List<MicroserviceResponse> getAllMicroservices(){
        return microserviceService.getAllMicroservice();
    }
}
