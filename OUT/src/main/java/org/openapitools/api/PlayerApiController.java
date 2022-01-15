package org.openapitools.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.openapitools.model.*;
import org.openapitools.repository.PlayersRepository;
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
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-09T21:04:10.402+01:00[Europe/Belgrade]")
@Controller
@RequestMapping("${openapi.userCRUD.base-path:}")
public class PlayerApiController implements PlayerApi {

    private final NativeWebRequest request;

    private PlayersRepository playersRepo = PlayersRepository.getInstance();

    @org.springframework.beans.factory.annotation.Autowired
    public PlayerApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<PlayerResponse> postPlayer(@ApiParam(value = "Data-time of request") @RequestHeader(value = "Data-time", required = false) String dataTime,
                                                     @ApiParam(value = "Id of request") @RequestHeader(value = "Id", required = false) String id,
                                                     @ApiParam(value = "") @Valid @RequestBody(required = false) PlayerRequest body) throws JsonProcessingException {
        Player player = body.getUser();
        String bodyReq = body.toString().replace("class UpdateRequest ", "");
        bodyReq = bodyReq.toString().replace("class User ", "");
        ObjectMapper mapper = new ObjectMapper();
        String bodyStr = mapper.writeValueAsString(bodyReq.toString());

        if(playersRepo.getListOfPlayers().stream().filter(u->u.getId().toString().equals(player.getId())).findFirst().equals(Optional.empty())) {
            playersRepo.addNewPlayer(new PlayerDB(UUID.fromString(player.getId()), player.getFirstName(), player.getLastName(),
                    player.getAge(), player.getHeight(), player.getNationality(), player.getPosition().toString(),
                    player.getGoalsCount(), player.getAssistCount(), player.getYellowCardCount(), player.getRedCardCount(), player.getTeamId()));
        } else {
            //throw new UserAlreadyExistsException();
        }

        return ResponseEntity.ok().body(new PlayerResponse().user(player).
                responseHeader(new ResponseHeader().requestId(UUID.randomUUID()).sendDate(new Date(System.currentTimeMillis()))));
    }

    @Override
    public ResponseEntity<PlayerResponse> getPlayerPlayerID(@ApiParam(value = "Id of the player", required = true) @PathVariable("playerID") String playerID,@ApiParam(value = "data-time of request") @RequestHeader(value = "Data-time", required = false) String dataTime,@ApiParam(value = "id of request") @RequestHeader(value = "Id", required = false) String id) {

        Player player = new Player();
        if(!playersRepo.getListOfPlayers().stream().filter(u->u.getId().toString().equals(playerID)).findFirst().equals(Optional.empty())) {
            player = playersRepo.getListOfPlayers().stream().filter(u->u.getId().toString().equals(playerID)).findFirst()
                    .map(p -> new Player(p.getId().toString(), p.getFirstName(), p.getLastName(),
                            p.getAge(), p.getHeight(), p.getNationality(), Position.PositionEnum.fromValue(p.getPosition()),
                            p.getGoalsCount(), p.getAssistCount(), p.getYellowCardCount(), p.getRedCardCount(), p.getTeamId())).orElse(null);
        }
        else {

        }
        return ResponseEntity.ok().body(new PlayerResponse().user(player).
                responseHeader(new ResponseHeader().requestId(UUID.randomUUID()).sendDate(new Date(System.currentTimeMillis()))));
    }

    @Override
    public ResponseEntity<Void> deletePlayerPlayerID(@ApiParam(value = "Id of the player", required = true) @PathVariable("playerID") String playerID, @ApiParam(value = "Data-time of request") @RequestHeader(value = "Data-time", required = false) String dataTime, @ApiParam(value = "Id of request") @RequestHeader(value = "Id", required = false) String id) {
        if(!playersRepo.getListOfPlayers().stream().filter(u->u.getId().toString().equals(playerID)).findFirst().equals(Optional.empty())) {
            playersRepo.deletePlayerById(UUID.fromString(playerID));
        }
        else {

        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
