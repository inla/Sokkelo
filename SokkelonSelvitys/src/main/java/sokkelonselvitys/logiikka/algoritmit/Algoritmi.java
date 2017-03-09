package sokkelonselvitys.logiikka.algoritmit;

import sokkelonselvitys.gui.Paivitettava;
import sokkelonselvitys.logiikka.Koordinaatti;
import sokkelonselvitys.logiikka.Ruutu;
import sokkelonselvitys.logiikka.Solmu;
import sokkelonselvitys.logiikka.SolmunTila;
import sokkelonselvitys.logiikka.tietorakenteet.Lista;

/**
 * Abstrakti luokka, jonka kaikki eri algoritmit perivät. Pitää sisällään
 * metodeja, joita alaluokat tarvitsevat.
 *
 * @author inka
 */
public abstract class Algoritmi implements Runnable {

    protected Ruutu[][] sokkelo;
    protected Koordinaatti aloitus;
    protected Koordinaatti maali;
    protected int leveys;
    protected int korkeus;
    protected SolmunTila[][] solmujenTilaRuudukko;
    protected Solmu reittiMaalille;
    protected boolean valmis;
    protected boolean jatketaan;
    protected Paivitettava paivitettava;

    /**
     * Luo uuden algoritmin.
     *
     * @param sokkelo Ruutu-olioista koostuva kaksiulotteinen taulukko
     * @param aloitus aloitussolmu
     * @param maali maalisolmu
     */
    public Algoritmi(Ruutu[][] sokkelo, Koordinaatti aloitus, Koordinaatti maali) {
        this.sokkelo = sokkelo;
        this.aloitus = aloitus;
        this.maali = maali;
        this.leveys = this.sokkelo[0].length;
        this.korkeus = this.sokkelo.length;
        this.solmujenTilaRuudukko = new SolmunTila[korkeus][leveys];
        this.valmis = false;
        this.jatketaan = true;
    }

    /**
     * Alaluokat toteuttavat tämän omilla tavoillaan.
     */
    @Override
    public abstract void run();

    protected void hidasta() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Etsii käsiteltävän solmun naapurit.
     *
     * @param solmu käsiteltävä solmu
     * @return lista naapureista
     */
    public Lista<Solmu> kasiteltavanSolmunNaapurit(Solmu solmu) {
        Lista<Solmu> naapurit = new Lista<>();

        for (Koordinaatti.Suunta suunta : Koordinaatti.Suunta.values()) {
            Koordinaatti k = solmu.getKoordinaatit().naapuriKoordinaatit(suunta);
            if (!onkoRajojenSisalla(k) || onkoEste(k)) {
                continue;
            }
            naapurit.lisaa(new Solmu(k, solmu, solmu.getKuljetunReitinPituus() + sokkelo[k.getY()][k.getX()].getHidastus()));
            //kuljetunReitinPituus + solmuunsaapumiskustannus (hidaste/normi)  ---^
        }

        return naapurit;
    }

    /**
     * Lopettaa alggoritmin suorituksen.
     */
    public void lopeta() {
        this.jatketaan = false;
    }

    /**
     * Kertoo, onko algoritmi löytänyt reitin maaliin.
     *
     * @return true, jos reitti on löytynyt
     */
    public boolean onValmis() {
        return valmis;
    }

    public Koordinaatti getAloitus() {
        return aloitus;
    }

    public Koordinaatti getMaali() {
        return maali;
    }

    public Ruutu[][] getSokkelo() {
        return sokkelo;
    }

    public SolmunTila[][] getSolmujenTilaRuudukko() {
        return solmujenTilaRuudukko;
    }

    public SolmunTila getSolmunTila(int x, int y) {
        return this.solmujenTilaRuudukko[y][x];
    }

    public Solmu getReittiMaalille() {
        return reittiMaalille;
    }

    private boolean onkoRajojenSisalla(Koordinaatti k) {
        if (k.getX() < 0 || k.getY() < 0 || k.getX() >= sokkelo[0].length || k.getY() >= sokkelo.length) {
            return false;
        }
        return true;
    }

    private boolean onkoEste(Koordinaatti k) {
        return sokkelo[k.getY()][k.getX()] == Ruutu.ESTE;
    }

    protected void maaliLoydetty(Solmu solmu) {
        this.valmis = true;
        this.reittiMaalille = solmu;
        while (solmu != null) {
            this.solmujenTilaRuudukko[solmu.getY()][solmu.getX()] = SolmunTila.REITTI;
            solmu = solmu.getEdellinen();
        }
//        if (paivitettava != null) {
//            this.paivitettava.paivita();
//        }
    }

    /**
     * Kertoo löydetyn reitin pituuden alkusolmusta maalisolmuun.
     *
     * @return reitin pituus
     */
    public int reitinPituus() {
        return this.reittiMaalille.getKuljetunReitinPituus();
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

}
