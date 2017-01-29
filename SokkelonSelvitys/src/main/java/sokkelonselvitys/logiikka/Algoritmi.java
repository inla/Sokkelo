package sokkelonselvitys.logiikka;

import java.util.ArrayList;
import java.util.List;

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
     * Konstruktori.
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
     * Etsii käsiteltävän solmun naapurit.
     *
     * @param solmu käsiteltävä solmu
     * @return lista naapureista
     */
    public List<Solmu> kasiteltavanSolmunNaapurit(Solmu solmu) {
        List<Solmu> kaikki = solmu.getMahdollisetNaapurit();
        List<Solmu> naapurit = new ArrayList<>();

        for (Solmu s : kaikki) {
            int koordX = s.getX();
            int koordY = s.getY();
            if (!onkoRajojenSisalla(koordX, koordY) || onkoEste(koordX, koordY)) {
                continue;
            }
            naapurit.add(s);
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
