package fr.esiea.ex4A.api;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ApiRepository {
    final List<InscriptionData> inscriptions = new ArrayList<>();

    public void register(InscriptionData data) {
        inscriptions.add(data);
    }

    public List<MatchData> getMatches(String name, UserCountry country) {
        return inscriptions.stream().map(InscriptionData::toMatch).collect(Collectors.toList());
    }
}
