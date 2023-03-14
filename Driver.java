import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Driver
{
    public static void main(String args[])
    {
        //instantiates a CatalogItemLoaderCSV object
        CatalogItemLoaderCSV loader = new CatalogItemLoaderCSV();
        if(args.length > 0) //checks to see if command line arguments are valid
        {
            //loads items into the CatalogItemLoaderCSV object
            try{
                loader.loadItems(args[0]);
            }catch(IOException error){
                System.out.println("Books and movies cannot be loaded");
                return;
            }
            
            //saves the collection of books and movies into an ArrayList
            ArrayList<CatalogItem> listOfItems = loader.getItems();
            Catalog catalog;

            //instantiates a Catalog object and passes the prior listOfItems
            try{
                catalog = new Catalog(listOfItems);
            }catch(IllegalArgumentException error){
                System.out.println(error);
                return;
            }

            while(true){
                System.out.println("\nEnter a search term (enter -1 to quit): ");
                try{
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String input = reader.readLine();
                    if(input.equals("-1"))
                    {
                        return;
                    }
                    //Searches each book or movie and their desired attributes for the search term below
                    ArrayList<String> itemSearch = catalog.search(input);
                
                    if(itemSearch.size()>0){
                        System.out.println("\nbooks and movies with the search term: " + input);
                        //prints each book or movie with the searchterm
                        for(int i=0; i<itemSearch.size(); i++){
                            System.out.println("*" + catalog.getLibraryItem(itemSearch.get(i)));
                        }
                    }else{
                        System.out.println("No items found with the search term: " + input);
                    }
                }catch(Exception err)
                {
                    System.out.println(err);
                    return;
                }
                
            }  

        }
        else
        {
            System.out.println("Usage: java Driver <FILE>");
            return;
        }

    }

}