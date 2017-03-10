package sokkelonselvitys.logiikka;

/**
 * Solmulla on koordinaatit ja tila, sekä tieto edellisestä solmusta ja reitin
 * pituudesta aloitussolmusta itseensä.
 *
 * @author inka
 */
public class Solmu {

    private Koordinaatti koordinaatit;
    private Solmu edellinen;
    private SolmunTila tila;
    private int kuljetunReitinPituus;

    /**
     * Konstruktori. Solmun tila on null kunnes algoritmi löytää sen.
     *
     * @param koord solmun koordinaatit
     * @param edellinen solmu, josta päädyttiin tähän solmuun
     * @param kuljetunReitinPituus reitti aloitussolmusta tähän solmuun
     */
    public Solmu(Koordinaatti koord, Solmu edellinen, int kuljetunReitinPituus) {
        this.koordinaatit = koord;
        this.edellinen = edellinen;
        this.tila = null;
        this.kuljetunReitinPituus = kuljetunReitinPituus;
    }

    public Koordinaatti getKoordinaatit() {
        return koordinaatit;
    }

    public int getX() {
        return this.koordinaatit.getX();
    }

    public int getY() {
        return this.koordinaatit.getY();
    }

    public Solmu getEdellinen() {
        return edellinen;
    }

    public SolmunTila getTila() {
        return tila;
    }

    public int getKuljetunReitinPituus() {
        return kuljetunReitinPituus;
    }

    public void setTila(SolmunTila tila) {
        this.tila = tila;
    }
}
