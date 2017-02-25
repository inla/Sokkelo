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
    public void suorita() {
        tutkittavat.lisaa(new Solmu(aloitus, null, 0));

        while (!tutkittavat.tyhja()) {
            Solmu tutkittava = tutkittavat.ota();

            if (tutkittava.getKoordinaatit().equals(maali)) {
                maaliLoydetty(tutkittava);
                break;
            }

            tutkittava.setTila(SolmunTila.KASITTELYSSA);
            this.solmujenTilaRuudukko[tutkittava.getY()][tutkittava.getX()] = SolmunTila.KASITTELYSSA;

            for (Solmu s : kasiteltavanSolmunNaapurit(tutkittava)) {
                if (s.getTila() == null) {
                    tutkittavat.lisaa(s);
                    s.setTila(SolmunTila.LOYDETTY);
                    this.solmujenTilaRuudukko[tutkittava.getY()][tutkittava.getX()] = SolmunTila.LOYDETTY;
                }
            }

            tutkittava.setTila(SolmunTila.KASITELTY);
            this.solmujenTilaRuudukko[tutkittava.getY()][tutkittava.getX()] = SolmunTila.KASITELTY;
        }
    }
}
