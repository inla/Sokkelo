package sokkelonselvitys.logiikka;

import java.awt.Color;

/**
 * Sokkelo koostuu yksittäisistä ruuduista, joilla on eri ominaisuuksia.
 *
 * @author inka
 */
public enum Ruutu {

    ESTE(Color.DARK_GRAY, 0),
    MAA(Color.LIGHT_GRAY, 1),
    VESI(Color.BLUE, 5);

    private Color vari;
    private int hidastus;

    private Ruutu(Color vari, int hidastus) {
        this.vari = vari;
        this.hidastus = hidastus;
    }

    public Color getVari() {
        return vari;
    }

    public int getHidastus() {
        return hidastus;
    }

}
