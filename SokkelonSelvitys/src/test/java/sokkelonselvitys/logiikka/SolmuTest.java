package sokkelonselvitys.logiikka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author inka
 */
public class SolmuTest {
    private Solmu solmu;

    public SolmuTest() {
    }

    @Before
    public void setUp() {
        this.solmu = new Solmu(new Koordinaatti(1, 1), null, 0);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testXKoordinaattiSaadaanOikein() {
        assertEquals(1, this.solmu.getX());
    }

    @Test
    public void testYKoordinaattiSaadaanOikein() {
        assertEquals(1, this.solmu.getY());
    }

    @Test
    public void testKoordinaatitSaadaanOikein() {
        Koordinaatti k = new Koordinaatti(1, 1);
        assertTrue(this.solmu.getKoordinaatit().equals(k));
    }

    @Test
    public void testKuljettuReittiOnOikein() {
        assertEquals(0, this.solmu.getKuljetunReitinPituus());
    }

    @Test
    public void testTilaOikeinAluksi() {
        assertEquals(null, this.solmu.getTila());
    }

    @Test
    public void testTilaMuuttuuOikein() {
        assertEquals(null, this.solmu.getTila());
        this.solmu.setTila(SolmunTila.LOYDETTY);
        assertEquals(SolmunTila.LOYDETTY, this.solmu.getTila());
    }

    @Test
    public void testEdellinenSolmuAlussaNull() {
        assertEquals(null, this.solmu.getEdellinen());
    }
}