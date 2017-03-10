package sokkelonselvitys.logiikka.tietorakenteet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author inka
 */
public class JonoTest {
    private Jono<Integer> jono;

    public JonoTest() {

    }

    @Before
    public void setUp() {
        this.jono = new Jono<>();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testJonoAlussaTyhja() {
        assertTrue(jono.tyhja());
        assertEquals(0, jono.koko());
    }

    @Test
    public void testAluksiHeadJaTailNolla() {
        assertEquals(0, jono.getHead());
        assertEquals(0, jono.getTail());
    }

    @Test
    public void testAlkiotSaadaanOikeassaJarjestyksessa() {
        for (Integer i = 1; i < 5; i++) {
            this.jono.lisaa(i);
        }
        assertEquals(1, (int) this.jono.ota());
        assertEquals(2, (int) this.jono.ota());
        assertEquals(3, (int) this.jono.ota());
        assertEquals(4, (int) this.jono.ota());
    }

    @Test
    public void testLisaysMuuttaaTailia() {
        assertEquals(0, jono.getTail());
        this.jono.lisaa(1);
        assertEquals(1, jono.getTail());
    }

    @Test
    public void testOttaminenMuuttaaHeadia() {
        assertEquals(0, jono.getHead());
        this.jono.lisaa(1);
        this.jono.lisaa(2);
        assertEquals(0, jono.getHead());
        this.jono.ota();
        assertEquals(1, jono.getHead());
    }

    @Test
    public void testTaulukkoKasvaaKunTaynna() {
        assertEquals(15, jono.getMaxKoko());
        assertEquals(0, jono.koko());
        for (int i = 1; i <= 15; i++) {
            this.jono.lisaa(i);
        }
        assertEquals(15, jono.koko());
        assertEquals(30, jono.getMaxKoko());
    }

    @Test
    public void testTaulukonKokoKasvaaOikein() {
        assertEquals(0, jono.koko());
        this.jono.lisaa(0);
        assertEquals(1, jono.koko());
        this.jono.lisaa(0);
        this.jono.lisaa(0);
        assertEquals(3, jono.koko());
        this.jono.ota();
        assertEquals(2, jono.koko());
    }
}