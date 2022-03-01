import java.io.*;
/** Den här klassen representerar ett bokobjekt och den håller värden  id, name, author
 * count, year */
public class Bok implements Serializable {
    private String id, name, author, count, year;

    /** Konstruktör som sätter id, name, author, count och year på böcker som skapas */
    public Bok(String id, String name, String author, String count, String year) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.count = count;
        this.year = year;
    }

    /** hämtar värdet id som finns i bokobjeken  när den skapas */
    public String getId() {
        return id;
    }

    /** hämtar värdet name som finns i bokobjekten när den skapas */
    public String getName() {
        return name;
    }

    /** hämtar värdet author som finns i bokobjekten när den skapas */
    public String getAuthor() {
        return author;
    }

    public void setCount(String theCount) { count = theCount; }

    /** hämtar värdet count som finns i bokobjekten när den skapas*/
    public String getCount() {
        return count;
    }

    /** hämtar värdet year som finns i bokobjekten när den skapas*/
    public String getYear() {
        return year;
    }
}
