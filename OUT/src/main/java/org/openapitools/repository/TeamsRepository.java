package org.openapitools.repository;

import lombok.Getter;
import org.openapitools.model.TeamDB;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class TeamsRepository {
    private List<TeamDB> listOfTeams;

    public TeamsRepository() {
        this.listOfTeams = new ArrayList<TeamDB>();
    }

    public TeamsRepository(List<TeamDB> listOfTeams) {
        this.listOfTeams = listOfTeams;
    }

    public void addNewPlayer(TeamDB newTeam) {
        this.listOfTeams.add(newTeam);
    }
}
