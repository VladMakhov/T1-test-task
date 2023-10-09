package com.example.tone_test_task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/*
* Controller with only one method get accepts special request
* and returns formatted http response with hashmap;
* */
@RestController
class MyController {

    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/frequency")
    public ResponseEntity<Map<Character, Integer>> frequency(@RequestBody FreqRequest request) {
        return new ResponseEntity<>(myService.getFrequencyMap(request.getText()), HttpStatus.OK);
    }
}
