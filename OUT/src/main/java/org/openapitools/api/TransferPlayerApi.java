/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.OffsetDateTime;

import org.openapitools.model.*;
import io.swagger.annotations.*;
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
@Api(value = "transferPlayer", description = "the transferPlayer API")
public interface TransferPlayerApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PUT /transferPlayer/{playerID} : Transfer player with playerID to the new team.
     * Transfer player to the new team.
     *
     * @param playerID Id of the player (required)
     * @param dataTime data-time of request (optional)
     * @param id id of request (optional)
     * @param team  (optional)
     * @return OK (status code 200)
     *         or Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */
    @ApiOperation(value = "Transfer player with playerID to the new team.", nickname = "putUpdateUserUserID", notes = "Transfer player to the new team.", response = PlayerResponse.class, authorizations = {
        
        @Authorization(value = "basicAuth")
         }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PlayerResponse.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/transferPlayer/{playerID}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<PlayerResponse> putUpdateUserUserID(@ApiParam(value = "Id of the player", required = true) @PathVariable("playerID") String playerID,
                                                               @ApiParam(value = "data-time of request") @RequestHeader(value = "Data-time", required = false) OffsetDateTime dataTime,
                                                               @RequestHeader("Authorization") String credentials, @ApiParam(value = "id of request") @RequestHeader(value = "id", required = false) String id,
                                                               @RequestHeader("X-HMAC-SIGNATURE") String signature, @ApiParam(value = "") @Valid @RequestBody(required = false) TransferRequest body) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
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
