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

OtaPienin()-operaatio tarkistaa ensin ettei keko ole tyhjä, ja ottaa sitten juurialkion muistiin. Sitten keon viimeinen alkio sirretään juureen ja kutsutaan heapify-metodia juurelle kekoehdon korjaamiseksi. Lopulta muistiin laitettu pienin alkio palautetaan.
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

Lisaa(lisattava)-operaatio tarkistaa ensin onko keko täynnä ja tarvittaessa kasvattaa kekoa. Sitten alkio lisätään keon viimeiseksi ja sitä siirretään ylöspäin puussa kunnes se on oikealla paikalla kekoehdon mukaisesti. KasvataKekoa()-operaatiossa on silmukka, joka suoritetaan n kertaa, eli operaation aikavaativuus on O(n). Myös lisaa-operaatiossa on silmukka, joka suoritetaan pahimmassa tapauksessa puun korkeuden verran eli log n, muuten se on vakioaikainen. Lisaa-operaation aikavaativuudeksi siis saadaan O(log n + n) = O(log n).
```javascript
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
    }
    
    private void kasvataKekoa() {
        Object[] uusi = new Object[maxKoko * 2];

        for (int i = 0; i < this.keko.length; i++) {
            uusi[i] = this.keko[i];
        }
        this.keko = uusi;
        this.maxKoko *= 2;
    }
```
##Algoritmit
###A\*
A\*-algoritmissa edetään aina sellaiseen solmuun, jonka alku- ja maalisolmujen etäisyysarvioiden summa on pienin. Tässä käytetään hyväksi tietorakennetta Minimikeko. Keosta otetaan aina seuraava solmu ja niin kauan, kun ei olla vielä maalissa, saadun solmun naapurit lisätään kekoon, jos niihin ei ole vielä tultu lyhyempää reittiä pitkin. Algoritmin alussa kekoon lisätään aloitussolmu.

```javascript
    public void run() {
        this.tutkittavat.lisaa(new Solmu(aloitus, null, 0));

        while (!tutkittavat.tyhja() && this.jatketaan) {
            Solmu tutkittava = this.tutkittavat.otaPienin();

            if (tutkittava.getKoordinaatit().equals(this.maali)) {
                maaliLoytyi(tutkittava);
                break;
            }

            this.solmujenTilaRuudukko[tutkittava.getY()][tutkittava.getX()] = SolmunTila.KASITTELYSSA;
            hidasta();

            for (Solmu s : kasiteltavanSolmunNaapurit(tutkittava)) {
                //jos solmu on jo löydetty ja siihen tullaan nyt pidempää reittiä -> ei tehdä mitään
                if (this.solmujenTilaRuudukko[s.getY()][s.getX()] != null
                        && lyhimmatReitit[s.getY()][s.getX()] <= s.getKuljetunReitinPituus()) {
                    continue;
                }
                lyhimmatReitit[s.getY()][s.getX()] = s.getKuljetunReitinPituus();

                this.solmujenTilaRuudukko[s.getY()][s.getX()] = SolmunTila.LOYDETTY;
                this.tutkittavat.lisaa(s);
            }
            this.solmujenTilaRuudukko[tutkittava.getY()][tutkittava.getX()] = SolmunTila.KASITELTY;
        }

    }
```
For-silmukka suoritetaan enintään neljä kertaa, ja lisää-operaation aikavaativuus on pahimmillaan O(log n), kun keossa on n solmua, joten kokonaisuudessaan silmukka vie aikaa O(4\*log n). While-silmukka suoritetaan enintään solmujen lukumäärän verran.


###BFS
Leveyssuuntaisessa hakualgoritmissa edetään joka suuntaan, kunnes maali löytyy. Algoritmi käyttää tietorakennetta Jono, josta otetaan aina seuraava solmu ja jos ei olla vielä maalissa, lisätään jonoon saadun solmun sellaiset naapurit, joita ei oltu vielä löydetty (solmun tila on null). Aluksi jonoon lisätään aloitussolmu.

```javascript
    public void run() {
        tutkittavat.lisaa(new Solmu(aloitus, null, 0));

        while (!tutkittavat.tyhja() && this.jatketaan) {
            Solmu tutkittava = tutkittavat.ota();

            if (tutkittava.getKoordinaatit().equals(maali)) {
                maaliLoytyi(tutkittava);
                break;
            }

            this.solmujenTilaRuudukko[tutkittava.getY()][tutkittava.getX()] = SolmunTila.KASITTELYSSA;
            hidasta();

            for (Solmu s : kasiteltavanSolmunNaapurit(tutkittava)) {
                if (this.solmujenTilaRuudukko[s.getY()][s.getX()] == null) {
                    tutkittavat.lisaa(s);
                    this.solmujenTilaRuudukko[s.getY()][s.getX()] = SolmunTila.LOYDETTY;
                }
            }
            this.solmujenTilaRuudukko[tutkittava.getY()][tutkittava.getX()] = SolmunTila.KASITELTY;
        }
    }
```
Lisäys on pahimmassa tapauksessa, vaikkakin harvoin, aikavaativuudeltaan O(n), kun n on jonossa olevien alkioiden lukumäärä. For-silmukka suoritetaan aina enintään neljä kertaa, eli kokonaisuudessaan sen aikavaativuus on O(4n). While-silmukka onkin hankalampi miettiä, sen aikavaativuus on korkeintaan O(e), jossa e on solmujen lukumäärä, eli jos kaikki solmut ovat yhtäaikaa jonossa. Se ei kuitenkaan ole mahdollista, sillä solmusta on kaari enintään neljään muuhun solmuun ja solmu lisätään jonoon ja poistetaan jonosta korkeintaan kerran.


##Puutteet ja parannusehdotukset
Ohjelmasta jäi puuttumaan hidasteiden käyttö sokkeloissa, vaikkakin valmiudet siihen olisi eli ne olisi helppo toteuttaa jatkossa. Ohjelma ei myöskään ota huomioon tilannetta, jossa hakualgoritmi ei löydä reittiä maaliin. Muita kehitysideoita, joiden toteutustapoja en kuitenkaan ole suuremmin miettinyt, olisivat esimerkiksi, että käyttäjä voisi muokata sokkeloa itse, kuten lisätä/poistaa esteitä ja hidasteita, tai liikuttaa aloitus- ja maalisolmuja. Aloritmeja voisi myös olla useampi erilainen, ja niiden suoritusta olisi kiinnostavaa pystyä vertailemaan rinnakkain toimivista simulaatioista.

##Lähteet
* Tietorakenteet ja algoritmit kurssimateriaali
