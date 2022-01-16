package org.openapitools.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.openapitools.exceptions.BadCredentialsException;
import org.openapitools.exceptions.MessageNotValidException;
import org.openapitools.exceptions.UserAlreadyExistsException;
import org.openapitools.exceptions.UserDoesntExistsException;
import org.openapitools.model.*;
import org.openapitools.repository.CredentialsRepo;
import org.openapitools.repository.PlayersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.NativeWebRequest;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.spec.SecretKeySpec;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.crypto.Mac;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-09T21:04:10.402+01:00[Europe/Belgrade]")
@Controller
@RequestMapping("${openapi.userCRUD.base-path:}")
public class PlayerApiController implements PlayerApi {

    private final NativeWebRequest request;

    private PlayersRepository playersRepo = PlayersRepository.getInstance();
    private CredentialsRepo credRepo = CredentialsRepo.getInstance();

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
                                                     @ApiParam(value = "Id of request") @RequestHeader(value = "Id", required = false) String id, @RequestHeader("Authorization") String credentials,
                                                     @RequestHeader("X-HMAC-SIGNATURE") String signature, @ApiParam(value = "") @Valid @RequestBody(required = false) PlayerRequest body) throws JsonProcessingException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        Player player = body.getPlayer();
        if(credRepo.areCredentialsValid(credentials)) {

            String bodyReq = body.toString().replace("class UpdateRequest ", "");
            bodyReq = bodyReq.toString().replace("class User ", "");
            ObjectMapper mapper = new ObjectMapper();
            String bodyStr = mapper.writeValueAsString(bodyReq.toString());

            String key = "123456";
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
            sha256_HMAC.init(secret_key);

            String hash = Hex.encodeHexString(sha256_HMAC.doFinal(bodyReq.toString().getBytes("UTF-8")));

            if(hash.equals(signature)) {
                if (playersRepo.getListOfPlayers().stream().filter(u -> u.getId().toString().equals(player.getId())).findFirst().equals(Optional.empty())) {
                    playersRepo.addNewPlayer(new PlayerDB(UUID.fromString(player.getId()), player.getFirstName(), player.getLastName(),
                            player.getAge(), player.getHeight(), player.getNationality(), player.getPosition().toString(),
                            player.getGoalsCount(), player.getAssistCount(), player.getYellowCardCount(), player.getRedCardCount(), player.getTeamId()));
                } else {
                    throw new UserAlreadyExistsException("Player already exists");
                }
            } else {
                throw new MessageNotValidException("Message is not valid");
            }
        } else {
            throw new BadCredentialsException("Unauthorized");
        }
        return ResponseEntity.ok().body(new PlayerResponse().player(player).
                responseHeader(new ResponseHeader().requestId(UUID.randomUUID()).sendDate(new Date(System.currentTimeMillis()))));
    }

    @Override
    public ResponseEntity<PlayerResponse> getPlayerPlayerID(@ApiParam(value = "Id of the player", required = true) @PathVariable("playerID") String playerID,
                                                            @ApiParam(value = "data-time of request") @RequestHeader(value = "Data-time", required = false) String dataTime,
                                                            @ApiParam(value = "id of request") @RequestHeader(value = "Id", required = false) String id) {

        Player player = new Player();
        if(!playersRepo.getListOfPlayers().stream().filter(u->u.getId().toString().equals(playerID)).findFirst().equals(Optional.empty())) {
            player = playersRepo.getListOfPlayers().stream().filter(u->u.getId().toString().equals(playerID)).findFirst()
                    .map(p -> new Player(p.getId().toString(), p.getFirstName(), p.getLastName(),
                            p.getAge(), p.getHeight(), p.getNationality(), Position.PositionEnum.fromValue(p.getPosition()),
                            p.getGoalsCount(), p.getAssistCount(), p.getYellowCardCount(), p.getRedCardCount(), p.getTeamId())).orElse(null);
        } else {
            throw new UserDoesntExistsException("Player doesn't exists");
        }
        return ResponseEntity.ok().body(new PlayerResponse().player(player).
                responseHeader(new ResponseHeader().requestId(UUID.randomUUID()).sendDate(new Date(System.currentTimeMillis()))));
    }

    @Override
    public ResponseEntity<Void> deletePlayerPlayerID(@ApiParam(value = "Id of the player", required = true) @PathVariable("playerID") String playerID, @ApiParam(value = "Data-time of request") @RequestHeader(value = "Data-time", required = false) String dataTime,@RequestHeader("Authorization") String credentials, @ApiParam(value = "Id of request") @RequestHeader(value = "Id", required = false) String id) {

        if(credRepo.areCredentialsValid(credentials)) {
            if (!playersRepo.getListOfPlayers().stream().filter(u -> u.getId().toString().equals(playerID)).findFirst().equals(Optional.empty())) {
                playersRepo.deletePlayerById(UUID.fromString(playerID));
            } else {
                throw new UserDoesntExistsException("Player doesn't exists");
            }
        } else {
            throw new BadCredentialsException("Unauthorized");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
