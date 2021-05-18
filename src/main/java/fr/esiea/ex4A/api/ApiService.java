package fr.esiea.ex4A.api;

import fr.esiea.ex4A.agify.AgifyClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApiService {

    final AgifyClient agifyClient;
    final Map<AgeReference, InscriptionData> inscriptions = new HashMap<>();
    final Map<AgeReference, Integer> ageCache = new HashMap<>();

    public ApiService(AgifyClient agifyClient) {
        this.agifyClient = agifyClient;
    }

    public void register(InscriptionData data) throws Exception {
        if (!ageCache.containsKey(data.toAgeReference())) {
            var age = agifyClient.getAge(data.getUserName(), data.getUserCountry().toString()).execute().body();
            if (age != null) {
                inscriptions.put(data.toAgeReference(), data);
                ageCache.put(data.toAgeReference(), age.getAge());
            }
        }
    }

    public int getAge(InscriptionData data) {
        return ageCache.get(data.toAgeReference());
    }

    public List<MatchData> getMatches(String name, UserCountry country) {
        // Search the person in the list
        AgeReference persRef = new AgeReference(name, country);
        if (!this.inscriptions.containsKey(persRef))
            return new ArrayList<>();

        return doSearchMatches(inscriptions.get(persRef));
    }

    private List<MatchData> doSearchMatches(InscriptionData pers) {
        List<MatchData> results = new ArrayList<>();
        for (var client : this.inscriptions.values()) {
            if (client == pers || Math.abs(getAge(pers) - getAge(client)) > 4 ||
                client.getUserSex() != pers.getUserSexPref() || client.getUserSexPref() != pers.getUserSex())
                continue;
            results.add(client.toMatch());
        }
        return results;
    }
}
