import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private ArrayList<Hero> equipeHero = new ArrayList<Hero>();

    private ArrayList<Ennemy_1> equipeEnnemy = new ArrayList<Ennemy_1>();

    private ArrayList<Combatant> ordreTour = new ArrayList<Combatant>();

    private InputParser inputParser;

    private int nombreHero;

    private int level = 1;

    private Combatant combatantActuel;

    public void startbattle(){


    }


    public void start2(){
        Scanner sc = new Scanner(System.in);
        this.inputParser= new ConsoleParser(this);
        inputParser.PrintText("Bienvenue dans l'école de l'ISEP, après un contrôle d'une complexité hors-norme,"+
                " les élèves, épris d'une rage inépuisable se transformèrent en monstres terrifiants."+
                "\n Votre équipe est constituée des seuls élèves qui ont réussi le contrôle est qui ne sont donc "+
                "pas devenus d'ignobles monstres.");

        inputParser.demandeNombreHero();

        /*
        System.out.println("Voulez vous un warrior ? [1/2]");
        String userInput = sc.nextLine();

        if ( userInput.equals("1"));
        System.out.println("Vous avez tappé 1 donc un putain de guerrier est ajouté a votre équipe.");
        teamHero.add(new Warrior());

        */


    }

    public void creerHero(int typeHero, String nom){
        if(typeHero==1){
            equipeHero.add(new Warrior(nom));
        }else if(typeHero==2){
            equipeHero.add(new Hunter(nom));
        }else if(typeHero==3){
            equipeHero.add(new Mage(nom));
        }else if(typeHero==4){
            equipeHero.add(new Healer(nom));
        }

        if(equipeHero.size()<this.nombreHero){
            //on genere un nouveau hero
            this.inputParser.demandeTypeHero(equipeHero.size()+1);

        }else {
            //On passe a la suite du programme
            this.genererEnnemy();
        }


    }

    public ArrayList<Hero> getEquipeHero() {
        return equipeHero;
    }

    public void setNombreHero(int nombreHero) {
        this.nombreHero = nombreHero;
    }

    public void genererEnnemy(){
        String[] nom = {"Carlochon", "Liliarve", "Remivre","Paulimace","Danidadou"};
        int[] hp = {10,12,15,17,25};
        for(int i =0; i<this.nombreHero; i++){
            equipeEnnemy.add(new Ennemy_1(nom[level-1],hp[level-1]));
        }
        this.choixOrdre();
        choixAction();
    }

    public void choixOrdre(){
        for(int i =0; i<this.nombreHero;i++){
            ordreTour.add(equipeHero.get(i));
            ordreTour.add(equipeEnnemy.get(i));
        }
        this.combatantActuel = this.ordreTour.get(0);

    }

    public void prochainCombattant(){
        int indice = this.ordreTour.indexOf(this.combatantActuel);

        if(indice==this.ordreTour.size()-1){
            this.combatantActuel = this.ordreTour.get(0);


        }else{
            this.combatantActuel = this.ordreTour.get(indice+1);
        }


    }

    public void choixAction(){
        if(this.combatantActuel instanceof Hero){
            this.inputParser.demandeAction();
        }else{
            int indice = (int)Math.random()*(equipeHero.size()-1);
            this.excuteAttaque(equipeHero.get(indice));
        }
    }

    public void excuteAttaque(Combatant cible){
        combatantActuel.attack(cible,this);
        this.inputParser.afficheDegats();
        finTour();

    }

    public void finTour(){
        if(equipeHero.size()==0){
            this.inputParser.lose();
        }else if(equipeEnnemy.size()==0){
            level++;
            levelup();
        }else {
            prochainCombattant();
            choixAction();

        }


    }

    private void levelup() {

        ordreTour = new ArrayList<Combatant>();

        for(Hero h : equipeHero){
            h.setHP(30);
        }
        if(level<6){
            this.inputParser.levelUp();
            genererEnnemy();
        }else {
            this.inputParser.win();
        }


    }




    public Combatant getCombatantActuel() {
        return combatantActuel;
    }

    public ArrayList<Ennemy_1> getEquipeEnnemy() {
        return equipeEnnemy;
    }

    public void consumeObject(Consommable c){
        c.use(combatantActuel);
        this.inputParser.afficheSoin();
        finTour();
    }


    public int getLevel() {
        return level;
    }

    public int getNombreHero() {
        return nombreHero;
    }

    public ArrayList<Combatant> getOrdreTour() {
        return ordreTour;
    }
}



















        

