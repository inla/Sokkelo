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
        Lista<Solmu> kaikki = solmu.getMahdollisetNaapurit();
        Lista<Solmu> naapurit = new Lista<>();

        for (Solmu s : kaikki) {
            int koordX = s.getX();
            int koordY = s.getY();
            if (!onkoRajojenSisalla(koordX, koordY) || onkoEste(koordX, koordY)) {
                continue;
            }
            naapurit.lisaa(s);
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

    private boolean onkoRajojenSisalla(int x, int y) {
        if (x < 0 || y < 0 || x >= sokkelo[0].length || y >= sokkelo.length) {
            return false;
        }
        return true;
    }

    private boolean onkoEste(int x, int y) {
        return sokkelo[y][x] == Ruutu.ESTE;
    }

}
