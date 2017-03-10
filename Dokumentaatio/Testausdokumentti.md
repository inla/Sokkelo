##Testausdokumentti

Ohjelman logiikkaa, algoritmeja ja tietorakenteita on testattu JUnit-yksikkötesteillä.

###Tietorakenteiden testaus
Kaikkilla tietorakenteilla, Jono, Lista ja MinimiKeko, on testejä esimerkiksi sille, ovatko ne aluksi tyhjiä, kasvaako niiden maksimikoko tarvittaessa, kasvaako niiden koko lisättäessä alkioita ja saadaanko alkiot ulos oikeassa järjestyksessä. Testeissä tietorakenteisiin lisätään Integerejä.

###Algoritmien testaus
A\*- ja BFS-algoritmien toimivuutta on testattu suurinpiirtein samanlaisilla testeillä. Testejä löytyy esimerkiksi sille, löytääkö algoritmi reitin, löytääkö se lyhimmän reitin, osaako se kiertää esteitä ja vaihtaako se löydetyn reitin solmujen tilan reitiksi. Lisäksi A\*-algoritmille on joitakin testejä enemmän kuin BFS:lle, kuten etsiikö A\* oikeaan suuntaan eikä siis lähden vastakkaiseen suuntaan tutkimaan. Testeissä algoritmien suoritusta on hidastettu, jotta säikeet ehtivät suoriutua loppuun. Suoritukseen kuluvaa aikaa myös tarkkaillaan, jolloin tarvittaessa huomataan, jos algoritmi jostain syystä jumiutuu.
