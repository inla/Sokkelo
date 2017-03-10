package sokkelonselvitys.logiikka.tietorakenteet;

/**
 * Tietorakenne jono.
 *
 * @author inka
 * @param <E> talletettavien alkioiden tyyppi
 */
public class Jono<E> {

    private Object[] jono;
    private int head;
    private int tail;
    private int maxKoko;

    /**
     * Luo uuden tyhjän jonon, jonka kapasiteetti on 15.
     */
    public Jono() {
        this.maxKoko = 15;
        this.jono = new Object[maxKoko];
        this.head = 0;
        this.tail = 0;
    }

    /**
     * Kertoo onko jono tyhjä.
     *
     * @return true jos tyhjä, false jos ei tyhjä
     */
    public boolean tyhja() {
        return head == tail;
    }

    /**
     * Palauttaa ja poistaa jonon ensimmäisen alkion.
     *
     * @return jonon ensimmäinen alkio
     */
    public E ota() {
        E palautettava = (E) this.jono[head];
        this.head++;
        if (this.head == this.maxKoko) {
            this.head = 0;
        }
        return palautettava;
    }

    /**
     * Lisää uuden alkion jonoon.
     *
     * @param lisattava
     */
    public void lisaa(E lisattava) {
        if (taysi()) {
            kasvataJonoa();
        }
        this.jono[tail] = lisattava;
        this.tail++;
        if (this.tail == this.maxKoko) {
            this.tail = 0;
        }
    }

    /**
     * Kertoo onko jono täynnä. Jonoon voi tallettaa enintään maxKoko-1 alkiota,
     * sillä muuten täyttä jonoa ei voisi erottaa tyhjästä jonosta.
     *
     * @return true jos tailista seuraava paikka on head
     */
    private boolean taysi() {
        int tailnext = this.tail + 1;
        if (tailnext == this.maxKoko) {
            tailnext = 0;
        }
        return tailnext == this.head;
    }

    private void kasvataJonoa() {
        Object[] uusi = new Object[this.maxKoko * 2];
        int uusiHead = 0;
        int uusiTail = 0;

        while (!tyhja()) {
            uusi[uusiTail] = this.jono[this.head];
            uusiTail++;
            this.head++;
            if (this.head == this.maxKoko) {
                this.head = 0;
            }
        }
        this.jono = uusi;
        this.head = uusiHead;
        this.tail = uusiTail;
        this.maxKoko *= 2;
    }

    /**
     * Kertoo kuinka monta alkiota jonossa on.
     *
     * @return alkioiden määrä
     */
    public int koko() {
        return (tail - head + maxKoko) % maxKoko;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public int getMaxKoko() {
        return maxKoko;
    }
}