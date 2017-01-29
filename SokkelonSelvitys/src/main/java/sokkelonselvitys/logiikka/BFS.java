package sokkelonselvitys.logiikka;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Leveyssuuntainen haku.
 *
 * @author inka
 */
public class BFS extends Algoritmi {

    private Queue<Solmu> tutkittavat;

    /**
     * Konstruktori.
     *
     * @param sokkelo tutkittava sokkelo
     * @param aloitus aloitussolmu
     * @param maali maalisolmu
     */
    public BFS(Ruutu[][] sokkelo, Solmu aloitus, Solmu maali) {
        super(sokkelo, aloitus, maali);
        this.tutkittavat = new ArrayDeque<>();
    }

    /**
     *
     */
    public void suorita() {
        tutkittavat.add(aloitus);

        while (!tutkittavat.isEmpty()) {
            Solmu tutkittava = tutkittavat.remove();

            if (tutkittava == maali) {
                //maali löydetty
                break;
            }

            tutkittava.setTila(SolmunTila.KASITTELYSSA);

            for (Solmu s : kasiteltavanSolmunNaapurit(tutkittava)) {
                if (s.getTila() == null) {
                    tutkittavat.add(s);
                    s.setTila(SolmunTila.LOYDETTY);
                }
            }

            tutkittava.setTila(SolmunTila.KASITELTY);
        }
    }
}
