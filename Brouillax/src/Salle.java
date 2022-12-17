import java.util.ArrayList;
import java.util.List;

public class Salle {
    int number;
    String name;
    List<String> desc = new ArrayList<String>();
    public Salle(int x){
        number = x;
    }
    static ArrayList<Salle> salle = new ArrayList<Salle>();
}
