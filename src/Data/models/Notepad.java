package Data.models;

public class Notepad extends BaseNote{
    private static int incrementedId = 0;
    private String title;

    public Notepad() {
        super();
        incrementedId++;
    }
    @Override
    public String toString() {
        return "[%s] (%s) %s%n".formatted(
                getId(),getTitle(),getDescription()
        );
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public int getIncrementedId() {
        return incrementedId;
    }

}
