import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TableauTest {

    public Tableau tableau = new Tableau(5,5,new Deck());

    @Test
    public void testTableauConstructor(){
        System.out.println(tableau);
    }

    @Test
    public void testConsolidate() {
        System.out.println(tableau);
        tableau.tableau[4] = null;
        tableau.tableau[5] = null;
        tableau.tableau[11] = null;
        tableau.tableau[13] = null;
        tableau.consolidate();
        System.out.println(tableau);
    }
}