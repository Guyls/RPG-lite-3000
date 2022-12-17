import java.util.ArrayList;

public abstract class Hero extends Combatant {

    private ArrayList<Consommable> consommables = new ArrayList<Consommable>();

    public ArrayList<Consommable> getConsommables() {
        return consommables;
    }
}


