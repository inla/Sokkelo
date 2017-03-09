package sokkelonselvitys.gui;

import javax.swing.JPanel;
import sokkelonselvitys.simulaatio.Simulaatio;

/**
 *
 * @author inka
 */
public abstract class AbstraktiPaneeli extends JPanel{
    protected Simulaatio simulaatio;

    public AbstraktiPaneeli(Simulaatio simulaatio) {
        this.simulaatio = simulaatio;
    }
    
    public abstract void paivita();
}
