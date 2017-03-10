#Toteutusdokumentti

##Ohjelman yleisrakenne
Ohjelmassa on pakkaukset simulaatio, gui ja logiikka, sekä logiikkapakkauksesta löytyvät algoritmit ja tietorakenteet -pakkaukset.

Simulaatio-paketissa on luokat Main ja Simulaatio. Simulaatio-luokka luo simulaation sekä yhdistää ohjelman logiikan ja käyttöliittymän. Gui-pakkauksessa on käyttöliittymän tarvitsemia luokkia: Kayttoliittyma, SimulaatioPaneeli, ValikkoPaneeli, TapahtumanKuuntelija ja rajapinta Paivitettava. TapahtumanKuuntelija kuuntelee ValikkoPaneeliin tehtyjä valintoja, ja SimulaatioPaneeli piirtää valitun simulaation. Valikko- ja SimulaatioPaneelit toteuttavat Paivitettava-rajapinnan.

Algoritmi-pakkauksessa on luokat AStar ja BFS, jotka toteuttavat A\* ja BFS -algoritmit, abstrakti luokka Algoritmi, jonka AStar ja BFS perivät, sekä enum luokka AlgoritmiTyyppi, joka luettelee toteutetut algoritmit. Tietorakenteet-pakkauksessa on luokat Jono, Lista ja Minimikeko, jotka toteuttavat kyseiset tietorakenteet. Logiikkapakkauksessa on lisäksi luokat Koordinaatti, Solmu, SokkeloTehdas, sekä enum luokat Ruutu ja SolmunTila. Sokkelo koostuu erilaisista Ruutu-olioista; Ruutu-luokassa eri Ruutu-tyypit ovat lueteltuina, ja SokkeloTehdas-luokassa on kolme erilaista sokkeloa valmiina. Hakualgoritmit pääsevät etenemään Solmu-luokasta tehtävien instanssien avulla, Solmu-olioilla on koordinaatit ja tila, joka muuttuu hakualgoritmin edetessä.

##Tietorakenteet
###Jono
Jono on toteutettu taulukkona, jonka ensimmäisen ja viimeisen alkion paikkaa pidetään muistissa (head ja tail). 
Jono on tyhjä, kun head ja tail ovat samat, ja täynnä, kun jonon tailia seuraava paikka on yhtä kuin jonon maksimikoko.
Operaatioiden aika- ja tilavaativuudet ovat vakioita.

```javascript
public boolean tyhja() {
    return head == tail;
}
```

```javascript
private boolean taysi() {
    int tailnext = this.tail + 1;
    if (tailnext == this.maxKoko) {
        tailnext = 0;
    }
    return tailnext == this.head;
}
```

Jono-operaatio lisaa(lisattava) tarkistaa ensin, onko jono täynnä. Tarvittaessa jonon kokoa kasvatetaan ja sitten lisattava lisätään jonoon hännän merkitsemään indeksiin.

```javascript
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
```
Lisäys-operaation aikavaativuus on vakioaikainen, jos jonoa ei tarvitse kasvattaa. KasvataJonoa()-operaatiossa on yksi silmukka, joka suoritetaan n kertaa, kun n = alkioiden lukumäärä, joten operaation aikavaativuus on O(n) ja siten myös lisaa()-operaation aikavaativuus on O(n).
```javascript
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
```
Operaatio ota() palauttaa jonon alkion kohdasta head ja siirtää headia yhden indeksin eteenpäin tai tultaessa jonon loppuun, kiepsautetaan head jonon ensimmäiseen indeksiin. Operaatio on vakioaikainen.
```javascript
    public E ota() {
        E palautettava = (E) this.jono[head];
        this.head++;
        if (this.head == this.maxKoko) {
            this.head = 0;
        }
        return palautettava;
    }
```

###Lista
Myös lista on toteuttettu taulukkona ja siihen voi lisätä ja siitä voi ottaa tai poistaa alkioita.
Operaatio lisaa(lisattava) lisää alkion listan loppuun tarkastettuaan ensin, onko lista täynnä ja tarvittaessa kasvatettuaan listaa. 

