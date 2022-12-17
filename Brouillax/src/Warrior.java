public class Warrior extends Hero {
    public Warrior(String name){

        this.name = name;
        this.HP = 25;
        this.Description = "Puissant guerrier";
        this.armor = 3;
        this.weapon = new Weapon("Hache sanguinaire", 5);
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


