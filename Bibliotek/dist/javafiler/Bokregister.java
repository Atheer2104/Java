import java.io.*;
import java.util.*;

/** klassen representerar ett bokregister som använder sig av hashmap för att kunna lägga till, hitta samt ta bort böcker*/
public class Bokregister implements Serializable{
    private HashMap<String, Bok> books = new HashMap<String, Bok>();
    private Gui gui = new Gui();

    /** funktionen lägger till en bokobjekt i hashmapen där id är nyckeln*/
    public void addBok(Bok b) {
        books.put(b.getId(), b);
    }
    /** funktionen uppdaterar bokobjekter genom att hitta den med en id */
    public void updateBok(Bok b) {
        books.replace(b.getId(), b);
    }

    /** funktionen retunerar ett bokobjekt genom att använda sig av id som referens för att hitta bocken*/
    public Bok findBok(String id) {
        return books.get(id);
    }

    /** funktionen tar bort bokobjekten genom att hitta den med id*/
    public void removeBok(String id) {
        books.remove(id);
    }
    
}
