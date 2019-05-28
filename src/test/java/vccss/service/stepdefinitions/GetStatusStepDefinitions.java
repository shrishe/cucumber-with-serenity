package vccss.service.stepdefinitions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.assertj.core.api.Assertions.assertThat;
import static vccss.service.api.steps.common.ServiceStatus.RUNNING;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import net.thucydides.core.annotations.Steps;
import vccss.service.api.steps.ApiStatus;
import vccss.service.api.steps.common.Service;

public class GetStatusStepDefinitions {

    @Steps
    private Service service;

    @Steps
    private ApiStatus clusters;

    @Given("The {string} web service  is running")
    public void the_service_is_running(final String serviceName) {
        assertThat(service.currentStatus(serviceName)).isEqualTo(RUNNING);
    }

    @When("User query the {string} web service")
    public void user_query_the_service(final String serviceName) {
        clusters.readServiceResponse(serviceName);
    }

    @Then("I expect a valid response")
    public void the_response_should_be_valid() {
        restAssuredThat(lastResponse -> lastResponse.body(matchesJsonSchemaInClasspath("json/schema/status-response.json")));
    }

    @Then("The response content type should be json")
    public void the_response_content_type_should_be() {
        restAssuredThat(lastResponse -> lastResponse.contentType(ContentType.JSON));
    }
}
