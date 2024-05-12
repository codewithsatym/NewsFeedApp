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

import java.time.LocalDate;
import java.util.Optional;


@RestController
@RequestMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
)
@Tag(name = "OPEN SOURCE CALLING APIs")
public class NewsFeedController {

    @Autowired
    private EverythingFeedHandler everythingFeedHandler;


    @Operation(summary = "Get EveryThing api")
    @GetMapping("/get-everything/")
    public ResponseEntity<JsonNode> getEveryThing(
            @RequestParam String filterBy,
            @RequestParam(required = false) LocalDate from_time,
            @RequestParam(required = false) Long keyId,
            @RequestParam(required = false) String sort_by) {
        RequestEverythingDTO requestDTO = getRequestDTO(filterBy, from_time, sort_by);
        return new ResponseEntity<>(everythingFeedHandler.getEveryThingNewsFeed(requestDTO, Optional.ofNullable(keyId)),HttpStatus.OK);
    }

    private RequestEverythingDTO getRequestDTO(String filterBy,
                                               LocalDate from_time, String sort_by) {
        RequestEverythingDTO dto = new RequestEverythingDTO();
        dto.setFilterBy(filterBy);
        dto.setFromTime(from_time);
        dto.setSortBy(sort_by);
        return dto;
    }
}