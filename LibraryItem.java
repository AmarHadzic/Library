public class LibraryItem
{
    protected String title;
    protected int year;

    public LibraryItem(String title, int year)
    {
        this.title = title;
        this.year = year;
    }

    public String getTitle()
    {
        return this.title;
    }

    public int getYear()
    {
        return this.year;
    }

    public String toString()
    {
        return new String(this.title + ", " + this.year);
    }

    public boolean matches(String keyword)
    {
        if(this.title.equals(keyword))
        {
            return true;
        }
        return false;

    }

}