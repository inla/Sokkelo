package sokkelonselvitys.gui;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import sokkelonselvitys.simulaatio.Simulaatio;

/**
 * Valikkopaneelista voi valita simulaatiossa käytettävän sokkelon ja
 * algoritmin.
 *
 * @author inka
 */
public class ValikkoPaneeli extends JPanel implements Paivitettava {

    private Simulaatio simulaatio;
    private TapahtumanKuuntelija kuuntelija;

    private JRadioButton helppo;
    private JRadioButton keskitaso;
    private JRadioButton vaikea;

    private JRadioButton aStar;
    private JRadioButton bfs;

    private JButton simulaatioNappula;

    private JLabel reittiTeksti;

    private JButton tyhjennaNappula;

    /**
     * Konstruktori.
     *
     * @param simulaatio
     */
    public ValikkoPaneeli(Simulaatio simulaatio) {
        this.simulaatio = simulaatio;
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
        add(new JLabel(" "));
        add(new JLabel(" "));
        teeTekstiKentta();
        add(new JLabel(" "));
        add(new JLabel(" "));
        teeTyhjennaNappula();
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

    private void teeTekstiKentta() {
        this.reittiTeksti = new JLabel();
        add(reittiTeksti);
        this.reittiTeksti.setVisible(false);
    }

    private void teeTyhjennaNappula() {
        this.tyhjennaNappula = new JButton("Tyhjennä");
        tyhjennaNappula.addActionListener(this.kuuntelija);
        add(tyhjennaNappula);
        this.tyhjennaNappula.setVisible(false);
    }

    /**
     * Päivittää valikossa näkyvät valikot, nappulat ja tekstit tilanteeseen
     * sopiviksi.
     */
    private void paivitaNappulat() {
        if (this.simulaatio.onKaynnissa()) {
            otaValikkoNappulatKayttoon(false);
            this.simulaatioNappula.setText("Lopeta simulaatio");
            this.reittiTeksti.setText("Haetaan reittiä...");
            this.reittiTeksti.setVisible(true);
            if (this.simulaatio.onValmis()) {
                this.simulaatioNappula.setVisible(false);
                this.reittiTeksti.setText("Reitin pituus: " + this.simulaatio.getAlgoritmi().reitinPituus());
                this.reittiTeksti.setVisible(true);
                this.tyhjennaNappula.setVisible(true);
            }
        } else {
            otaValikkoNappulatKayttoon(true);
            this.simulaatioNappula.setText("Aloita simulaatio");
            this.simulaatioNappula.setVisible(true);
            this.reittiTeksti.setVisible(false);
            this.tyhjennaNappula.setVisible(false);
            if (this.simulaatio.getAlgoritmi() != null) {
                otaValikkoNappulatKayttoon(false);
                this.simulaatioNappula.setVisible(false);
                this.tyhjennaNappula.setVisible(true);
            }
        }
    }

    private void otaValikkoNappulatKayttoon(boolean kaytettavissa) {
        this.helppo.setEnabled(kaytettavissa);
        this.keskitaso.setEnabled(kaytettavissa);
        this.vaikea.setEnabled(kaytettavissa);
        this.aStar.setEnabled(kaytettavissa);
        this.bfs.setEnabled(kaytettavissa);
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

    public JButton getTyhjennaNappula() {
        return tyhjennaNappula;
    }

    @Override
    public void paivita() {
        paivitaNappulat();
    }
}
