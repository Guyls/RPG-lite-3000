import java.util.ArrayList;

public interface InputParser {




     void PrintText (String string);

     int getInt();

     int getIntRange(int start, int end);

     void demandeTypeHero(int numeroHero);

     void demandeNombreHero();

     void demandeAction();

     void choixCible();

     void choixObjet();

     void afficheDegats();

     void afficheSoin();

     void levelUp();

     void win();

     void lose();




}
