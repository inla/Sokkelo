package sokkelonselvitys.logiikka.tietorakenteet;

import java.util.Comparator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author inka
 */
public class MinimikekoTest {

    private Minimikeko<Integer> keko;
    private Comparator<Integer> c;

    public MinimikekoTest() {
        this.c = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
    }

    @Before
    public void setUp() {
        
        this.keko = new Minimikeko<>(c);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testKekoAlussaTyhja() {
        assertTrue(this.keko.tyhja());
    }

    @Test
    public void testKekoKasvattaaKokoaanKunTaysi() {
        assertEquals(15, this.keko.getMaxKoko());
        for (int i = 1; i < 15; i++) {
            this.keko.lisaa(i);
        }
        assertEquals(15, this.keko.getMaxKoko());
        this.keko.lisaa(15);
        assertEquals(30, this.keko.getMaxKoko());
    }

    @Test
    public void testKeonKokoKasvaaOikein() {
        assertEquals(0, keko.getKoko());
        keko.lisaa(1);
        assertEquals(1, keko.getKoko());
        keko.lisaa(2);
        assertEquals(2, keko.getKoko());
        keko.otaPienin();
        assertEquals(1, keko.getKoko());
    }
}
