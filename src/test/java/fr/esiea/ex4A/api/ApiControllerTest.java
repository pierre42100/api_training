package fr.esiea.ex4A.api;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class ApiControllerTest {
    private final MockMvc mockMvc;

    @Autowired
    private ApiService repository;

    ApiControllerTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }


    @Test
    void valid_inscription() throws Exception {

        JSONObject object = new JSONObject();
        object.put("userEmail", "pierre@hubert.fr");
        object.put("userName", "Pierre");
        object.put("userTweeter", "tweet");
        object.put("userCountry", "FR");
        object.put("userSex", "M");
        object.put("userSexPref", "F");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/inscription")
            .contentType(MediaType.APPLICATION_JSON)
            .content(object.toString()))
            .andExpect(status().isOk());
    }

    @Test
    void invalid_inscription() throws Exception {

        JSONObject object = new JSONObject();
        object.put("userEmail", "pierre@hubert.fr");
        object.put("userName", "Pierre");
        object.put("userTweeter", "tweet");
        object.put("userCountry", "FRA");
        object.put("userSex", "M");
        object.put("userSexPref", "F");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/inscription")
            .contentType(MediaType.APPLICATION_JSON)
            .content(object.toString()))
            .andExpect(status().isBadRequest());
    }

    @Test
    void matches_invalid_country() throws Exception {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/matches?userName=toto&userCountry=FRANCE"))
            .andExpect(status().isBadRequest());

    }

    @Test
    void matches_invalid_name() throws Exception {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/matches?userName=&userCountry=FRANCE"))
            .andExpect(status().isBadRequest());

    }

    @Test
    void matches_no_match() throws Exception {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/matches?userName=toto&userCountry=CA"))
            .andExpect(status().isOk())
            .andExpect(content().json("""
                []
                 """));

    }
}
