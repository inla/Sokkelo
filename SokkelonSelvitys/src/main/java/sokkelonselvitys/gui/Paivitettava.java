package sokkelonselvitys.gui;

/**
 * Rajapinta luokille, jotka tarvitsevat päivitysmahdollisuutta. Simulaatio- ja
 * Valikkopaneeli toteuttavat tämän rajapinnan.
 *
 * @author inka
 */
public interface Paivitettava {

    /**
     * Päivittää tarvittavan asian.
     */
    void paivita();
}