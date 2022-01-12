package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDB {

    private UUID id = null;

    private String firstName = null;

    private String lastName = null;

    private Integer age = null;

    private Integer height = null;

    private String nationality = null;

    private Position position = null;

    private Integer goalsCount = null;

    private Integer assistCount = null;

    private Integer yellowCardCount = null;

    private Integer redCardCount = null;

    private TeamDB team = null;
}
