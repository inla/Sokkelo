package sokkelonselvitys.logiikka;

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
    public BFS(Ruutu[][] sokkelo, Solmu aloitus, Solmu maali) {
        super(sokkelo, aloitus, maali);
        this.tutkittavat = new Jono<>();
    }

    /**
     * Algoritmin toiminta.
     */
    @Override
    public void suorita() {
        tutkittavat.lisaa(aloitus);

        while (!tutkittavat.tyhja()) {
            Solmu tutkittava = tutkittavat.ota();

            if (tutkittava.getKoordinaatit().equals(maali.getKoordinaatit())) {
                maaliLoydetty(tutkittava);
                break;
            }

            tutkittava.setTila(SolmunTila.KASITTELYSSA);

            for (Solmu s : kasiteltavanSolmunNaapurit(tutkittava)) {
                if (s.getTila() == null) {
                    tutkittavat.lisaa(s);
                    s.setTila(SolmunTila.LOYDETTY);
                }
            }

            tutkittava.setTila(SolmunTila.KASITELTY);
        }
    }
}
