package fr.esiea.ex4A.api;

import fr.esiea.ex4A.agify.AgifyClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApiService {

    private static final int AGE_MARGIN = 4;

    final AgifyClient agifyClient;
    final Map<AgeReference, InscriptionData> inscriptions = new HashMap<>();
    final Map<AgeReference, Integer> ageCache = new HashMap<>();

    public ApiService(AgifyClient agifyClient) {
        this.agifyClient = agifyClient;
    }

    public void register(InscriptionData data) {
        try {
            if (!ageCache.containsKey(data.toAgeReference())) {
                var age = agifyClient.getAge(data.getUserName(), data.getUserCountry().toString()).execute().body();
                if (age != null) {
                    inscriptions.put(data.toAgeReference(), data);
                    ageCache.put(data.toAgeReference(), age.getAge());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getAge(InscriptionData data) {
        return ageCache.get(data.toAgeReference());
    }

    public List<MatchData> getMatches(String name, UserCountry country) {
        List<MatchData> results = new ArrayList<>();

        // Search the person in the list
        AgeReference persRef = new AgeReference(name, country);
        if (!this.inscriptions.containsKey(persRef))
            return results;
        InscriptionData pers = inscriptions.get(persRef);


        for (var client : this.inscriptions.values()) {
            if (client == pers)
                continue;

            if(client.getUserSex() != pers.getUserSexPref() || client.getUserSexPref() != pers.getUserSex())
                continue;

            if(Math.abs(getAge(pers) - getAge(client)) > AGE_MARGIN)
                continue;

            results.add(client.toMatch());
        }

        return results;
    }
}
