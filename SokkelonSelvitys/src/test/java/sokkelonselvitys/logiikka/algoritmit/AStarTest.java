package sokkelonselvitys.logiikka.algoritmit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import sokkelonselvitys.logiikka.Koordinaatti;
import sokkelonselvitys.logiikka.Ruutu;
import sokkelonselvitys.logiikka.SokkeloTehdas;

/**
 *
 * @author inka
 */
public class AStarTest {
    private Algoritmi astar;
    private Ruutu[][] sokkelo;
    
    public AStarTest() {
    }
    
    @Before
    public void setUp() {
        this.sokkelo = teeSokkelo();
        this.astar = new AStar(sokkelo, new Koordinaatti(0, 1), new Koordinaatti(6, 5));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void hello() {
        
    }

    private Ruutu[][] teeSokkelo() {
        this.sokkelo = new Ruutu[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                sokkelo[i][j] = Ruutu.MAA;
            }
        }
        return sokkelo;
    }
        
}
