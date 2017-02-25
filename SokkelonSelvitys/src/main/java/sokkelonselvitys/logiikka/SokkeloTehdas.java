package sokkelonselvitys.logiikka;

/**
 * Luokka sisältää kolme eriasteista sokkeloa, jotka muodostuvat erilaisista
 * Ruutu-olioista.
 *
 * @author inka
 */
public class SokkeloTehdas {

    private Ruutu[][] helppo;
    private Ruutu[][] keskitaso;
    private Ruutu[][] vaikea;

    public SokkeloTehdas() {
        this.helppo = new Ruutu[][]{
            {Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE},};

        this.keskitaso = new Ruutu[][]{
            {Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE},};

        this.vaikea = new Ruutu[][]{
            {Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.ESTE, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA},
            {Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE, Ruutu.MAA, Ruutu.MAA, Ruutu.MAA, Ruutu.ESTE},
            {Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE, Ruutu.ESTE},};
    }

    public Ruutu[][] getHelppo() {
        return helppo;
    }

    public Ruutu[][] getKeskitaso() {
        return keskitaso;
    }

    public Ruutu[][] getVaikea() {
        return vaikea;
    }
}
