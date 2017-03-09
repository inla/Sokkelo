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
public class BFSTest {

    private Algoritmi bfs;
    private Ruutu[][] sokkelo;

    public BFSTest() {
    }

    @Before
    public void setUp() {
        this.sokkelo = teeSokkelo();
        this.bfs = new BFS(sokkelo, new Koordinaatti(0, 1), new Koordinaatti(6, 5));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAlgoritmiLoytaaReitin() {
        suorita();
        assertTrue(bfs.getReittiMaalille() != null);
    }

    @Test
    public void testAlgoritmiLoytaaLyhyimmanReitin() {
        suorita();
        assertEquals(10, bfs.getReittiMaalille().getKuljetunReitinPituus());
    }

    @Test
    public void testAlgoritmiEiTormaaEsteeseen() {
        teeEste();
        suorita();
        assertTrue(bfs.getReittiMaalille() != null);
        assertEquals(12, bfs.getReittiMaalille().getKuljetunReitinPituus());
        assertTrue(bfs.solmujenTilaRuudukko[0][1] == null);
        assertTrue(bfs.solmujenTilaRuudukko[1][1] == null);
        assertTrue(bfs.solmujenTilaRuudukko[2][1] == null);
        assertTrue(bfs.solmujenTilaRuudukko[3][1] == null);
        assertTrue(bfs.solmujenTilaRuudukko[4][1] == null);
        assertTrue(bfs.solmujenTilaRuudukko[5][1] == null);
    }

    public void suorita() {
        new Thread(bfs).start();
        int laskuri = 0;
        while (!bfs.onValmis()) {
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
}
