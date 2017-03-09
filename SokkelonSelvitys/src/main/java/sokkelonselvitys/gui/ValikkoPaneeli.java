package sokkelonselvitys.gui;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import sokkelonselvitys.simulaatio.Simulaatio;

/**
 * Valikkopaneelista voi valita simulaatiossa käytettävän sokkelon ja
 * algoritmin.
 *
 * @author inka
 */
public class ValikkoPaneeli extends AbstraktiPaneeli {

    private TapahtumanKuuntelija kuuntelija;

    private JRadioButton helppo;
    private JRadioButton keskitaso;
    private JRadioButton vaikea;

    private JRadioButton aStar;
    private JRadioButton bfs;

    private JButton simulaatioNappula;

    /**
     * Konstruktori.
     *
     * @param simulaatio
     */
    public ValikkoPaneeli(Simulaatio simulaatio) {
        super(simulaatio);
        this.kuuntelija = new TapahtumanKuuntelija(this.simulaatio, this);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        luoKomponentit();
    }

    private void luoKomponentit() {
        add(new JLabel(" "));
        teeSokkeloValikko();
        add(new JLabel(" "));
        teeAlgoritmiValikko();
        add(new JLabel(" "));
        teeSimuloinninAloitusNappula();
    }

    private void teeSokkeloValikko() {
        JLabel sokkeloteksti = new JLabel("Valitse sokkelo:");
        add(sokkeloteksti);

        this.helppo = new JRadioButton("Helppo");
        this.keskitaso = new JRadioButton("Keskitaso");
        this.vaikea = new JRadioButton("Vaikea");

        ButtonGroup bg = new ButtonGroup();
        bg.add(helppo);
        bg.add(keskitaso);
        bg.add(vaikea);

        helppo.addActionListener(kuuntelija);
        keskitaso.addActionListener(kuuntelija);
        vaikea.addActionListener(kuuntelija);

        add(helppo);
        add(keskitaso);
        add(vaikea);
        helppo.setSelected(true);
    }

    private void teeAlgoritmiValikko() {
        JLabel algoritmiteksti = new JLabel("Valitse algoritmi:");
        add(algoritmiteksti);

        this.aStar = new JRadioButton("A*");
        this.bfs = new JRadioButton("BFS");

        ButtonGroup bg = new ButtonGroup();
        bg.add(aStar);
        bg.add(bfs);

        aStar.addActionListener(kuuntelija);
        bfs.addActionListener(kuuntelija);

        add(aStar);
        add(bfs);
        aStar.setSelected(true);
    }

    private void teeSimuloinninAloitusNappula() {
        this.simulaatioNappula = new JButton("Aloita simulaatio");
        simulaatioNappula.addActionListener(this.kuuntelija);
        add(simulaatioNappula);
    }

    public void paivitaNappulat() {
        if (this.simulaatio.onKaynnissa()) {
            this.helppo.setEnabled(false);
            this.keskitaso.setEnabled(false);
            this.vaikea.setEnabled(false);
            this.aStar.setEnabled(false);
            this.bfs.setEnabled(false);
            this.simulaatioNappula.setText("Lopeta simulaatio");
        } else {
            this.helppo.setEnabled(true);
            this.keskitaso.setEnabled(true);
            this.vaikea.setEnabled(true);
            this.aStar.setEnabled(true);
            this.bfs.setEnabled(true);
            this.simulaatioNappula.setText("Aloita simulaatio");
        }
    }

    public JRadioButton getHelppo() {
        return helppo;
    }

    public JRadioButton getKeskitaso() {
        return keskitaso;
    }

    public JRadioButton getVaikea() {
        return vaikea;
    }

    public JRadioButton getAStar() {
        return aStar;
    }

    public JRadioButton getBfs() {
        return bfs;
    }

    public JButton getSimulaatioNappula() {
        return simulaatioNappula;
    }

    @Override
    public void paivita() {
        paivitaNappulat();

    }

}
