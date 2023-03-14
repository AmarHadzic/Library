public class Book extends LibraryItem
{
   private String firstName;
   private String lastName;
   private String isbn;
   private String publisher;

   public Book(String title, int year, String firstName, String lastName, String publisher, String isbn)
   {
      super(title, year);
      this.firstName = firstName;
      this.lastName = lastName;
      this.publisher = publisher;
      this.isbn = isbn;
   }

   public String getAuthorFirstName()
   {
      return this.firstName;
   }

   public String getAuthorLastName()
   {
      return this.lastName;
   }

   public String getISBN()
   {
      return this.isbn;
   }

   public String getPublisher()
   {
      return this.publisher;
   }

   //checks to see if the keyword matches to attributes of book class
   @Override
   public boolean matches(String keyword)
   {
      if(super.matches(keyword) ||
         this.firstName.equals(keyword) ||
         this.lastName.equals(keyword) ||
         this.publisher.equals(keyword) ||
         this.isbn.equals(keyword))
      {
         return true;
      }

      return false;
   }

   @Override
   public String toString()
   {
      return new String(this.title+", "+this.year+" "+this.firstName+", "+this.lastName+", "+this.publisher+", "+this.isbn);
   }
}
