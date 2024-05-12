package code.app.NewsFeed.controller;


import code.app.NewsFeed.dto.StandardRequestDTO;
import code.app.NewsFeed.service.OpenSourceService;
import code.app.NewsFeed.utils.CommonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;


@RestController
@RequestMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
)
@Tag(name = "OPEN SOURCE CALLING APIs")
public class NewsFeedController {
    @Autowired
    private CommonUtils commonUtils;
    @Autowired
    private OpenSourceService openSourceService;


    @Operation(summary = "Get EveryThing api")
    @GetMapping("/get-everything")
    public ResponseEntity<JsonNode> getEveryThing(
            @RequestParam String filterBy,
            @RequestParam(required = false) LocalDate from_time,
            @RequestParam(required = false) Long keyId,
            @RequestParam(required = false) String sort_by) {
        StandardRequestDTO requestDTO = getEveryThingRequest(filterBy, from_time, sort_by);
        return new ResponseEntity<>(openSourceService.getEveryNews(requestDTO, Optional.ofNullable(keyId)), HttpStatus.OK);
    }

    private StandardRequestDTO getEveryThingRequest(String filterBy,
                                                    LocalDate from_time, String sort_by) {
        return commonUtils.getStandardRequestDTO(filterBy, from_time, sort_by);
    }

    @Operation(summary = "Get EveryThing api")
    @GetMapping("/get-top-headlines")
    public ResponseEntity<JsonNode> getEveryThing(
            @RequestParam String country,
            @RequestParam(required = false) Long keyId) {
        StandardRequestDTO requestDTO = getTopHeadlineRequestDTO(country);
        return new ResponseEntity<>(openSourceService.getTopHeadLines(requestDTO, Optional.ofNullable(keyId)), HttpStatus.OK);
    }

    private StandardRequestDTO getTopHeadlineRequestDTO(String country) {
        StandardRequestDTO standardRequestDTO = new StandardRequestDTO();
        standardRequestDTO.setCountry(country);
        return standardRequestDTO;
    }
}