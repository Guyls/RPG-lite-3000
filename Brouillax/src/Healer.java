public class Healer extends SpellCaster {

    public Healer(String name){
        this.name = name;


        this.HP = 10;
        this.Description = "Soigneur en herbe médicinale";
        this.armor = 1;
        this.mana_Max = 20;
        this.mana_Spent = 3;
        this.weapon = new Weapon("baton de soin", 3);
        this.getConsommables().add(new Food());
        this.getConsommables().add(new Potion());

    }

    @Override
    public void attack(Combatant cible, Game game) {
        cible.setHP(cible.getHP()+this.weapon.getDegats());
    }
}