package sokkelonselvitys.logiikka;

/**
 * Algoritmi, joka tekee A*-haun.
 *
 * @author inka
 */
public class AStar extends Algoritmi {

    /**
     * Luo uuden A*-algoritmin.
     *
     * @param sokkelo tutkittava sokkelo
     * @param aloitus aloitussolmu
     * @param maali maalisolmu
     */
    public AStar(Ruutu[][] sokkelo, Solmu aloitus, Solmu maali) {
        super(sokkelo, aloitus, maali);
    }

    @Override
    public void suorita() {

    }

}
