package code.app.NewsFeed.controller;


import code.app.NewsFeed.dto.RequestEverythingDTO;
import code.app.NewsFeed.utils.EverythingFeedHandler;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;


@RestController
@RequestMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
)
@Tag(name = "OPEN SOURCE CALLING APIs")
public class NewsFeedController {

    @Autowired
    private EverythingFeedHandler everythingFeedHandler;


    @Operation(summary = "Get EveryThing api")
    @GetMapping("/get-everything/{keyId}")
    public ResponseEntity<JsonNode> getEveryThing(@PathVariable Long keyId, @RequestBody RequestEverythingDTO dto) throws ValidationException {
        JsonNode everyThingNewsFeed = everythingFeedHandler.getEveryThingNewsFeed(dto,keyId);
        return new ResponseEntity<>(everyThingNewsFeed,HttpStatus.OK);
    }

}