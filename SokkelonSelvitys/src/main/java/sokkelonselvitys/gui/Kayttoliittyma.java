package sokkelonselvitys.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import sokkelonselvitys.simulaatio.Simulaatio;

/**
 * Käyttöliittymäluokka.
 *
 * @author inka
 */
public class Kayttoliittyma implements Runnable {

    private final int ruudunKoko = 30;
    private JFrame frame;
    private Simulaatio simulaatio;
    private SimulaatioPaneeli simulaatioPaneeli;
    private ValikkoPaneeli valikkoPaneeli;

    /**
     * Konstruktori.
     *
     * @param simulaatio
     */
    public Kayttoliittyma(Simulaatio simulaatio) {
        this.simulaatio = simulaatio;
    }

    @Override
    public void run() {
        frame = new JFrame("SokkelonSelvitysSimulaatio");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());
        asetaKoko();

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void luoKomponentit(Container c) {
        this.simulaatioPaneeli = new SimulaatioPaneeli(simulaatio, ruudunKoko);
        this.valikkoPaneeli = new ValikkoPaneeli(simulaatio);
        c.add(this.simulaatioPaneeli, BorderLayout.CENTER);
        c.add(this.valikkoPaneeli, BorderLayout.EAST);
    }

    private void asetaKoko() {
        int leveys = this.simulaatio.getLeveys() * this.ruudunKoko;
        int pituus = this.simulaatio.getKorkeus() * this.ruudunKoko;
        this.simulaatioPaneeli.setPreferredSize(new Dimension(leveys, pituus));
        this.valikkoPaneeli.setPreferredSize(new Dimension(leveys / 2, pituus));
    }

    public SimulaatioPaneeli getSimulaatioPaneeli() {
        return simulaatioPaneeli;
    }

    public ValikkoPaneeli getValikkoPaneeli() {
        return valikkoPaneeli;
    }
}
