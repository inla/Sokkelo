package sokkelonselvitys.logiikka;

/**
 *
 * @author inka
 */
public class Koordinaatit {

    private int x;
    private int y;

    public Koordinaatit(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Koordinaatit naapuriKoordinaatit(Suunta s) {
        if (s == Suunta.ALAS) {
            return new Koordinaatit(this.x, this.y + 1);
        } else if (s == Suunta.YLOS) {
            return new Koordinaatit(this.x, this.y - 1);
        } else if (s == Suunta.OIKEA) {
            return new Koordinaatit(this.x + 1, this.y);
        } else if (s == Suunta.VASEN) {
            return new Koordinaatit(this.x - 1, this.y);
        }
        return null;
    }

    public enum Suunta {

        ALAS, YLOS, OIKEA, VASEN
    }
}
