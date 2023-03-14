public class Movie extends LibraryItem
{
    private String producerFirstName;
    private String producerLastName;
    private String rating;

    public Movie(String title, int year, String firstName, String lastName, String rating)
    {
        super(title, year);
        this.producerFirstName = firstName;
        this.producerLastName = lastName;
        this.rating = rating;
    }

    public String getProducerFirstName()
    {
        return this.producerFirstName;
    }

    public String getProducerLastName()
    {
        return this.producerLastName;
    }

    public String getRating()
    {
        return this.rating;
    }

    //checks to see if keyword matches the desired attributes of the movie class
    @Override
    public boolean matches(String keyword)
    {
        if(super.matches(keyword) ||
           this.producerFirstName.equals(keyword) ||
           this.producerLastName.equals(keyword) ||
           this.rating.equals(keyword))
        {
            return true;
        }

        return false;

    }

    @Override
    public String toString()
    {
        return new String(this.title+", "+this.year+" "+this.producerFirstName+", "+this.producerLastName+", "+this.rating);
    }

}