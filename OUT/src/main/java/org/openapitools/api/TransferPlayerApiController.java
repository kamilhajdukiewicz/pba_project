package org.openapitools.api;

import io.swagger.annotations.ApiParam;
import org.openapitools.model.Player;
import org.openapitools.model.Team;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-09T21:04:10.402+01:00[Europe/Belgrade]")
@Controller
@RequestMapping("${openapi.userCRUD.base-path:}")
public class TransferPlayerApiController implements TransferPlayerApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TransferPlayerApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Player> putUpdateUserUserID(@ApiParam(value = "Id of the player", required = true) @PathVariable("playerID") String playerID, @ApiParam(value = "data-time of request") @RequestHeader(value = "Data-time", required = false) OffsetDateTime dataTime, @ApiParam(value = "id of request") @RequestHeader(value = "id", required = false) String id, @ApiParam(value = "") @Valid @RequestBody(required = false) Team team) {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
