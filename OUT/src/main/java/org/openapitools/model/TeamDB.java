package org.openapitools.model;

import lombok.*;

import java.util.UUID;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeamDB {
    private UUID id = null;

    private String name = null;
}
