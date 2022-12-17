public class Mage extends SpellCaster{

    public Mage(String name) {

        this.name = name;
        this.HP = 10;
        this.Description = "Mage puissant";
        this.armor = 1;
        this.mana_Max = 20;
        this.mana_Spent = 3;
        this.weapon = new Weapon("Sceptre de la bonne Carlott",5);
        this.getConsommables().add(new Food());
        this.getConsommables().add(new Potion());
    }

    @Override
    public void attack(Combatant cible,  Game game) {
        if(this.getMana()>=this.mana_Spent){
            cible.setHP(cible.getHP()-this.weapon.getDegats());
            if(cible.getHP()<=0){
                game.getEquipeEnnemy().remove(cible);
            }
            cible.setMana(cible.getMana()-this.mana_Spent);
            game.getOrdreTour().remove(cible);
        }

    }
}


