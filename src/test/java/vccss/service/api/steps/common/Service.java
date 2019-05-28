package vccss.service.api.steps.common;

import static io.restassured.RestAssured.get;
import static vccss.service.api.util.EndPoints.ENDPOINTS;

public class Service {

    public ServiceStatus currentStatus(final String service) {
        int statusCode = get(ENDPOINTS.getEndPoint(service)).statusCode();
        return (statusCode == 200) ? ServiceStatus.RUNNING : ServiceStatus.DOWN;
    }
}
