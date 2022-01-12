package org.openapitools.repository;

import lombok.Getter;
import org.openapitools.model.PlayerDB;
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
