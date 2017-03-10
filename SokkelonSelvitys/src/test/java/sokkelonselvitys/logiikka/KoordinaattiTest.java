package sokkelonselvitys.logiikka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author inka
 */
public class KoordinaattiTest {
    private Koordinaatti koord;

    public KoordinaattiTest() {
    }

    @Before
    public void setUp() {
        this.koord = new Koordinaatti(1, 1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testXPalautuuOikein() {
        assertEquals(1, this.koord.getX());
    }

    @Test
    public void testYPalautuuOikein() {
        assertEquals(1, this.koord.getY());
    }

    @Test
    public void testYlaNaapuriOikein() {
        Koordinaatti yla = new Koordinaatti(1, 0);
        assertTrue(this.koord.naapuriKoordinaatit(Koordinaatti.Suunta.YLOS).equals(yla));
    }

    @Test
    public void testAlaNaapuriOikein() {
        Koordinaatti ala = new Koordinaatti(1, 2);
        assertTrue(this.koord.naapuriKoordinaatit(Koordinaatti.Suunta.ALAS).equals(ala));
    }

    @Test
    public void testOikeaNaapuriOikein() {
        Koordinaatti oikea = new Koordinaatti(2, 1);
        assertTrue(this.koord.naapuriKoordinaatit(Koordinaatti.Suunta.OIKEA).equals(oikea));
    }

    @Test
    public void testVasenNaapuriOikein() {
        Koordinaatti vasen = new Koordinaatti(0, 1);
        assertTrue(this.koord.naapuriKoordinaatit(Koordinaatti.Suunta.VASEN).equals(vasen));
    }

    @Test
    public void testEqualsPalauttaaFalseJosEiSamaY() {
        Koordinaatti k = new Koordinaatti(1, 0);
        assertFalse(this.koord.equals(k));
    }

    @Test
    public void testEqualsPalauttaaFalseJosEiSamaX() {
        Koordinaatti k = new Koordinaatti(0, 1);
        assertFalse(this.koord.equals(k));
    }

    @Test
    public void testEqualsPalauttaaFalseJosNullTaiEiKoordinaatti() {
        Koordinaatti i = null;
        assertFalse(this.koord.equals(i));
        int j = 1;
        assertFalse(this.koord.equals(j));
    }
}