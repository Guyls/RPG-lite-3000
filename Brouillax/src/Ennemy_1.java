public class Ennemy_1 extends Combatant {
        public Ennemy_1(String name, int HP){
                this.name = name;
                this.HP = HP;
                this.Description = "Un cochon hideux.";
                this.armor = 3;
                this.weapon = new Weapon("Groin proeminent", 5);
        }

        @Override
        public void attack(Combatant cible, Game game) {
                cible.setHP(cible.getHP()-this.weapon.getDegats());
                if(cible.getHP()<=0){
                        game.getEquipeHero().remove(cible);
                        game.getOrdreTour().remove(cible);
                        game.setNombreHero(game.getNombreHero()-1);
                }
        }
}
