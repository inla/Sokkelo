package sokkelonselvitys.gui;

import java.awt.Color;
import java.awt.Graphics;
import sokkelonselvitys.simulaatio.Simulaatio;
import sokkelonselvitys.logiikka.Ruutu;
import sokkelonselvitys.logiikka.SolmunTila;

/**
 * Piirtää sokkelon ja simulaation.
 *
 * @author inka
 */
public class SimulaatioPaneeli extends AbstraktiPaneeli implements Runnable {

    private Simulaatio simulaatio;
    private int ruudunKoko;

    /**
     * Konstruktori.
     *
     * @param simulaatio piirrettävä simulaatio
     * @param ruudunKoko yksittäisen ruudun koko
     */
    public SimulaatioPaneeli(Simulaatio simulaatio, int ruudunKoko) {
        this.simulaatio = simulaatio;
        this.ruudunKoko = ruudunKoko;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        piirraSokkelo(g);
        if (this.simulaatio.getAlgoritmi() != null) {
            piirraHaku(g);
        }
        piirraAloitusJaMaali(g);
    }

    private void piirraSokkelo(Graphics g) {
        for (int y = 0; y < simulaatio.getKorkeus(); y++) {
            for (int x = 0; x < simulaatio.getLeveys(); x++) {
                Ruutu r = this.simulaatio.getSokkelonRuutu(x, y);
                g.setColor(r.getVari());
                g.fill3DRect(x * ruudunKoko, y * ruudunKoko, ruudunKoko, ruudunKoko, true);
            }
        }
    }

    private void piirraHaku(Graphics g) {
        for (int y = 0; y < simulaatio.getKorkeus(); y++) {
            for (int x = 0; x < simulaatio.getLeveys(); x++) {
                SolmunTila s = this.simulaatio.getSolmunTila(x, y);
                if (s != null) {
                    g.setColor(s.getVari());
                    g.fill3DRect(x * ruudunKoko + ruudunKoko / 6, y * ruudunKoko + ruudunKoko / 6, 2 * ruudunKoko / 3, 2 * ruudunKoko / 3, true);
                    // ruudunKoko =30, pikkuruutu =20, reunat =5;
                }
            }
        }
    }

    private void piirraAloitusJaMaali(Graphics g) {
        int alkuX = this.simulaatio.getAlku().getX();
        int alkuY = this.simulaatio.getAlku().getY();
        int maaliX = this.simulaatio.getMaali().getX();
        int maaliY = this.simulaatio.getMaali().getY();

        g.setColor(Color.GREEN);
        g.fill3DRect(alkuX * ruudunKoko + ruudunKoko / 6, alkuY * ruudunKoko + ruudunKoko / 6, 2 * ruudunKoko / 3, 2 * ruudunKoko / 3, true);
        g.setColor(Color.PINK);
        g.fill3DRect(maaliX * ruudunKoko + ruudunKoko / 6, maaliY * ruudunKoko + ruudunKoko / 6, 2 * ruudunKoko / 3, 2 * ruudunKoko / 3, true);
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            repaint();
        }
    }

}
