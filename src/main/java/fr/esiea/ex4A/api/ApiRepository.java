package fr.esiea.ex4A.api;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ApiRepository {
    final List<InscriptionData> inscriptions = new ArrayList<>();

    public void register(InscriptionData data) {
        inscriptions.add(data);
    }
}
