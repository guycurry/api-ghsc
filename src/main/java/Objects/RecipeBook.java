package API_GHSC;


import java.sql.*;

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

    	DataAccess.ExecuteQuery("SELECT * FROM recipe_books WHERE User_ID = ?", UserID);

    	return books;
    }
    
}
