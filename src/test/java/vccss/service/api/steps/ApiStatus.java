package vccss.service.api.steps;

import static vccss.service.api.util.EndPoints.ENDPOINTS;

import net.serenitybdd.rest.SerenityRest;

public class ApiStatus {

    public void readServiceResponse(final String serviceName) {
        SerenityRest.get(ENDPOINTS.getEndPoint(serviceName));
    }
}
