#Toteutusdokumentti

###Ohjelman yleisrakenne
Ohjelmassa on pakkaukset simulaatio, gui ja logiikka, sekä logiikkapakkauksesta löytyvät algoritmit ja tietorakenteet -pakkaukset.

Simulaatio-paketissa on luokat Main ja Simulaatio. Simulaatio-luokka luo simulaation sekä yhdistää ohjelman logiikan ja käyttöliittymän. Gui-pakkauksessa on käyttöliittymän tarvitsemia luokkia: Kayttoliittyma, SimulaatioPaneeli, ValikkoPaneeli, TapahtumanKuuntelija ja rajapinta Paivitettava. TapahtumanKuuntelija kuuntelee ValikkoPaneeliin tehtyjä valintoja, ja SimulaatioPaneeli piirtää valitun simulaation. Valikko- ja SimulaatioPaneelit toteuttavat Paivitettava-rajapinnan.

Algoritmi-pakkauksessa on luokat AStar ja BFS, jotka toteuttavat A\* ja BFS -algoritmit, abstrakti luokka Algoritmi, jonka AStar ja BFS perivät, sekä enum luokka AlgoritmiTyyppi, joka luettelee toteutetut algoritmit. Tietorakenteet-pakkauksessa on luokat Jono, Lista ja Minimikeko, jotka toteuttavat kyseiset tietorakenteet. Logiikkapakkauksessa on lisäksi luokat Koordinaatti, Solmu, SokkeloTehdas, sekä enum luokat Ruutu ja SolmunTila. Sokkelo koostuu erilaisista Ruutu-olioista; Ruutu-luokassa eri Ruutu-tyypit ovat lueteltuina, ja SokkeloTehdas-luokassa on kolme erilaista sokkeloa valmiina. Hakualgoritmit pääsevät etenemään Solmu-luokasta tehtävien instanssien avulla, Solmu-olioilla on koordinaatit ja tila, joka muuttuu hakualgoritmin edetessä.

###Aika- ja tilavaativuudet


###Puutteet ja parannusehdotukset


###Lähteet

