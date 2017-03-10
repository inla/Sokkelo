package sokkelonselvitys.logiikka.algoritmit;

import sokkelonselvitys.logiikka.Koordinaatti;
import sokkelonselvitys.logiikka.Ruutu;
import sokkelonselvitys.logiikka.Solmu;
import sokkelonselvitys.logiikka.SolmunTila;
import sokkelonselvitys.logiikka.tietorakenteet.Jono;

/**
 * Leveyssuuntainen haku.
 *
 * @author inka
 */
public class BFS extends Algoritmi {

    private Jono<Solmu> tutkittavat;

    /**
     * Luo uuden leveyssuuntaishakualgoritmin.
     *
     * @param sokkelo tutkittava sokkelo
     * @param aloitus aloitussolmu
     * @param maali maalisolmu
     */
    public BFS(Ruutu[][] sokkelo, Koordinaatti aloitus, Koordinaatti maali) {
        super(sokkelo, aloitus, maali);
        this.tutkittavat = new Jono<>();
    }

    /**
     * Algoritmin toiminta.
     */
    @Override
    public void run() {
        tutkittavat.lisaa(new Solmu(aloitus, null, 0));

        while (!tutkittavat.tyhja() && this.jatketaan) {
            Solmu tutkittava = tutkittavat.ota();

            if (tutkittava.getKoordinaatit().equals(maali)) {
                maaliLoytyi(tutkittava);
                break;
            }

            this.solmujenTilaRuudukko[tutkittava.getY()][tutkittava.getX()] = SolmunTila.KASITTELYSSA;
            hidasta();

            for (Solmu s : kasiteltavanSolmunNaapurit(tutkittava)) {
                if (this.solmujenTilaRuudukko[s.getY()][s.getX()] == null) {
                    tutkittavat.lisaa(s);
                    this.solmujenTilaRuudukko[s.getY()][s.getX()] = SolmunTila.LOYDETTY;
                }
            }
            this.solmujenTilaRuudukko[tutkittava.getY()][tutkittava.getX()] = SolmunTila.KASITELTY;
        }
    }
}