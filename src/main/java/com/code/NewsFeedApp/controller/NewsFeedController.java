package com.code.NewsFeedApp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Feed Apis")
public class NewsFeedController {
    @Operation(summary = "Feed api")
    @PostMapping("/sdsds/(eventId)")
    public ResponseEntity<?> postdd(@PathVariable Long eventId){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
