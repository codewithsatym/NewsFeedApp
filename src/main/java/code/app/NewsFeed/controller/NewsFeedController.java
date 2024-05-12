package code.app.NewsFeed.controller;


import code.app.NewsFeed.dto.RequestEverythingDTO;
import code.app.NewsFeed.utils.EverythingFeedHandler;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;


@RestController
public class NewsFeedController {

    @Autowired
    private EverythingFeedHandler everythingFeedHandler;


    @Operation(summary = "Get EveryThing api")
    @GetMapping("/get-everything/{keyId}")
    public ResponseEntity<JsonNode> sendEmailMessage(@PathVariable Long keyId, @RequestBody RequestEverythingDTO dto) throws ValidationException {
        JsonNode everyThingNewsFeed = everythingFeedHandler.getEveryThingNewsFeed(dto,keyId);
        return new ResponseEntity<>(everyThingNewsFeed,HttpStatus.OK);
    }

}