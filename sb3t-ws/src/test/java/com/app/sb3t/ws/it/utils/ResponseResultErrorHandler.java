package com.app.sb3t.ws.it.utils;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class ResponseResultErrorHandler implements ResponseErrorHandler {
    public Boolean hadError = false;
    private ResponseResults results = null;

    public ResponseResults getResults() {
        return results;
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        hadError = response.getRawStatusCode() >= 400;
        return hadError;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        results = new ResponseResults(response);
    }
}
