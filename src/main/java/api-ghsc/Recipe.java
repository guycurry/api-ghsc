package API_GHSC;

public class Recipe {

    private final String id;
    private final String api_id;

    public RecipeBook(String id, String api_id) {
        this.id = id;
        this.api_id = api_id;
    }

    public String getId() {
        return id;
    }

    public String getAPI_ID() {
        return api_id;
    }
}
