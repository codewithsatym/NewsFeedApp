package code.app.NewsFeed.controller;

import code.app.NewsFeed.service.KeyService;
import code.app.NewsFeed.service.ValidationService;
import code.app.NewsFeed.utils.IdDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyController {
    @Autowired
    private KeyService keyService;
    @Autowired
    private ValidationService validationService;

    @Operation(summary = "Add key")
    @PostMapping("/add/key")
    public ResponseEntity<?> saveKey(@RequestParam String key) {
        validationService.validateKey(key);
        Long keyId = keyService.saveKey(key);
        return new ResponseEntity<>(new IdDTO(keyId), HttpStatus.CREATED);
    }

}