## Sokkelon selvitys

Harjoitustyön aiheena on toteuttaa ohjelma, joka visualisoi tiettyjen polunetsintäalgoritmien toimintaa sokkelossa. Käytettävät algoritmit ovat A\*-algoritmi ja joko Dijkstran algoritmi tai leveyssuuntainen haku (BFS), tai ajan salliessa molemmat. Nämä algoritmit valikoituivat sen takia, että A\* ja BFS ovat yleisimpiä sokkeloiden ratkaisualgoritmeja ja Dijkstra löytää lyhimmät polut.

A\*-algoritmissa ylläpidetään kahta etäisyysarviotaulukkoa; nykyisen solmun etäisyysarvio alkusolmuun sekä loppusolmuun, ja yhtä polkutaulukkoa, joka kertoo edellisen solmun. Algoritmissa edetään aina sellaiseen solmuun, jonka etäisyysarvioiden summa on pienin. Tätä varten tarvitaan prioriteettijonoa, joka toteutetaan minimikekona. Aikavaativuus on O((|E|+|V|)log|V|) ja tilavaativuus O(V), missä V on solmujen lukumäärä ja E kaarien lukumäärä.

Dijkstra puolestaan ylläpitää kahta aputaulukkoa, joista toinen kertoo solmun etäisyysarvion alkusolmuun ja toinen sen solmun, josta nykyiseen solmuun tultiin. Algoritmi etenee aina sellaiseen solmuun, jonka etäisyysarvio on sillä hetkellä pienin eli myös tässä käytetään prioriteettijonoa. Myös tässä aikavaativuus on O((|E|+|V|)log|V|) ja tilavaativuus O(V).

Leveyssuuntaisessa haussa edetään uusiin solmuihin taso kerrallaan, eli ensin tutkitaan kaikki nykyisen solmun naapurit ja vasta sen jälkeen siirrytään naapurien naapureihin. Tässä käytetään tietorakenteena jonoa, joka toteutetaan yksiulotteisena taulukkona. Algoritmin aikavaativuus on O(|V|+|E|) ja tilavaativuus O(V).

Ohjelmassa käyttäjä voi valita simuloitavaksi haluamansa hakualgoritmin ja käytettävän sokkelon. Sokkeloita tulee olemaan muutama erilainen vaihtelevilla vaikeustasoilla, ja joillain poluilla voi olla "hidasteita". Hakualgoritmi saa syötteenä sokkelon, joka on kaksiulotteisen taulukon muodossa, sekä alku- ja loppukoordinaatit.

&nbsp;

####Lähteet
* Tietorakenteet ja algoritmit kurssimateriaali
* Wikipedia
* http://theory.stanford.edu/%7Eamitp/GameProgramming/AStarComparison.html

