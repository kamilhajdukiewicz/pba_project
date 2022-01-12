package org.openapitools.repository;

import lombok.Getter;
import org.openapitools.model.PlayerDB;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Getter
public class PlayesRepository {
    private List<PlayerDB> listOfPlayers;
}
