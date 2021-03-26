package com.lukaszkociuba.genderDetector.application;

import com.lukaszkociuba.genderDetector.GenderDetectorApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GenderDetectorApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GenderDetectionControllerTest {

    @LocalServerPort
    private int port;

    private final String firstToken = "firstToken";
    private final String allTokens = "allTokens";

    private ResponseEntity<String> fetchGender(String name, String algorithmType) {
        String url = "http://localhost:" + port + "/gender?name=" + name + "&algorithmType=" + algorithmType;

        TestRestTemplate restTemplate = new TestRestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity<String>(null, headers);

        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    private ResponseEntity<String> fetchTokenList(String tokenListName) {
        String url = "http://localhost:" + port + "/genderList?tokenListName=" + tokenListName;

        TestRestTemplate restTemplate = new TestRestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity<String>(null, headers);

        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    @Test
    void shouldReturnFemaleGenderForFirstTokenAlgorithmNamesWithFirstFemaleName() {
        var name = "Anna Zgidniew Gertruda";

        var response = this.fetchGender(name, firstToken);

        assertThat(response.getBody(), is("FEMALE"));
    }

    @Test
    void shouldReturnMaleGenderForFirstTokenAlgorithmNamesWithFirstMaleName() {
        var name = "Jan Maria Rokita";

        var response = this.fetchGender(name, firstToken);

        assertThat(response.getBody(), is("MALE"));
    }

    @Test
    void shouldReturnInconclusiveGenderForFirstTokenAlgorithmIncorrectNames() {
        var name = "Krzysztof Julia";

        var response = this.fetchGender(name, firstToken);

        assertThat(response.getBody(), is("INCONCLUSIVE"));
    }

    @Test
    void shouldReturnFemaleGenderForAllTokensAlgorithmNamesWithFemaleMajority() {
        var name = "Anna Zgidniew Gertruda";

        var response = this.fetchGender(name, allTokens);

        assertThat(response.getBody(), is("FEMALE"));
    }

    @Test
    void shouldReturnMaleGenderForForAllTokensAlgorithmNamesWithMaleMajority() {
        var name = "Anna Olaf Jan";

        var response = this.fetchGender(name, allTokens);

        assertThat(response.getBody(), is("MALE"));
    }

    @Test
    void shouldReturnInconclusiveGenderForAllTokensAlgorithmNamesWithEqualsMaleAndFemale() {
        var name = "Anna Olaf Jan Maria";

        var response = this.fetchGender(name, allTokens);

        assertThat(response.getBody(), is("INCONCLUSIVE"));
    }

    @Test
    void shouldReturnBadRequestForSpaceName() {
        var name = " ";

        var response = this.fetchGender(name, firstToken);

        assertEquals(400, response.getStatusCode().value());
    }

    @Test
    void shouldReturnBadRequestForEmptyName() {
        var name = "";

        var response = this.fetchGender(name, firstToken);

        assertEquals(400, response.getStatusCode().value());
    }

    @Test
    void shouldReturnBadRequestForEmptyAlgorithmType() {
        var name = "Anna Zgidniew Gertruda";
        var algorithmType = "";

        var response = this.fetchGender(name, algorithmType);

        assertEquals(400, response.getStatusCode().value());
    }

    @Test
    void shouldReturnBadRequestForSpaceAlgorithmType() {
        var name = "Anna Zgidniew Gertruda";
        var algorithmType = " ";

        var response = this.fetchGender(name, algorithmType);

        assertEquals(400, response.getStatusCode().value());
    }

    @Test
    void shouldReturnFemaleListForFemaleTokenListName() {
        var tokenListName = "femaleTokens";

        var response = this.fetchTokenList(tokenListName);

        assertThat(response.getBody(), is("[\"Maria\",\"Anna\",\"Gertruda\"]"));
    }

    @Test
    void shouldReturnMaleListForMaleTokenListName() {
        var tokenListName = "maleTokens";

        var response = this.fetchTokenList(tokenListName);

        assertThat(response.getBody(), is("[\"Jan\",\"Andrzej\",\"Olaf\"]"));
    }

    @Test
    void shouldReturnNullForNullTokenListName() {
        String tokenListName = null;

        var response = this.fetchTokenList(tokenListName);

        System.out.println(response.getBody());
    }
}