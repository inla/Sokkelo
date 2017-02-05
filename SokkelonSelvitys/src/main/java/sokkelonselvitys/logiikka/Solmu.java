package sokkelonselvitys.logiikka;

/**
 *
 * @author inka
 */
public class Solmu {
    private int x;
    private int y;
    private Solmu vanhempi;
    private SolmunTila tila;
    private Lista<Solmu> mahdollisetNaapurit;
    
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

    public Lista<Solmu> getMahdollisetNaapurit() {
        return mahdollisetNaapurit;
    }

    public void setTila(SolmunTila tila) {
        this.tila = tila;
    }

    private Lista<Solmu> naapurit() {
        Lista<Solmu> naapurit = new Lista<>();
        naapurit.lisaa(new Solmu(this.x - 1, this.y, this));
        naapurit.lisaa(new Solmu(this.x + 1, this.y, this));
        naapurit.lisaa(new Solmu(this.x, this.y - 1, this));
        naapurit.lisaa(new Solmu(this.x, this.y + 1, this));
        return naapurit;
    }
    
    
}
