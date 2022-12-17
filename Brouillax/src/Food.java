public class Food extends Consommable{
    @Override
    public void use(Combatant c) {
        c.setHP(c.getHP()+this.soigne);
    }
}
