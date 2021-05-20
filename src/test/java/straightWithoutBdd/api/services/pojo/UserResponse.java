package straightWithoutBdd.api.services.pojo;

public class UserResponse {

    UserResponse() {
    }

    public UserResponse(User user, Token token) {
        this.user = user;
        this.token = token;
    }

    private User user;
    private Token token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
