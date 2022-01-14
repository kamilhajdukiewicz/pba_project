package org.openapitools.repository;

import lombok.Getter;
import org.openapitools.model.PlayerDB;
import org.openapitools.model.Position;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Getter
public class PlayersRepository {
    private List<PlayerDB> listOfPlayers;

    public PlayersRepository() {
        this.listOfPlayers = new ArrayList<PlayerDB>();

        Position pos = new Position();
        pos.setPosition(Position.PositionEnum.RW);
        PlayerDB player = PlayerDB.builder().id(UUID.fromString("1c0f1731-d827-4f84-a19e-31875fb5fe71")).firstName("Kamil").lastName("Grosicki")
                .age(23).height(180).nationality("PL").position(pos).goalsCount(9)
                .assistCount(3).yellowCardCount(2).redCardCount(1).teamId(UUID.fromString("2c0f1731-d827-4f84-a19e-31875fb5fe72")).build();
    }

    public PlayersRepository(List<PlayerDB> listOfUsers) {
        this.listOfPlayers = listOfUsers;
    }

    public void addNewPlayer(PlayerDB newUser) {
        this.listOfPlayers.add(newUser);
    }

    public boolean deletePlayerById(UUID id) {
        return this.listOfPlayers.removeIf(player -> player.getId().equals(id));
    }

    public boolean updatePlayerById(UUID id, PlayerDB updatedUser) {
        PlayerDB plr = listOfPlayers.stream().filter(player -> id.equals(player.getId())).findFirst().orElse(null);
        if(plr != null) {
            this.listOfPlayers.set(this.listOfPlayers.indexOf(plr), updatedUser);
            return true;
        }
        return false;
    }
}
