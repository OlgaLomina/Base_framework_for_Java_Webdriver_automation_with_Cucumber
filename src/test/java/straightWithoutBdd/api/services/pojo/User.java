
package straightWithoutBdd.api.services.pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "email",
    "name",
    "group",
    "role",
    "createdAt",
    "updatedAt"
})

public class User {

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
    @JsonProperty("email")
    private String email;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("group")
    private String group;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("role")
    private String role;
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
