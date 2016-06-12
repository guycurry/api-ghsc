package API_GHSC;


public class RecipeBook extends DatabaseBaseObject {


	

    private final int id;

	public RecipeBook() {
		this.id = 1;
	}

    public RecipeBook(int id) {
        this.id = id;
    }


    public static RecipeBook[] GetRecipeBooksForUser(int UserID)
    {
    	RecipeBook[] books = new RecipeBook[0];

    	return books;
    }
    
}
