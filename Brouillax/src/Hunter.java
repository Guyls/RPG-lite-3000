import java.util.ArrayList;

public class Hunter extends Hero {
     int nb_Fleche;

    public Hunter(String name){
        this.name = name;
        this.HP = 15;
        this.Description = "Chasseur aguerri";
        this.armor = 2;
        this.nb_Fleche = 30;
        this.weapon = new Weapon("Arbalete chirurgicale",5);
        this.getConsommables().add(new Food());
        this.getConsommables().add(new Potion());

    }


    @Override
    public void attack(Combatant cible, Game game) {
        cible.setHP(cible.getHP()-this.weapon.getDegats());
        if(cible.getHP()<=0){
            game.getEquipeEnnemy().remove(cible);
            game.getOrdreTour().remove(cible);
        }

    }
}