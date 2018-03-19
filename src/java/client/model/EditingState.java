package client.model;

public final class EditingState {
    private static final EditingState INSTANCE = new EditingState();
    private EditingState() {}
    public static EditingState getInstance() {
        return INSTANCE;
    }

    private State state = State.DISABLE;

    public enum State {
        ENABLE, DISABLE
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
