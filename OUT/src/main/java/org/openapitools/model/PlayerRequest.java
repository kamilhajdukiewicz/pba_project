package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class PlayerRequest {
    @JsonProperty("requestHeader")
    private io.swagger.model.RequestHeader requestHeader = null;

    @JsonProperty("player")
    private Player user = null;

    public PlayerRequest requestHeader(io.swagger.model.RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
        return this;
    }

    /**
     * Get requestHeader
     * @return requestHeader
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public io.swagger.model.RequestHeader getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(io.swagger.model.RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }

    public PlayerRequest user(Player user) {
        this.user = user;
        return this;
    }

    /**
     * Get user
     * @return user
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public Player getUser() {
        return user;
    }

    public void setUser(Player user) {
        this.user = user;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerRequest updateRequest = (PlayerRequest) o;
        return Objects.equals(this.requestHeader, updateRequest.requestHeader) &&
                Objects.equals(this.user, updateRequest.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestHeader, user);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateRequest {\n");

        sb.append("    requestHeader: ").append(toIndentedString(requestHeader)).append("\n");
        sb.append("    player: ").append(toIndentedString(user)).append("\n");
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
