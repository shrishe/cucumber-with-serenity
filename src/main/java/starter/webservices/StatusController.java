package starter.webservices;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Collections;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("status")
public class StatusController {

    @RequestMapping(value = "/api/status", method = GET, produces = "application/json")
    @ApiOperation("Check the status of the API")
    public Map<String, String> status() {
        return Collections.singletonMap("response", "your string value");
    }
}
