package com.app.sb3t.ws.it;

import com.app.sb3t.ws.Application;
import com.app.sb3t.ws.it.utils.HeaderSettingRequestCallback;
import com.app.sb3t.ws.it.utils.ResponseResultErrorHandler;
import com.app.sb3t.ws.it.utils.ResponseResults;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@CucumberContextConfiguration
@SpringBootTest(classes = Application.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
public class ApplicationIT {
    protected static ResponseResults latestResponse = null;

    @Autowired
    protected RestTemplate restTemplate;


    /**
     * REST GET query
     *
     * @param url String
     * @throws IOException e
     */
    protected void executeGet(String url) throws IOException {
        final Map<String, String> headers = new HashMap<>();
        //headers.put("Accept", "application/json");
        final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);
        final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();

        restTemplate.setErrorHandler(errorHandler);
        latestResponse = restTemplate.execute(url, HttpMethod.GET, requestCallback, response -> {
            if (errorHandler.hadError) {
                return (errorHandler.getResults());
            } else {
                return (new ResponseResults(response));
            }
        });
    }

    /**
     * REST POST query
     * TODO
     *
     * @param url String
     * @throws IOException e
     */
    private void executePost(String url) throws IOException {
        final Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);
        final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();

        if (restTemplate == null) {
            restTemplate = new RestTemplate();
        }

        restTemplate.setErrorHandler(errorHandler);
        latestResponse = restTemplate
                .execute(url, HttpMethod.POST, requestCallback, response -> {
                    if (errorHandler.hadError) {
                        return (errorHandler.getResults());
                    } else {
                        return (new ResponseResults(response));
                    }
                });
    }
}
