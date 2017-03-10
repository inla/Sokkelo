package sokkelonselvitys.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sokkelonselvitys.simulaatio.Simulaatio;
import sokkelonselvitys.logiikka.algoritmit.AlgoritmiTyyppi;

/**
 * TapahtumanKuuntelija kuntelee valikkopaneelissa tehtyjä valintoja ja tekee
 * niitä vastaavia muutoksia simulaatioon.
 *
 * @author inka
 */
public class TapahtumanKuuntelija implements ActionListener {

    private Simulaatio simulaatio;
    private ValikkoPaneeli valikko;

    /**
     * Konstruktori.
     *
     * @param simulaatio simulaatio, jonka muuttujia tarvittaessa muutetaan
     * @param valikko kuunneltava valikkopaneeli
     */
    public TapahtumanKuuntelija(Simulaatio simulaatio, ValikkoPaneeli valikko) {
        this.simulaatio = simulaatio;
        this.valikko = valikko;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(valikko.getAStar())) {
            this.simulaatio.setAlgoritmiTyyppi(AlgoritmiTyyppi.ASTAR);
        } else if (o.equals(valikko.getBfs())) {
            this.simulaatio.setAlgoritmiTyyppi(AlgoritmiTyyppi.BFS);
        } else if (o.equals(valikko.getHelppo())) {
            this.simulaatio.setSokkelo(this.simulaatio.getSokkeloTehdas().getHelppo());
        } else if (o.equals(valikko.getKeskitaso())) {
            this.simulaatio.setSokkelo(this.simulaatio.getSokkeloTehdas().getKeskitaso());
        } else if (o.equals(valikko.getVaikea())) {
            this.simulaatio.setSokkelo(this.simulaatio.getSokkeloTehdas().getVaikea());
        } else if (o.equals(valikko.getSimulaatioNappula())) {
            if (this.simulaatio.onKaynnissa()) {
                this.simulaatio.lopetaHaku();
            } else {
                this.simulaatio.haeReitti();
            }
        } else if (o.equals(valikko.getTyhjennaNappula())) {
            this.simulaatio.tyhjenna();
        }
        this.simulaatio.getSimulaatioPaneeli().paivita();
        this.valikko.paivita();
    }
}