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

    public MinimikekoTest() {
    }

    @Before
    public void setUp() {
        Comparator<Integer> c = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        this.keko = new Minimikeko<>(c);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testhello() {
    }
}
