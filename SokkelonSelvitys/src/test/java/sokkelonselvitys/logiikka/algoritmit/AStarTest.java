package sokkelonselvitys.logiikka.algoritmit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import sokkelonselvitys.logiikka.Koordinaatti;
import sokkelonselvitys.logiikka.Ruutu;
import sokkelonselvitys.logiikka.SolmunTila;

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
    public void testReitinLoytymisenJalkeenValmisOnTrue() {
        suorita();
        assertTrue(astar.onValmis());
    }

    @Test
    public void testLopetaLopettaaAlgoritmin() {
        new Thread(astar).start();
        astar.lopeta();
        assertTrue(astar.getReittiMaalille() == null);
        assertFalse(astar.onValmis());
    }

    @Test
    public void testSolmujenTilatVaihdetaanReitiksiOikein() {
        this.astar = new AStar(sokkelo, new Koordinaatti(0, 1), new Koordinaatti(6, 1));
        suorita();
        assertEquals(SolmunTila.REITTI, astar.solmujenTilaRuudukko[1][0]);
        assertEquals(SolmunTila.REITTI, astar.solmujenTilaRuudukko[1][1]);
        assertEquals(SolmunTila.REITTI, astar.solmujenTilaRuudukko[1][2]);
        assertEquals(SolmunTila.REITTI, astar.solmujenTilaRuudukko[1][3]);
        assertEquals(SolmunTila.REITTI, astar.solmujenTilaRuudukko[1][4]);
        assertEquals(SolmunTila.REITTI, astar.solmujenTilaRuudukko[1][5]);
        assertEquals(SolmunTila.REITTI, astar.solmujenTilaRuudukko[1][6]);
    }

    @Test
    public void testAlgoritmiLoytaaReitin() {
        suorita();
        assertTrue(astar.getReittiMaalille() != null);
    }

    @Test
    public void testAlgoritmiLoytaaLyhyimmanReitin() {
        suorita();
        assertEquals(10, astar.getReittiMaalille().getKuljetunReitinPituus());
    }

    @Test
    public void testAlgoritmiEiTormaaEsteeseen() {
        teeEste();
        suorita();
        assertTrue(astar.getReittiMaalille() != null);
        assertEquals(12, astar.getReittiMaalille().getKuljetunReitinPituus());
        assertTrue(astar.solmujenTilaRuudukko[0][1] == null);
        assertTrue(astar.solmujenTilaRuudukko[1][1] == null);
        assertTrue(astar.solmujenTilaRuudukko[2][1] == null);
        assertTrue(astar.solmujenTilaRuudukko[3][1] == null);
        assertTrue(astar.solmujenTilaRuudukko[4][1] == null);
        assertTrue(astar.solmujenTilaRuudukko[5][1] == null);
    }

    @Test
    public void testAlgoritmiEtsiiOikeastaSuunnasta() {
        this.astar = new AStar(sokkelo, new Koordinaatti(4, 3), new Koordinaatti(6, 5));
        suorita();
        assertEquals(4, astar.getReittiMaalille().getKuljetunReitinPituus());
        assertTrue(astar.solmujenTilaRuudukko[2][2] == null);
        assertTrue(astar.solmujenTilaRuudukko[3][2] == null);
        assertTrue(astar.solmujenTilaRuudukko[4][2] == null);
        assertTrue(astar.solmujenTilaRuudukko[5][2] == null);
        assertTrue(astar.solmujenTilaRuudukko[2][3] == null);
    }

    @Test
    public void testAlgoritmiValitseeMaanMielumminKuinVeden() {
        teeVetta();
        suorita();
        assertFalse(astar.solmujenTilaRuudukko[4][5] == SolmunTila.REITTI);
        assertFalse(astar.solmujenTilaRuudukko[5][5] == SolmunTila.REITTI);
    }

    public void suorita() {
        new Thread(astar).start();
        int laskuri = 0;
        while (!astar.onValmis()) {
            if (laskuri > 100) {
                fail("Kestää liian kauan");
            }
            laskuri++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

        }
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

    private void teeEste() {
        for (int i = 0; i < 6; i++) {
            this.sokkelo[i][1] = Ruutu.ESTE;
        }
    }

    private void teeVetta() {
        this.sokkelo[4][5] = Ruutu.VESI;
        this.sokkelo[5][5] = Ruutu.VESI;
    }

}
