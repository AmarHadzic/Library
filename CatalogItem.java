public class CatalogItem
{
   private LibraryItem libraryItem;
   private String uniqueId;
   private boolean available;

   public CatalogItem(LibraryItem libraryItem, String id, boolean availability)
   {
      this.libraryItem = libraryItem;
      this.uniqueId = id;
      this.available = availability;
   }

   public LibraryItem getLibraryItem()
   {
      return this.libraryItem;
   }

   public String getId()
   {
      return this.uniqueId;
   }

   public boolean isAvailable()
   {
      return this.available;
   }

   public void setAvailable()
   {
      this.available = true;
   }

   public void setUnavailable()
   {
      this.available = false;
   }
}
