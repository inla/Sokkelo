package sokkelonselvitys.logiikka;

import java.awt.Color;

/**
 * Solmun tila muuttuu hakualgoritmin edetessä. Ennen kuin algoritmi on päässyt
 * solmun kohdalle, solmun tila on null.
 *
 * @author inka
 */
public enum SolmunTila {

    KASITTELYSSA(Color.RED),
    LOYDETTY(Color.YELLOW),
    KASITELTY(Color.ORANGE),
    REITTI(Color.MAGENTA);

    private Color vari;

    private SolmunTila(Color vari) {
        this.vari = vari;
    }

    public Color getVari() {
        return vari;
    }
}
