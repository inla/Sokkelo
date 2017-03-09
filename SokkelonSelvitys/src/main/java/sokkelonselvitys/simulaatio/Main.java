package sokkelonselvitys.simulaatio;

import javax.swing.SwingUtilities;
import sokkelonselvitys.gui.Kayttoliittyma;

/**
 *
 * @author inka
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Simulaatio s = new Simulaatio();
        Kayttoliittyma k = new Kayttoliittyma(s);
        SwingUtilities.invokeLater(k);
        while (k.getSimulaatioPaneeli() == null || k.getValikkoPaneeli() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }

        s.setSimulaatioPaneeli(k.getSimulaatioPaneeli());
        s.setValikkoPaneeli(k.getValikkoPaneeli());

        Thread t = new Thread(k.getSimulaatioPaneeli());
        t.start();
    }

}
