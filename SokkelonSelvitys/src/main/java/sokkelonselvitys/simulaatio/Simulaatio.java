package sokkelonselvitys.simulaatio;

import sokkelonselvitys.gui.SimulaatioPaneeli;
import sokkelonselvitys.gui.ValikkoPaneeli;
import sokkelonselvitys.logiikka.algoritmit.AlgoritmiTyyppi;
import sokkelonselvitys.logiikka.algoritmit.Algoritmi;
import sokkelonselvitys.logiikka.algoritmit.BFS;
import sokkelonselvitys.logiikka.algoritmit.AStar;
import sokkelonselvitys.logiikka.*;

/**
 * Luo simulaation valitulle algoritmille ja sokkelolle.
 *
 * @author inka
 */
public class Simulaatio {

    private SokkeloTehdas sokkeloTehdas;
    private Ruutu[][] sokkelo;
    private Koordinaatti alku;
    private Koordinaatti maali;
    private AlgoritmiTyyppi algoritmiTyyppi;
    private Algoritmi algoritmi;
    private int leveys;
    private int korkeus;
    private boolean kaynnissa;
    private SimulaatioPaneeli simulaatioPaneeli;
    private ValikkoPaneeli valikkoPaneeli;

    /**
     * Oletuksena on A*-algoritmi ja helppo sokkelo.
     */
    public Simulaatio() {
        this.sokkeloTehdas = new SokkeloTehdas();
        this.sokkelo = sokkeloTehdas.getHelppo();
        this.alku = new Koordinaatti(1, 2);
        this.maali = new Koordinaatti(14, 12);
        this.algoritmiTyyppi = AlgoritmiTyyppi.ASTAR;
        this.leveys = this.sokkelo[0].length;
        this.korkeus = this.sokkelo.length;
        this.kaynnissa = false;
    }

    private void luoAlgoritmi() {
        if (algoritmiTyyppi == AlgoritmiTyyppi.ASTAR) {
            this.algoritmi = new AStar(sokkelo, alku, maali);
        } else if (algoritmiTyyppi == AlgoritmiTyyppi.BFS) {
            this.algoritmi = new BFS(sokkelo, alku, maali);
        }
        this.algoritmi.setPaivitettava(valikkoPaneeli);
    }

    /**
     * Kertoo, onko simulaatio käynnissä.
     *
     * @return
     */
    public boolean onKaynnissa() {
        return kaynnissa;
    }

    /**
     * Kertoo, onko simulaatio löytänyt reitin maaliin.
     *
     * @return true, jos reitti lötynyt
     */
    public boolean onValmis() {
        return this.algoritmi.onValmis();
    }

    /**
     * Käynnistää simulaation.
     */
    public void haeReitti() {
        luoAlgoritmi();
        this.kaynnissa = true;
        new Thread(algoritmi).start();
    }

    /**
     * Pysäyttää simulaation.
     */
    public void lopetaHaku() {
        this.kaynnissa = false;
        this.algoritmi.lopeta();
    }

    /**
     * Tyhjentää simulaation.
     */
    public void tyhjenna() {
        lopetaHaku();
        this.algoritmi = null;
    }

    public Ruutu getSokkelonRuutu(int x, int y) {
        return this.sokkelo[y][x];
    }

    public SolmunTila getSolmunTila(int x, int y) {
        return algoritmi.getSolmunTila(x, y);
    }

    public AlgoritmiTyyppi getAlgoritmiTyyppi() {
        return algoritmiTyyppi;
    }

    public void setAlgoritmiTyyppi(AlgoritmiTyyppi algoritmiTyyppi) {
        this.algoritmiTyyppi = algoritmiTyyppi;
    }

    public Algoritmi getAlgoritmi() {
        return algoritmi;
    }

    public int getLeveys() {
        return leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public Koordinaatti getAlku() {
        return alku;
    }

    public Koordinaatti getMaali() {
        return maali;
    }

    public Ruutu[][] getSokkelo() {
        return sokkelo;
    }

    public void setSokkelo(Ruutu[][] sokkelo) {
        this.sokkelo = sokkelo;
    }

    public SokkeloTehdas getSokkeloTehdas() {
        return sokkeloTehdas;
    }

    public SimulaatioPaneeli getSimulaatioPaneeli() {
        return simulaatioPaneeli;
    }

    public void setSimulaatioPaneeli(SimulaatioPaneeli paneeli) {
        this.simulaatioPaneeli = paneeli;
    }

    public void setValikkoPaneeli(ValikkoPaneeli valikkoPaneeli) {
        this.valikkoPaneeli = valikkoPaneeli;
    }
}
