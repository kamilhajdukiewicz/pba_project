package org.openapitools.repository;

import lombok.Getter;
import org.openapitools.model.CredentialsDB;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class CredentialsRepo {

    List<CredentialsDB> listOfCredentials = new ArrayList<CredentialsDB>();

    CredentialsRepo() {
        CredentialsDB cred = CredentialsDB.builder().login("admin").password("admin").build();
        listOfCredentials.add(cred);
    }
}
