package sokkelonselvitys.simulaatio;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import sokkelonselvitys.gui.Kayttoliittyma;
import sokkelonselvitys.logiikka.Koordinaatti;
import sokkelonselvitys.logiikka.Ruutu;
import sokkelonselvitys.logiikka.SokkeloTehdas;
import sokkelonselvitys.logiikka.algoritmit.AStar;
import sokkelonselvitys.logiikka.algoritmit.Algoritmi;
import sokkelonselvitys.logiikka.algoritmit.BFS;

/**
 *
 * @author inka
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Simulaatio s = new Simulaatio();
        Kayttoliittyma k = new Kayttoliittyma(s);
        SwingUtilities.invokeLater(k);
        while (k.getSimulaatioPaneeli() == null || k.getValikkoPaneeli() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }

        s.setSimulaatioPaneeli(k.getSimulaatioPaneeli());
        s.setValikkoPaneeli(k.getValikkoPaneeli());

        Thread t = new Thread(k.getSimulaatioPaneeli());
        t.start();

        //suorituskykytestaus();
    }

    public static void suorituskykytestaus() {
        SokkeloTehdas st = new SokkeloTehdas();
        System.out.println("SUORITUSKYKYTESTAUS");
        System.out.println("");
        System.out.println("Helppo sokkelo\n");
        testaa(st.getHelppo());
        System.out.println("Keskitasoinen sokkelo\n");
        testaa(st.getKeskitaso());
        System.out.println("Vaikea sokkelo\n");
        testaa(st.getVaikea());
    }

    public static void testaa(Ruutu[][] sokkelo) {
        Koordinaatti alku = new Koordinaatti(1, 2);
        Koordinaatti maali = new Koordinaatti(14, 12);
        long tulos = 0;
        long summa = 0;
        int suorituskerrat = 100;

        System.out.println("A*");
        for (int i = 0; i < suorituskerrat; i++) {
            Algoritmi astar = new AStar(sokkelo, alku, maali);
            //System.out.print("Testi " + (i + 1) + ": ");
            tulos = suorita(astar);
            //System.out.println("Aikaa kului " + (tulos) + " ms");
            summa += tulos;
        }
        System.out.println("Keskiarvo: " + (1.0 * summa / suorituskerrat) + " ms");

        System.out.println("");
        summa = 0;

        System.out.println("BFS");
        for (int i = 0; i < suorituskerrat; i++) {
            Algoritmi bfs = new BFS(sokkelo, alku, maali);
            //System.out.print("Testi " + (i + 1) + ": ");
            tulos = suorita(bfs);
            //System.out.println("Aikaa kului " + (tulos) + " ms");
            summa += tulos;
        }
        System.out.println("Keskiarvo: " + (1.0 * summa / suorituskerrat) + " ms");
        System.out.println("");
    }

    public static long suorita(Algoritmi a) {
        long alkuaika = System.currentTimeMillis();
        new Thread(a).start();
        while (!a.onValmis()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        long loppuaika = System.currentTimeMillis();

        return loppuaika - alkuaika;
    }
}
