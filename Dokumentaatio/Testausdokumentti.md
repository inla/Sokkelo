#Testausdokumentti

Ohjelman logiikkaa, algoritmeja ja tietorakenteita on testattu JUnit-yksikkötesteillä. Testit voidaan siis helposti toistaa suorittamalla ne uudestaan.

###Tietorakenteiden testaus
Kaikkilla tietorakenteilla, Jono, Lista ja MinimiKeko, on testejä esimerkiksi sille, ovatko ne aluksi tyhjiä, kasvaako niiden maksimikoko tarvittaessa, kasvaako niiden koko lisättäessä alkioita ja saadaanko alkiot ulos oikeassa järjestyksessä. Testeissä tietorakenteisiin lisätään Integerejä.

###Algoritmien testaus
A\*- ja BFS-algoritmien toimivuutta on testattu suurinpiirtein samanlaisilla testeillä. Testejä löytyy esimerkiksi sille, löytääkö algoritmi reitin, löytääkö se lyhimmän reitin, osaako se kiertää esteitä ja vaihtaako se löydetyn reitin solmujen tilan reitiksi. Lisäksi A\*-algoritmille on joitakin testejä enemmän kuin BFS:lle, kuten etsiikö A\* oikeaan suuntaan eikä siis lähden vastakkaiseen suuntaan tutkimaan. Testeissä algoritmien suoritusta on hidastettu, jotta säikeet ehtivät suoriutua loppuun. Suoritukseen kuluvaa aikaa myös tarkkaillaan, jolloin tarvittaessa huomataan, jos algoritmi jostain syystä jumiutuu.

###Suorituskykytestaus
Testasin molempien algoritmien suoriutumista kaikilla kolmella eri vaikeusasteisella sokkelolla. Suoritin algoritmit ilman simulaatiossa käytettävää 50 ms viiveettä. Ajoin algoritmit 100 kertaa, ja laskin keskiarvon niiden viemästä ajasta; tulokset alla olevassa taulukossa.

| Sokkelon vaikeus | A\* | BFS |
 -------------|-----|------
|helppo | 2,37 ms | 1,12 ms |
|keskitaso | 1,15 ms | 1,05 ms |
|vaikea | 0,62 ms | 0,61 ms |

Laskin suorituskyvyn myös käyttämällä yhden millisekunnin viivettä. Ajoin algoritmit taas 100 kertaa ja laskin niistä keskiarvon. Tulokset alla.

| Sokkelon vaikeus | A\* | BFS |
 -------------|-----|------
|helppo | 1,73 ms | 1,57 ms |
|keskitaso | 1,44 ms | 1,47 ms |
|vaikea | 1,29 ms | 1,53 ms |
