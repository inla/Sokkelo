package sokkelonselvitys.logiikka;

import sokkelonselvitys.logiikka.tietorakenteet.Lista;

/**
 * Abstrakti luokka, jonka kaikki eri algoritmit perivät. Pitää sisällään
 * metodeja, joita alaluokat tarvitsevat.
 *
 * @author inka
 */
public abstract class Algoritmi {

    protected Ruutu[][] sokkelo;
    protected Solmu aloitus;
    protected Solmu maali;

    /**
     * Luo uuden algoritmin.
     *
     * @param sokkelo Ruutu-olioista koostuva kaksiulotteinen taulukko
     * @param aloitus aloitussolmu
     * @param maali maalisolmu
     */
    public Algoritmi(Ruutu[][] sokkelo, Solmu aloitus, Solmu maali) {
        this.sokkelo = sokkelo;
        this.aloitus = aloitus;
        this.maali = maali;
    }

    /**
     * Alaluokat toteuttavat tämän omilla tavoillaan.
     */
    public abstract void suorita();

    /**
     * Etsii käsiteltävän solmun naapurit.
     *
     * @param solmu käsiteltävä solmu
     * @return lista naapureista
     */
    public Lista<Solmu> kasiteltavanSolmunNaapurit(Solmu solmu) {
        Lista<Solmu> naapurit = new Lista<>();

        for (Koordinaatit.Suunta suunta : Koordinaatit.Suunta.values()) {
            Koordinaatit k = solmu.getKoordinaatit().naapuriKoordinaatit(suunta);
            if (!onkoRajojenSisalla(k) || onkoEste(k)) {
                continue;
            }
            naapurit.lisaa(new Solmu(k, solmu, solmu.getKuljetunReitinPituus() + 1));
            //kuljetunReitinPituus + solmuunsaapumiskustannus (hidaste/normi)?   ^
        }

        return naapurit;
    }

    public Solmu getAloitus() {
        return aloitus;
    }

    public Solmu getMaali() {
        return maali;
    }

    public Ruutu[][] getSokkelo() {
        return sokkelo;
    }

    private boolean onkoRajojenSisalla(Koordinaatit k) {
        if (k.getX() < 0 || k.getY() < 0 || k.getX() >= sokkelo[0].length || k.getY() >= sokkelo.length) {
            return false;
        }
        return true;
    }

    private boolean onkoEste(Koordinaatit k) {
        return sokkelo[k.getY()][k.getX()] == Ruutu.ESTE;
    }

    protected void maaliLoydetty() {

    }
}
