package code.app.NewsFeed.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;


@RestController
public class NewFeedController {


    @PostMapping("/news/feed")
    public ResponseEntity<?> sendEmailMessage() throws ValidationException {

        return new ResponseEntity<>(HttpStatus.OK);
    }

}