package fr.esiea.ex4A.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping(path = "/api/inscription")
    public ResponseEntity<Void> register(@RequestBody InscriptionData inscriptionData) {
        if (inscriptionData == null || !inscriptionData.isValid())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            apiService.register(inscriptionData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<MatchData>> matches(@RequestParam(name = "userName") String name,
                                            @RequestParam(name = "userCountry") String country) {

        UserCountry c = UserCountry.fromString(country);

        if (c == null || name == null || name.isBlank())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(apiService.getMatches(name, c), HttpStatus.OK);
    }
}
