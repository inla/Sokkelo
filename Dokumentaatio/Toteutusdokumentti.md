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
Lisäys-operaation aikavaativuus on vakioaikainen, jos jonoa ei tarvitse kasvattaa. KasvataJonoa()-operaatiossa on yksi silmukka, joka suoritetaan n kertaa, kun n = jonon alkioiden lukumäärä, joten operaation aikavaativuus on O(n) ja siten myös lisaa()-operaation aikavaativuus on O(n).
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


##Puutteet ja parannusehdotukset
Ohjelmasta jäi puuttumaan hidasteiden käyttö sokkeloissa, vaikkakin valmiudet siihen olisi eli ne olisi helppo toteuttaa jatkossa.  Muita kehitysideoita, joiden toteutustapoja en kuitenkaan ole suuremmin miettinyt, olisivat esimerkiksi, että käyttäjä voisi muokata sokkeloa itse, kuten lisätä/poistaa esteitä ja hidasteita, tai liikuttaa aloitus- ja maalisolmuja. Aloritmeja voisi myös olla useampi erilainen, ja niiden suoritusta olisi kiinnostavaa pystyä vertailemaan rinnakkain toimivista simulaatioista.

##Lähteet

