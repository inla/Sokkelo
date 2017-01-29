package sokkelonselvitys.logiikka;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author inka
 */
public class Solmu {
    private int x;
    private int y;
    private Solmu vanhempi;
    private SolmunTila tila;
    private List<Solmu> mahdollisetNaapurit;
    
    /**
     *
     * @param x
     * @param y
     * @param vanhempi
     */
    public Solmu(int x, int y, Solmu vanhempi) {
        this.x = x;
        this.y = y;
        this.vanhempi = vanhempi;
        this.tila = null;
        this.mahdollisetNaapurit = naapurit();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Solmu getVanhempi() {
        return vanhempi;
    }

    public SolmunTila getTila() {
        return tila;
    }

    public List<Solmu> getMahdollisetNaapurit() {
        return mahdollisetNaapurit;
    }

    public void setTila(SolmunTila tila) {
        this.tila = tila;
    }

    private List<Solmu> naapurit() {
        List<Solmu> naapurit = new ArrayList<>();
        naapurit.add(new Solmu(this.x - 1, this.y, this));
        naapurit.add(new Solmu(this.x + 1, this.y, this));
        naapurit.add(new Solmu(this.x, this.y - 1, this));
        naapurit.add(new Solmu(this.x, this.y + 1, this));
        return naapurit;
    }
    
    
}
