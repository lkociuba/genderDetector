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

    private final String name1 = "Jan Maria Rokita";
    private final String name2 = "Anna Zgidniew Gertruda";

    private final String firstToken = "firstToken";
    private final String allTokens = "allTokens";

    private String testSetUp(String name, String algorithmType) {
        String url = "http://localhost:" + port + "/gender/" + name + "/" + algorithmType;

        TestRestTemplate restTemplate = new TestRestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    @Test
    void detectGender_name1FirstToken_resultMale() {
        var response = this.testSetUp(name1, firstToken);

        assertThat(response, is("MALE"));
    }

    @Test
    void detectGender_name2FirstToken_resultFemale() {
        var response = this.testSetUp(name2, firstToken);

        assertThat(response, is("FEMALE"));
    }

    @Test
    void detectGender_name3FirstToken_resultInconclusive() {
        var name3 = "Krzysztof Bogusław";
        var response = this.testSetUp(name3, firstToken);

        assertThat(response, is("INCONCLUSIVE"));
    }

    @Test
    void detectGender_spaceNameFirsToken_resultResponse404() {
        String url = "http://localhost:" + port + "/gender/ /" + allTokens;

        TestRestTemplate restTemplate = new TestRestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, String.class);

        assertEquals(404, response.getStatusCode().value());
    }

    @Test
    void detectGender_emptyNameFirstToken_rresultResponse404() {
        String url = "http://localhost:" + port + "/gender/" + "" + "/" + firstToken;

        TestRestTemplate restTemplate = new TestRestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, String.class);

        assertEquals(404, response.getStatusCode().value());
    }

    @Test
    void detectGender_name1AmptyAlgorithmType_resultResponse404() {
        String url = "http://localhost:" + port + "/gender/" + name1 + "/" + "";

        TestRestTemplate restTemplate = new TestRestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, String.class);

        assertEquals(404, response.getStatusCode().value());
    }

    @Test
    void detectGender_name1SpaceAlgorithmType_resultExffceptions123() {
        String url = "http://localhost:" + port + "/gender/" + name1 + "/" + " ";

        TestRestTemplate restTemplate = new TestRestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, String.class);

        assertEquals(404, response.getStatusCode().value());
    }

    @Test
    void detectGender_name1AllTokens_resultInconclusive() {
        var response = this.testSetUp(name1, allTokens);

        assertThat(response, is("INCONCLUSIVE"));
    }

    @Test
    void detectGender_name2AllTokens_resultFemale() {
        var response = this.testSetUp(name2, allTokens);

        assertThat(response, is("FEMALE"));
    }

    @Test
    void detectGender_name4AllTokens_resultMale() {
        var name4 = "Anna Olaf Jan";
        var response = this.testSetUp(name4, allTokens);

        assertThat(response, is("MALE"));
    }
}