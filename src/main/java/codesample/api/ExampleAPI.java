package codesample.api;

import codesample.annotation.CodeSample;
import codesample.annotation.CodeSampleLangs;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by hugomartins on 12/26/17.
 */


@Api
@Path("/example")
@Produces({"application/json", "application/xml"})
public class ExampleAPI {


    @GET
    @ApiOperation(value = "Print test message")
    @ApiResponses(
            value= {
                    @ApiResponse(code = 200, message = "Show message: test")
            }
    )
    @CodeSample(langs = {
            @CodeSampleLangs(lang = "Shell", source= "curl http://localhost:8080/api/example"),
            @CodeSampleLangs(lang = "JavaScript", source= "var http = new XMLHttpRequest();\n" +
                    "http.open('GET', 'http://localhost:8080/api/example', false);\n" +
                    "http.send();\n" +
                    "console.log(http.responseText);"),
    })
    public Response printMessageTest(){
        return Response.ok("Test").build();
    }

}
