package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ResponseHeader;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerListResponse {
    @JsonProperty("responseHeader")
    private org.openapitools.model.ResponseHeader responseHeader = null;

    @JsonProperty("usersList")
    @Valid
    private List<Player> usersList = new ArrayList<>();

    public PlayerListResponse responseHeader(org.openapitools.model.ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
        return this;
    }

    /**
     * Get responseHeader
     * @return responseHeader
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public org.openapitools.model.ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(org.openapitools.model.ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public PlayerListResponse usersList(List<Player> usersList) {
        this.usersList = usersList;
        return this;
    }

    public PlayerListResponse addUsersListItem(Player usersListItem) {
        this.usersList.add(usersListItem);
        return this;
    }

    /**
     * Get usersList
     * @return usersList
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public List<Player> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Player> usersList) {
        this.usersList = usersList;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerListResponse userListResponse = (PlayerListResponse) o;
        return Objects.equals(this.responseHeader, userListResponse.responseHeader) &&
                Objects.equals(this.usersList, userListResponse.usersList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responseHeader, usersList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserListResponse {\n");

        sb.append("    responseHeader: ").append(toIndentedString(responseHeader)).append("\n");
        sb.append("    usersList: ").append(toIndentedString(usersList)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
