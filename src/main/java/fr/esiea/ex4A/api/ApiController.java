package fr.esiea.ex4A.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


}
