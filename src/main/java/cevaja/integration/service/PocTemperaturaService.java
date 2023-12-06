package cevaja.integration.service;

import cevaja.integration.response.TemperaturResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PocTemperaturaService {

    private final RestTemplate restTemplate;

    @Value("${weather-api-url}")
    private String uri;

    public PocTemperaturaService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    public TemperaturResponse buscarTemperatura() {
        TemperaturResponse temperaturResponse = this.restTemplate.getForObject(uri,TemperaturResponse.class);
        return temperaturResponse;
    }
}
