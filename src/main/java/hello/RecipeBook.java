package hello;

public class RecipeBook {

    private final String id;
    private final String content;

    public RecipeBook(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
