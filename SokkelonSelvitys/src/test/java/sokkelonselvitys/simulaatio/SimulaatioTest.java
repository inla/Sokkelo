package sokkelonselvitys.simulaatio;

import javax.swing.SwingUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import sokkelonselvitys.gui.Kayttoliittyma;

/**
 *
 * @author inka
 */
public class SimulaatioTest {

    private Simulaatio simulaatio;
    private Thread t;
    private Kayttoliittyma k;

    public SimulaatioTest() {
    }

//    @Before
//    public void setUp() throws InterruptedException {
//        this.simulaatio = new Simulaatio();
//        this.k = new Kayttoliittyma(simulaatio);
//        SwingUtilities.invokeLater(k);
//        while (k.getSimulaatioPaneeli() == null || k.getValikkoPaneeli() == null) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//        simulaatio.setSimulaatioPaneeli(k.getSimulaatioPaneeli());
//        simulaatio.setValikkoPaneeli(k.getValikkoPaneeli());
//        this.t = new Thread(k.getSimulaatioPaneeli());
//        this.t.start();
//    }
    @After
    public void tearDown() {
    }

//    @Test
//    public void testReittiLoytyy() {
//        suorita();
//        assertTrue(this.simulaatio.getAlgoritmi().getReittiMaalille() != null);
//    }
    private void suorita() {
        this.simulaatio.haeReitti();
        int laskuri = 0;
        while (!simulaatio.onValmis()) {
            if (laskuri > 100) {
                fail("Kestääpä kauan");
            }
            laskuri++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
