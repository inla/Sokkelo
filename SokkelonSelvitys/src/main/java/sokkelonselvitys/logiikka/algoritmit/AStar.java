package sokkelonselvitys.logiikka.algoritmit;

import java.util.Comparator;
import sokkelonselvitys.logiikka.Koordinaatti;
import sokkelonselvitys.logiikka.Ruutu;
import sokkelonselvitys.logiikka.Solmu;
import sokkelonselvitys.logiikka.SolmunTila;
import sokkelonselvitys.logiikka.tietorakenteet.Minimikeko;

/**
 * Algoritmi, joka tekee A*-haun.
 *
 * @author inka
 */
public class AStar extends Algoritmi {

    private Minimikeko<Solmu> tutkittavat;
    private int[][] lyhimmatReitit;

    /**
     * Luo uuden A*-algoritmin.
     *
     * @param sokkelo tutkittava sokkelo
     * @param aloitus aloitussolmu
     * @param maali maalisolmu
     */
    public AStar(Ruutu[][] sokkelo, Koordinaatti aloitus, Koordinaatti maali) {
        super(sokkelo, aloitus, maali);
        this.lyhimmatReitit = new int[this.sokkelo.length][this.sokkelo.length];
        alustaReitit();

        Comparator<Solmu> vertailija = new Comparator<Solmu>() {

            @Override
            public int compare(Solmu s1, Solmu s2) {
                if (s1.getKuljetunReitinPituus() + etaisyysArvioMaaliin(s1) < s2.getKuljetunReitinPituus() + etaisyysArvioMaaliin(s2)) {
                    return -1;
                } else if (s1.getKuljetunReitinPituus() + etaisyysArvioMaaliin(s1) > s2.getKuljetunReitinPituus() + etaisyysArvioMaaliin(s2)) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        this.tutkittavat = new Minimikeko<>(vertailija);
    }

    @Override
    public void suorita() {
        this.tutkittavat.lisaa(new Solmu(aloitus, null, 0));

        while (!tutkittavat.tyhja()) {
            Solmu tutkittava = this.tutkittavat.otaPienin();

            if (tutkittava.getKoordinaatit().equals(this.maali)) {
                maaliLoydetty(tutkittava);
                break;
            }

            //tutkittava.setTila(SolmunTila.KASITTELYSSA);
            this.solmujenTilaRuudukko[tutkittava.getY()][tutkittava.getX()] = SolmunTila.KASITTELYSSA;

            for (Solmu s : kasiteltavanSolmunNaapurit(tutkittava)) {
                //jos solmu on jo löydetty ja siihen tullaan nyt pidempää reittiä -> ei tehdä mitään
                if (s.getTila() != null && lyhimmatReitit[s.getY()][s.getX()] <= s.getKuljetunReitinPituus()) {
                    continue;
                }
                lyhimmatReitit[s.getY()][s.getX()] = s.getKuljetunReitinPituus();
                //s.setTila(SolmunTila.LOYDETTY);
                this.solmujenTilaRuudukko[tutkittava.getY()][tutkittava.getX()] = SolmunTila.LOYDETTY;
                this.tutkittavat.lisaa(s);
            }

            //tutkittava.setTila(SolmunTila.KASITELTY);
            this.solmujenTilaRuudukko[tutkittava.getY()][tutkittava.getX()] = SolmunTila.KASITELTY;
        }

    }

    private void alustaReitit() {
        for (int i = 0; i < this.sokkelo.length; i++) {
            for (int j = 0; j < this.sokkelo.length; j++) {
                this.lyhimmatReitit[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private int etaisyysArvioMaaliin(Solmu s) {
        return Math.abs(s.getX() - this.maali.getX()) + Math.abs(s.getY() - this.maali.getY());
    }

}
