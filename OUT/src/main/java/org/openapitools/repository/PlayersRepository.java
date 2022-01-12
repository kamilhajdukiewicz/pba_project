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
        PlayerDB usr = listOfPlayers.stream().filter(user -> id.equals(user.getId())).findFirst().orElse(null);
        if(usr != null) {
            this.listOfPlayers.set(this.listOfPlayers.indexOf(usr), updatedUser);
            return true;
        }
        return false;
    }
}
