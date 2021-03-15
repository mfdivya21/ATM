package com.mobiquity.ATM;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

    @RestController
    public class AtmController {

        @Autowired
        RestTemplate restTemplate;
        final String endPoint = "https://www.ing.nl/api/locator/atms/";


        @RequestMapping ("/atmByCity/{cityName}")
        @ResponseBody
        public List<AtmModel>  atmList(@PathVariable("cityName") String  cityName) throws JsonProcessingException {

            String response = restTemplate.getForEntity(endPoint, String.class).getBody().substring(6);
            ObjectMapper mapper = new ObjectMapper();
            List<AtmModel> participantJsonList = mapper.readValue(response, new TypeReference<List<AtmModel>>(){});
            List<AtmModel> finalList = participantJsonList.stream().filter(x ->x.address.city.equals(cityName)).collect(Collectors.toList());
            return finalList;
        }

        @RequestMapping ("/atmList")
        public List<AtmModel>  atmList() throws JsonProcessingException {
            String response  = restTemplate.getForEntity(endPoint , String.class).getBody().substring(6);
            ObjectMapper mapper = new ObjectMapper();
            List<AtmModel> atmList = mapper.readValue(response, new TypeReference<List<AtmModel>>(){});
            return atmList;
        }


    }