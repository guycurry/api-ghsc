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
    	DataAccess.ExecuteQuery("SELECT * FROM recipe_books WHERE User_ID = ?", UserID);

    	return books;
    }
    
}
