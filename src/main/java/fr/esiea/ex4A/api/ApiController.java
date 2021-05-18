package fr.esiea.ex4A.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    private final ApiRepository apiRepository;

    public ApiController(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    @PostMapping(path = "/api/inscription")
    public ResponseEntity<Void> register(@RequestBody InscriptionData inscriptionData) {
        if (inscriptionData == null || !inscriptionData.isValid())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        apiRepository.register(inscriptionData);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<MatchData>> matches(@RequestParam(name = "userName") String name,
                                            @RequestParam(name = "userCountry") String country) {

        UserCountry c = UserCountry.fromString(country);

        if (c == null || name == null || name.isBlank())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(apiRepository.getMatches(name, c), HttpStatus.OK);
    }
}
