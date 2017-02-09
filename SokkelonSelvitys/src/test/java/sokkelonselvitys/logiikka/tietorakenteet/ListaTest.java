package sokkelonselvitys.logiikka.tietorakenteet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author inka
 */
public class ListaTest {

    private Lista<Integer> lista;

    public ListaTest() {
    }

    @Before
    public void setUp() {
        this.lista = new Lista<>();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testListaAlussaTyhja() {
        assertTrue(lista.tyhja());
        assertEquals(0, this.lista.getKoko());
    }

    @Test
    public void testListaKasvattaaKokoaanKunTaysi() {
        assertEquals(15, this.lista.getMaxKoko());
        for (int i = 1; i <= 15; i++) {
            this.lista.lisaa(i);
        }
        assertEquals(15, this.lista.getMaxKoko());
        this.lista.lisaa(16);
        assertEquals(30, this.lista.getMaxKoko());
    }

    @Test
    public void testListanKokoKasvaaOikein() {
        assertEquals(0, lista.getKoko());
        lista.lisaa(1);
        assertEquals(1, lista.getKoko());
        lista.lisaa(1);
        lista.ota(0);
        assertEquals(2, lista.getKoko());
        lista.poista(0);
        assertEquals(1, lista.getKoko());
    }

    @Test
    public void testLisattavaLisataanListanLoppuun() {
        this.lista.lisaa(0);
        this.lista.lisaa(10);
        assertEquals(2, lista.getKoko());
        this.lista.lisaa(20);
        assertEquals(20, (int) lista.ota(2));
    }

    @Test
    public void testListastaSaadaanOikeatAlkiot() {
        for (int i = 0; i < 10; i++) {
            this.lista.lisaa(i);
        }

        assertEquals(0, (int) this.lista.ota(0));
        assertEquals(5, (int) this.lista.ota(5));
        assertEquals(9, (int) this.lista.ota(9));
    }

    @Test
    public void testPoistaminenPoistaaOikeanAlkion() {
        this.lista.lisaa(0);
        this.lista.lisaa(10);
        this.lista.lisaa(20);
        this.lista.lisaa(30);

        this.lista.poista(2);
        assertEquals(0, (int) this.lista.ota(0));
        assertEquals(10, (int) this.lista.ota(1));
        assertEquals(30, (int) this.lista.ota(2));
    }
}
