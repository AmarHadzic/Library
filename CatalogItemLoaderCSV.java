import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class CatalogItemLoaderCSV
{
    private ArrayList<CatalogItem> items;

    public CatalogItemLoaderCSV()
    {
        this.items = new ArrayList<CatalogItem>();
    }

    public void loadItems(String fileName) throws IOException
    {   
        //creates file object of given csv file
        File file = new File(fileName);
        Scanner scanner;

        //reads the file line by line
        scanner = new Scanner(file);
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            String[] input = line.split(",");
            
            //checks that the line is in valid format
            if( input.length < 8 || !(input[4].equals("movie") || input[4].equals("book")) || 
                ( !(input[1].equals("0")) && !(input[1].equals("1")) ))
            {
                continue;
            }
            
            //attributes of book or movie are instantiated here
            String id = input[0];
            boolean availability;
            int availabilityInput = Integer.parseInt(input[1]);
            
            if(availabilityInput == 0)
            {
                availability = false;
            }
            else
            {
                availability = true;
            }
            String title = input[2];
            int year = Integer.parseInt(input[3]);
            String type = input[4];

            if(type.equals("movie") && input.length == 8)
            {
                String firstName = input[5];
                String lastName = input[6];
                String rating = input[7];

                //creates movie object and adds it to catalog
                Movie movie = new Movie(title, year, firstName, lastName, rating);
                CatalogItem item = new CatalogItem(movie, id, availability);
                this.items.add(item);
            }
            else if(type.equals("book") && input.length == 9)
            {
                String firstName = input[5];
                String lastName = input[6];
                String publisher = input[7];
                String isbn = input[8];

                //creates book object and adds it to catalog
                Book book = new Book(title, year, firstName, lastName, publisher, isbn);
                CatalogItem item = new CatalogItem(book, id, availability);
                this.items.add(item);
            }
            
        }
    }

    public ArrayList<CatalogItem> getItems()
    {
        return this.items;
    }
    
}