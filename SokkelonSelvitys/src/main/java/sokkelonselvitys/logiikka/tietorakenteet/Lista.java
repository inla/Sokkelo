package sokkelonselvitys.logiikka.tietorakenteet;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Tietorakenne lista. Listaan voidaan lisätä ja siitä voi hakea ja poistaa
 * alkioita.
 *
 * @author inka
 * @param <E> talletettavien alkioiden tyyppi
 */
public class Lista<E> implements Iterable<E> {

    private Object[] lista;
    private int koko;
    private int maxKoko;

    /**
     * Luo uuden tyhjän listan, jonka maksimikoko on 15.
     */
    public Lista() {
        this.maxKoko = 15;
        this.lista = new Object[maxKoko];
        this.koko = 0;
    }

    /**
     * Lisää uuden alkion listan loppuun. Jos lista on täynnä, kasvattaa ensin
     * sen kokoa.
     *
     * @param lisattava
     */
    public void lisaa(E lisattava) {
        if (this.koko == this.maxKoko) {
            kasvataListaa();
        }

        this.lista[koko] = lisattava;
        this.koko++;
    }

    private void kasvataListaa() {
        Object[] uusi = new Object[maxKoko * 2];

        for (int i = 0; i < this.lista.length; i++) {
            uusi[i] = this.lista[i];
        }

        this.lista = uusi;
        this.maxKoko *= 2;
    }

    /**
     * Palauttaa tietyssä kohtaa listaa olevan alkion.
     *
     * @param indeksi monesko alkio halutaan
     * @return alkio, joka on listan kohdassa indeksi
     */
    public E ota(int indeksi) {
        return (E) this.lista[indeksi];
    }

    /**
     * Poistaa tietyssä kohtaa listaa olevan alkion. Siirtää poistettavan alkion
     * jälkeisiä alkioita yhden vasemmalle.
     *
     * @param indeksi poistettavan alkion indeksi
     */
    public void poista(int indeksi) {
        int loput = this.koko - indeksi - 1;
        while (loput > 0) {
            this.lista[indeksi] = this.lista[indeksi + 1];
            indeksi++;
            loput--;
        }
        this.koko--;
        this.lista[koko] = null;
    }

    /**
     * Kertoo, onko lista tyhjä.
     *
     * @return true jos koko on nolla
     */
    public boolean tyhja() {
        return getKoko() == 0;
    }

    public int getKoko() {
        return koko;
    }

    public int getMaxKoko() {
        return maxKoko;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iteraattori();
    }

    private class Iteraattori implements Iterator<E> {

        int indeksi;
        int viimeeksiPalautettu = -1;

        @Override
        public boolean hasNext() {
            return indeksi < koko;
        }

        @Override
        public E next() {
            if (hasNext()) {
                int i = indeksi;
                indeksi++;
                return (E) lista[viimeeksiPalautettu = i];
            }
            throw new NoSuchElementException();
        }
    }

}
