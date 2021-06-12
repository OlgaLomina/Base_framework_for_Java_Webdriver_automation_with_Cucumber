package straightWithoutBdd.api.services.pojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "totalScore",
        "passingPercentage",
        "showStopperQuestion",
        "questions"
})

public class NewQuiz {

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
    @JsonProperty("totalScore")
    private Integer totalScore;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("passingPercentage")
    private Integer passingPercentage;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("showStopperQuestion")
    private Integer showStopperQuestion;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("questions")
    private List<Object> questions = null;

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
    @JsonProperty("totalScore")
    public Integer getTotalScore() {
        return totalScore;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("totalScore")
    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("passingPercentage")
    public Integer getPassingPercentage() {
        return passingPercentage;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("passingPercentage")
    public void setPassingPercentage(Integer passingPercentage) {
        this.passingPercentage = passingPercentage;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("showStopperQuestion")
    public Integer getShowStopperQuestion() {
        return showStopperQuestion;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("showStopperQuestion")
    public void setShowStopperQuestion(Integer showStopperQuestion) {
        this.showStopperQuestion = showStopperQuestion;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("questions")
    public List<Object> getQuestions() {
        return questions;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("questions")
    public void setQuestions(List<Object> questions) {
        this.questions = questions;
    }

}
