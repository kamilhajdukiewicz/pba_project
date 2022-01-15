/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.Team;
import io.swagger.annotations.*;
import org.openapitools.model.TeamListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-05T13:43:41.484+01:00[Europe/Belgrade]")
@Validated
@Api(value = "teams", description = "the teams API")
public interface TeamsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /teams : Get all teams
     * Retrieve the information about every team in database.
     *
     * @param dataTime data-time of request (optional)
     * @param id id of request (optional)
     * @return OK (status code 200)
     *         or Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */

    @ApiOperation(value = "Get all teams", nickname = "getTeams", notes = "Retrieve the information about every team in database.", response = TeamListResponse.class, tags={  })
    @ApiResponses(value = { 

        @ApiResponse(code = 200, message = "OK", response = TeamListResponse.class),

        @ApiResponse(code = 404, message = "Not Found"),

        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/teams",
        produces = { "application/json" }
    )
    default ResponseEntity<TeamListResponse> getTeams(
@ApiParam(value = "data-time of request") @RequestHeader(value = "Data-time", required = false) String dataTime
,
@ApiParam(value = "id of request") @RequestHeader(value = "Id", required = false) String id
) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"Pogon Szczecin\", \"id\" : \"97874567-e89b-42d3-a456-556642440000\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
