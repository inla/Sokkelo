package sokkelonselvitys.logiikka;

/**
 * Koordinaatti-olio muodostuu x- ja y-koordinaateista.
 *
 * @author inka
 */
public class Koordinaatti {

    private int x;
    private int y;

    public Koordinaatti(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Kertoo koordinaattipisteen ylä-, ala-, oikealla tai vasemmalla puolella
     * olevan pisteen koordinaatit.
     *
     * @param s suunta
     * @return halutun suunnan koordinaatit
     */
    public Koordinaatti naapuriKoordinaatit(Suunta s) {
        if (s == Suunta.ALAS) {
            return new Koordinaatti(this.x, this.y + 1);
        } else if (s == Suunta.YLOS) {
            return new Koordinaatti(this.x, this.y - 1);
        } else if (s == Suunta.OIKEA) {
            return new Koordinaatti(this.x + 1, this.y);
        } else if (s == Suunta.VASEN) {
            return new Koordinaatti(this.x - 1, this.y);
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }

        Koordinaatti toinen = (Koordinaatti) o;

        if (this.x != toinen.x) {
            return false;
        }
        if (this.y != toinen.y) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.x;
        hash = 89 * hash + this.y;
        return hash;
    }

    /**
     * Määrittelee mahdolliset suunnat, mihin koordinaattipisteestä voi liikkua.
     */
    public enum Suunta {

        ALAS, YLOS, OIKEA, VASEN
    }
}
