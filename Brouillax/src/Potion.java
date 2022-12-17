public class Potion extends Consommable{
    @Override
    public void use(Combatant c) {
        c.setMana(c.getMana() + this.soigne);
    }
}
