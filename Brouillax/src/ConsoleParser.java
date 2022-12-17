import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleParser implements InputParser{

    private Scanner sc = new Scanner(System.in);
    private Game game;

    public ConsoleParser(Game game){
        this.game = game;
    }

    @Override
    public void PrintText(String string) {
        System.out.println(string);
    }

    @Override
    public int getInt() {
        int input = 0;
        while (input==0){
            String str = this.sc.nextLine();
            try {
                input = Integer.parseInt(str);
            }catch (Exception e){
                System.out.println("Veuillez entrer un entier");
            }

        }
        return input;

    }

    @Override
    public int getIntRange(int start, int end){
        int input;
        input = getInt();
        while(input<start || input>end){
            System.out.println("veuillez entrer une valeur entre "+start+" et "+end);
            input = getInt();
        }
        return input;
    }

    @Override
    public void demandeNombreHero(){
        System.out.println("Combien voulez vous de hero dans votre equipe ?");
        int nombreHero = getIntRange(1,10);
        this.game.setNombreHero(nombreHero);
        demandeTypeHero(1);


    }

    @Override
    public void demandeAction() {
        System.out.println("Voulez vous executer une attaque ou prendre un objet ?");
        System.out.println("(1) Attaque");
        System.out.println("(2) Objets");
        int input = getIntRange(1,2);
        if(input==1){
            this.choixCible();
        }else {
            this.choixObjet();
        }
    }

    @Override
    public void choixCible() {
        ArrayList<Combatant> list = new ArrayList<Combatant>();
        if(this.game.getCombatantActuel() instanceof Healer){
            for(Hero hero : this.game.getEquipeHero()){
                list.add(hero);
            }
        }else{
            for(Ennemy_1 ennemy : this.game.getEquipeEnnemy()) {
                list.add(ennemy);
            }
        }
        for(int i = 0; i<list.size();i++){
            Combatant c = list.get(i);
            System.out.println("("+(i+1)+") "+c.getName()+" | Hp : "+c.getHP());
        }

        int input = getIntRange(1,list.size());

        Combatant cible = list.get(input-1);
        this.game.excuteAttaque(cible);


    }

    @Override
    public void choixObjet() {
        System.out.println("Veuillez choisir un objet");
        Hero hero = (Hero) this.game.getCombatantActuel();
        for(Consommable c : hero.getConsommables()){
            if(c instanceof Food){
                System.out.println("("+(hero.getConsommables().indexOf(c)+1)+") Food");
            }else {
                System.out.println("("+(hero.getConsommables().indexOf(c)+1)+") Potion");
            }

        }
        int input = getIntRange(1,hero.getConsommables().size());
        this.game.consumeObject(hero.getConsommables().get(input-1));


    }

    @Override
    public void afficheDegats() {
        System.out.println("\n"+"-".repeat(30));
        Combatant c = this.game.getCombatantActuel();
        System.out.println(c.getName()+ " Vient d'infliger "+c.getWeapon().getDegats());
    }

    @Override
    public void afficheSoin() {
        System.out.println("\n"+"-".repeat(30));
        Combatant c = this.game.getCombatantActuel();
        System.out.println(c.getName()+ " s'est soigné grace a un objet ");
    }

    @Override
    public void levelUp() {
        System.out.println("\n"+"-".repeat(30));
        System.out.println("Bravo vous avez fini le niveau "+(this.game.getLevel()-1));

        System.out.println("Vous passez maintenant au niveau "+this.game.getLevel());
    }


    @Override
    public void demandeTypeHero(int numeroHero){
        System.out.println("Quel type de hero voulez vous pour le hero numero "+numeroHero+" ?");
        System.out.println("(1) Warrior");
        System.out.println("(2) Hunter");
        System.out.println("(3) Mage");
        System.out.println("(4) Healer");
        int nombre = getIntRange(1,4);
        this.demandeNom(nombre);

    }

    public void demandeNom(int nombre){
        System.out.println("Choisissez un nom pour votre hero ");
        String nom = this.sc.nextLine();
        this.game.creerHero(nombre,nom);
    }
    @Override
    public void win() {
        System.out.println("-".repeat(30));
        System.out.println("Bravo vous avez gangne");
    }
    @Override
    public void lose() {
        System.out.println("-".repeat(30));
        System.out.println("Domage vous avez perdu");

    }

}






