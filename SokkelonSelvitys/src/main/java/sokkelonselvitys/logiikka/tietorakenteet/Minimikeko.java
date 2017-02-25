package sokkelonselvitys.logiikka.tietorakenteet;

import java.util.Comparator;

/**
 * Minimikeko pitää alkiot pienuusjärjestyksessä.
 *
 * @author inka
 * @param <E> talletettavien alkioiden tyyppi
 */
public class Minimikeko<E> {

    private Object[] keko;
    private int maxKoko;
    private int koko;
    private Comparator<E> vertaaja;

    /**
     * Luo uudem minimikeon, jonka maksimikoko on 15.
     *
     * @param comparator väline alkioiden vertailuun
     */
    public Minimikeko(Comparator<E> comparator) {
        this.maxKoko = 15;
        this.keko = new Object[this.maxKoko];
        this.koko = 0;
        this.vertaaja = comparator;
    }

    /**
     * Kertoo, onko keko tyhjä.
     *
     * @return true jos koko on nolla
     */
    public boolean tyhja() {
        return this.koko == 0;
    }

    /**
     * Palauttaa ja poistaa pienimmän alkion keosta.
     *
     * @return keon ensimmäinen eli pienin alkio
     */
    public E otaPienin() {
        if (tyhja()) {
            return null;
        }
        E min = (E) this.keko[0];
        this.keko[0] = this.keko[this.koko - 1];
        this.koko--;
        heapify(0);
        return min;
    }

    /**
     * Lisää kekoon uuden alkion ja vie sen oikealle paikalleen.
     *
     * @param lisattava alkio, joka lisätään
     */
    public void lisaa(E lisattava) {
        this.koko++;
        if (taysi()) {
            kasvataKekoa();
        }

        int i = this.koko - 1;
        this.keko[i] = lisattava;
        while (i > 0 && pienempi(i, vanhempi(i)) == i) {
            vaihda(i, vanhempi(i));
            i = vanhempi(i);
        }

//        this.keko[i] = lisattava;
    }

    private void kasvataKekoa() {
        Object[] uusi = new Object[maxKoko * 2];

        for (int i = 0; i < this.keko.length; i++) {
            uusi[i] = this.keko[i];
        }

        this.keko = uusi;
        this.maxKoko *= 2;
    }

    private void heapify(int indeksi) {
        int oikea = oikeaLapsi(indeksi);
        int vasen = vasenLapsi(indeksi);

        if (oikea > this.maxKoko || vasen > this.maxKoko) {
            return;
        }
        
        if (this.keko[oikea] == null && this.keko[vasen] == null) {
            return;
        }

        if (oikea <= this.koko) {
            int pienin = pienempi(oikea, vasen);
            if (pienempi(indeksi, pienin) == pienin) {
                vaihda(indeksi, pienin);
                heapify(pienin);
            }
        } else if (vasen == this.koko && pienempi(indeksi, vasen) == vasen) {
            vaihda(indeksi, vasen);
        }
    }

    private int pienempi(int i, int j) {
        if (this.vertaaja.compare((E) this.keko[i], (E) this.keko[j]) < 0) {
            return i;
        } else {
            return j;
        }
    }

    private void vaihda(int i, int j) {
        Object temp = this.keko[i];
        this.keko[i] = this.keko[j];
        this.keko[j] = temp;
    }

    private int vanhempi(int indeksi) {
        return (indeksi - 1) / 2;
    }

    private int vasenLapsi(int indeksi) {
        return 2 * indeksi + 1;
    }

    private int oikeaLapsi(int indeksi) {
        return 2 * indeksi + 2;
    }

    private boolean taysi() {
        return this.koko == this.maxKoko;
    }

    public int getMaxKoko() {
        return maxKoko;
    }

    public int getKoko() {
        return koko;
    }

}
