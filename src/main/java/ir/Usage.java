package ir;

public class Usage {
    private User user;
    private Value value;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Usage(User user, Value value) {
        this.user = user;
        this.value = value;
    }
}
