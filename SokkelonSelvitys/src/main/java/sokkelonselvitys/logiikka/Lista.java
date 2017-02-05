package sokkelonselvitys.logiikka;

import java.util.Iterator;

/**
 * Tietorakenne lista. Listaan voidaan lisätä ja siitä voi hakea ja poistaa
 * alkioita.
 *
 * @author inka
 * @param <E> talletettavien alkioiden tyyppi
 */
public class Lista<E> implements Iterable<E>{

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

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
