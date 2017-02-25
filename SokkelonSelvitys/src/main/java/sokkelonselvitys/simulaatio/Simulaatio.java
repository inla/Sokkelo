package sokkelonselvitys.simulaatio;

import sokkelonselvitys.gui.AbstraktiPaneeli;
import sokkelonselvitys.logiikka.algoritmit.AlgoritmiTyyppi;
import sokkelonselvitys.logiikka.algoritmit.Algoritmi;
import sokkelonselvitys.logiikka.algoritmit.BFS;
import sokkelonselvitys.logiikka.algoritmit.AStar;
import sokkelonselvitys.logiikka.*;

/**
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
    private int nopeus;
    private int leveys;
    private int korkeus;
    private boolean kaynnissa;
    private AbstraktiPaneeli paneeli;

    public Simulaatio() {
        this.sokkeloTehdas = new SokkeloTehdas();
        this.sokkelo = sokkeloTehdas.getHelppo();
        this.alku = new Koordinaatti(1, 2);
        this.maali = new Koordinaatti(14, 12);
        this.algoritmiTyyppi = AlgoritmiTyyppi.ASTAR;
        this.nopeus = 0; //?
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
    }

    public void haeReitti() {
        luoAlgoritmi();
        this.kaynnissa = true;
        this.algoritmi.suorita();

    }

    public void lopetaHaku() {
        this.kaynnissa = false;

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

    
    public int getNopeus() {
        return nopeus;
    }

    public void setNopeus(int nopeus) {
        this.nopeus = nopeus;
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

    public AbstraktiPaneeli getPaneeli() {
        return paneeli;
    }

    public void setPaneeli(AbstraktiPaneeli paneeli) {
        this.paneeli = paneeli;
    }

}