```javascript
    public void lisaa(E lisattava) {
        if (this.koko == this.maxKoko) {
            kasvataListaa();
        }
        this.lista[koko] = lisattava;
        this.koko++;
    }
```
Lisaa()-operaatio on muuten vakioaikainen, mutta kasvataListaa() -operaatossa on silmukka, joka suoritetaan n kertaa. Siten molempien operaatioiden aikavaativuudet ovat O(n).
```javascript
    private void kasvataListaa() {
        Object[] uusi = new Object[maxKoko * 2];

        for (int i = 0; i < this.lista.length; i++) {
            uusi[i] = this.lista[i];
        }
        this.lista = uusi;
        this.maxKoko *= 2;
    }
```
Ota(indeksi)-operaatio palauttaa tietyssä indeksissä olevan alkion ja on selvästi vakioaikainen.
```javascript
    public E ota(int indeksi) {
        return (E) this.lista[indeksi];
    }
```
Poista(indeksi) puolestaan poistaa tietyssä indeksissä olevan alkion, jonka jälkeen siirtää jäljelle jääneiden alkioiden indeksiä yhden vasemmalle. Siirtäminen tapahtuu silmukassa, joka siis suoritetaan n kertaa. Muuten operaatio on vakioaikainen, joten aikavaativuudeksi saadaan O(n).
```javascript
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
```
###MinimiKeko
Minimikeko on toteutettu puurakenteisena taulukkona, jossa alkiot ovat pienuusjärjestyksessä eli pienin alkio on aina puun juuressa. Kekoon voi lisätä alkioita ja siitä voi ottaa pienimmän alkion, ja sitä pidetään pienuusjärjestyksessä heapify-operaation avulla, joka puolestaan tarvitsee seuraavia apuoperaatioita:

```javascript
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
```
Pienempi(i, j) vertaa kahta oliota ja palauttaa niistä pienemmän, vaihda(i,j) vaihtaa kahden alkion paikkaa keskenään ja vanhempi(i), vasenLapsi(i) ja oikeaLapsi(i) kertovat indeksin i sukulaissuhteista. Näiden kaikkien operaatioiden aika- ja tilavaativuus on vakio.

```javascript
    private void heapify(int indeksi) {
        int oikea = oikeaLapsi(indeksi);
        int vasen = vasenLapsi(indeksi);

        if (oikea >= this.maxKoko || vasen >= this.maxKoko) {
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
```
Heapify-operaatio kuljettaa alkiota alaspäin puussa kunnes kekoehto on korjautunut, eli alkiot ovat taas oikeassa pienuusjärjestyksessä. Operaatio on muuten vakioaikainen, mutta se kutsuu itseään rekursiivisesti. Pahimmassa tapauksessa kutsuja tehdään puun korkeuden verran, eli aikavaativuus on O(log n). Tilavaativuus on myös O(log n) rekursion takia.

OtaPienin()-operaatio tarkistaa ensin ettei keko ole tyhjä, ja palauttaa sitten keon juurialkion. Sitten keon viimeinen alkio sirretään juureen ja kutsutaan heapify-metodia juurelle kekoehdon korjaamiseksi.
```javascript
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
```
```javascript
```

##Puutteet ja parannusehdotukset
Ohjelmasta jäi puuttumaan hidasteiden käyttö sokkeloissa, vaikkakin valmiudet siihen olisi eli ne olisi helppo toteuttaa jatkossa.  Muita kehitysideoita, joiden toteutustapoja en kuitenkaan ole suuremmin miettinyt, olisivat esimerkiksi, että käyttäjä voisi muokata sokkeloa itse, kuten lisätä/poistaa esteitä ja hidasteita, tai liikuttaa aloitus- ja maalisolmuja. Aloritmeja voisi myös olla useampi erilainen, ja niiden suoritusta olisi kiinnostavaa pystyä vertailemaan rinnakkain toimivista simulaatioista.

##Lähteet

