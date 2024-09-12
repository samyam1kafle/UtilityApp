package Data.models;

public class ToDo extends BaseNote{
    private static int incrementedId = 0;
    private boolean isCompleted = false;

    public int getIncrementedId() {
        return incrementedId;
    }

    @Override
    public String toString() {
        return "{" +
                "Id=" + getId() +
                ", Description=" + getDescription() +
                ", isCompleted=" + isCompleted +
                '}';
    }

    public ToDo() {
        super();
        incrementedId++;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

}
