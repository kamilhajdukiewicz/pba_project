/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.openapitools.model.Player;
import io.swagger.annotations.*;
import org.openapitools.model.PlayerRequest;
import org.openapitools.model.PlayerResponse;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-09T21:04:10.402+01:00[Europe/Belgrade]")
@Validated
@Api(value = "player", description = "the player API")
public interface PlayerApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /player/{playerID} : Remove the player by playerID.
     * Delte the player with matching playerId.
     *
     * @param playerID Id of the player (required)
     * @param dataTime Data-time of request (optional)
     * @param id Id of request (optional)
     * @return OK (status code 200)
     *         or Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */
    @ApiOperation(value = "Remove the player by playerID.", nickname = "deletePlayerPlayerID", notes = "Delte the player with matching playerId.", authorizations = {
        
        @Authorization(value = "basicAuth")
         }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/player/{playerID}"
    )
    default ResponseEntity<Void> deletePlayerPlayerID(@ApiParam(value = "Id of the player", required = true) @PathVariable("playerID") String playerID,@ApiParam(value = "Data-time of request") @RequestHeader(value = "Data-time", required = false) String dataTime,@ApiParam(value = "Id of request") @RequestHeader(value = "Id", required = false) String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /player/{playerID} : Get player info by ID.
     * Get info about the player with the same ID as playerID.
     *
     * @param playerID Id of the player (required)
     * @param dataTime data-time of request (optional)
     * @param id id of request (optional)
     * @return OK (status code 200)
     *         or Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */
    @ApiOperation(value = "Get player info by ID.", nickname = "getPlayerPlayerID", notes = "Get info about the player with the same ID as playerID.", response = PlayerResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PlayerResponse.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/player/{playerID}",
        produces = { "application/json" }
    )
    default ResponseEntity<PlayerResponse> getPlayerPlayerID(@ApiParam(value = "Id of the player", required = true) @PathVariable("playerID") String playerID,@ApiParam(value = "data-time of request") @RequestHeader(value = "Data-time", required = false) String dataTime,@ApiParam(value = "id of request") @RequestHeader(value = "Id", required = false) String id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"Kamil\", \"lastName\" : \"Grosicki\", \"goalsCount\" : 10, \"nationality\" : \"PL\", \"assistCount\" : 7, \"id\" : \"123e4567-e89b-42d3-a456-556642440000\", \"position\" : { \"position\" : \"ST\" }, \"team\" : { \"name\" : \"Pogon Szczecin\", \"id\" : \"97874567-e89b-42d3-a456-556642440000\" }, \"age\" : 23, \"yellowCardCount\" : 3, \"redCardCount\" : 1, \"height\" : 180 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /player : Create a new player.
     * Create a new player.
     *
     * @param dataTime Data-time of request (optional)
     * @param id Id of request (optional)
     * @param player  (optional)
     * @return OK (status code 200)
     *         or Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */
    @ApiOperation(value = "Create a new player.", nickname = "postPlayer", notes = "Create a new player.", response = PlayerResponse.class, authorizations = {
        
        @Authorization(value = "basicAuth")
         }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PlayerResponse.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/player",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<PlayerResponse> postPlayer(@ApiParam(value = "Data-time of request") @RequestHeader(value = "Data-time", required = false) String dataTime, @ApiParam(value = "Id of request") @RequestHeader(value = "Id", required = false) String id, @ApiParam(value = "") @Valid @RequestBody(required = false) PlayerRequest body) throws JsonProcessingException {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"Kamil\", \"lastName\" : \"Grosicki\", \"goalsCount\" : 10, \"nationality\" : \"PL\", \"assistCount\" : 7, \"id\" : \"123e4567-e89b-42d3-a456-556642440000\", \"position\" : { \"position\" : \"ST\" }, \"team\" : { \"name\" : \"Pogon Szczecin\", \"id\" : \"97874567-e89b-42d3-a456-556642440000\" }, \"age\" : 23, \"yellowCardCount\" : 3, \"redCardCount\" : 1, \"height\" : 180 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
