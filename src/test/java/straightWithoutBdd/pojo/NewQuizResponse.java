package straightWithoutBdd.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "createdAt",
        "updatedAt"
})

public class NewQuizResponse {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("id")
    private Integer id;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("createdAt")
    private String createdAt;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("updatedAt")
    private String updatedAt;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}