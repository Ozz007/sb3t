package com.app.sb3t.ws.it.stepdef;

import com.app.sb3t.ws.it.ApplicationIT;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class CustomerStepDef extends ApplicationIT {

    @When("^the client calls /customers$")
    public void the_client_calls_orders() throws Throwable {
        executeGet("http://localhost:8080/api/customers");
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " +
                latestResponse.getBody(), currentStatusCode.value(), is(statusCode));

    }
}
