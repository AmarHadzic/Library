import java.util.ArrayList;

public class Catalog
{
   private ArrayList<CatalogItem> catalogItems;
   private int nextId;

   /**
    * Instantiate an empty list of catalog itemss
    */
   public Catalog()
   {
      catalogItems = new ArrayList<CatalogItem>();
      nextId = 0;
   }

   public Catalog(ArrayList< CatalogItem > items) throws IllegalArgumentException
   {
      catalogItems = new ArrayList<CatalogItem>();
      if (!isUnique(items))
      {
         throw new IllegalArgumentException("IDs must be unqiue");
      }

      this.catalogItems = items;

   }

   // checks to see if every id is unique of the csv file 
   private boolean isUnique(ArrayList<CatalogItem> items)
   {
      boolean unique = true;
      for (int i=0; i<items.size()-1; i++)
      {
         for (int j=i+1; j<items.size(); j++)
         {
            if(items.get(i).getId().equals(items.get(j).getId()))
            {
               unique = false;
               return unique;
            }
         }
      }
      return unique;
   }

   /**
    * Adds a book/movie to the catalog
    */
   public String add(LibraryItem libraryItem)
   {
      this.nextId = getLargestId(this.catalogItems);
      nextId++;
      String itemID = String.valueOf(nextId);
      addItemWithId(libraryItem, itemID);
      return itemID;
   }


   /**
    * If the library item with the specified id is in the catalog's collection and is available for checkout, 
    * the Catalog class marks this library item as unavailable and returns True (meaning, checkout was successful). 
    * Otherwise, the method returns false.
    */
   public boolean checkout(String id)
   {
      CatalogItem matchedItem = findItem(id);
      boolean retValue = false;

      // if the library item is available, make it not available
      // checkout is successful
      if (matchedItem != null && matchedItem.isAvailable())
      {
         matchedItem.setUnavailable();
         retValue = true;
      }

      return retValue;
   }

   /**
    * If the library item with the specified id is in the catalog's collection and is currently checked out, 
    * the Catalog marks this library item as available and returns true (meaning, the return was successful). 
    * Otherwise, the method returns false. 
    */
   public boolean checkin(String id)
   {
      CatalogItem matchedItem = findItem(id);
      boolean retValue = false;

      // if the library item is found and is currently unavailable, mark it as available
      if (matchedItem != null && !matchedItem.isAvailable())
      {
         matchedItem.setAvailable();
         retValue = true;
      }

      return retValue;
   }

   /*
    * Searches the  catalog for movies/books that match the searchTerm exactly (equals) in the 
    * Title, Authors First Name, Authors Last name, publisher or isbn attributes of the Book class. 
    * Title, producers first name, producers last name, or rating attributes of the movie class.
    *Returns the ArrayList of 
    * String objects - ids of the items that matched the searchTerm
    **/
   public ArrayList<String> search(String searchTerm)
   {
      ArrayList<String> retValue = new ArrayList<String>();

      // go through every library item in the catalog and check if it matches the searchTerm
      for (CatalogItem item: this.catalogItems)
      { 
         LibraryItem libraryItem = item.getLibraryItem();

         if (libraryItem.matches(searchTerm))
         {
             retValue.add(item.getId());
         }
      }

      return retValue;
   }

   public LibraryItem getLibraryItem(String id)
   {
      CatalogItem item = findItem(id);
      LibraryItem retValue = null;
      if (item != null)
      {
         retValue = item.getLibraryItem();
      }
      return retValue;
   }
   /*
    * if the library item (book or movie) is available for checkout, removes it.
    **/
   public boolean remove(String id)
   {
      CatalogItem item = findItem(id);
      boolean retValue = false;

      if (item != null && item.isAvailable())
      {
         this.catalogItems.remove(item);
         retValue = true;
      }
      return retValue;
   }


   private void addItemWithId(LibraryItem libraryItem, String id)
   {
      CatalogItem item = new CatalogItem(libraryItem, id, true);
      catalogItems.add(item);
   }


   private CatalogItem findItem(String id)
   {
      CatalogItem matchedItem   = null;

      // find the library item with the specified id
      for (CatalogItem item: this.catalogItems)
      {
         if (item.getId().equals(id))
         {
            matchedItem = item;
            break;
         }
      }
      return matchedItem;
   }

   //finds the largest numeric id in the catalog, if there is one and returns it +1
   private int getLargestId(ArrayList<CatalogItem> items)
   {
      int largestId = 0;

      for(CatalogItem item: items)
      {
         try
         {
            if( Integer.parseInt(item.getId()) >= largestId)
            {
               largestId = Integer.parseInt(item.getId()) + 1;
            }
         }
         
         catch(NumberFormatException error)
         {
            continue;
         }
      }  

      return largestId;
   }

}
