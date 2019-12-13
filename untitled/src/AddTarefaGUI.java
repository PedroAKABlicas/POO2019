import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTarefaGUI extends JFrame {
    private JLabel lblDataI, lblDataF, lblEstimativa, lblResponsavel, lblTipo;
    private JTextField txtDataI, txtDataF, txtEstimativa;
    private JButton btnVoltar;
    private String[] tipoStrings = { "Desenvolvimento","Design","Documentação"};
    private JComboBox comboPessoa, comboTipo;
    MainGUI menu;
    public AddTarefaGUI(EditaProjGUI ant, Projeto proj){
        this.menu=menu;
        setLayout(null);
        lblDataI = new JLabel("Data de Inicio:");
        lblDataI.setBounds(25,25, 100,30);
        txtDataI= new JTextField();
        txtDataI.setBounds(75,25,100,30);
        lblDataF = new JLabel("Data de Fim:");
        lblDataF.setBounds(180,25, 100,30);
        txtDataF= new JTextField();
        txtDataF.setBounds(230,25,100,25);
        lblResponsavel = new JLabel("Responsavel:");
        lblResponsavel.setBounds(25,75, 100,30);
        comboPessoa = new JComboBox(LISTA_DE_ORIENTADOR);
        comboPessoa.setBounds(75,75,100,20);
        lblTipo= new JLabel("Tipo:");
        lblTipo.setBounds(25,125,100,30);
        comboTipo= new JComboBox(tipoStrings);
        comboTipo.setBounds(75,125,100,30);
        lblEstimativa = new JLabel("Estimativa em meses:");
        lblEstimativa.setBounds(25,200,100,30);
        txtEstimativa= new JTextField();
        txtEstimativa.setBounds(230,200,100,25);
        add(txtEstimativa);
        add(txtDataF);
        add(txtDataI);
        add(lblTipo);
        add(lblResponsavel);
        add(lblEstimativa);
        add(lblDataI);
        add(lblDataF);
        add(comboTipo);
        add(comboPessoa);
        add(btnVoltar);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnVoltarActionListener();
            }
        });
    }
    private void btnVoltarActionListener(){
        MainGUI menu = new MainGUI(this.menu.cisuc);
        menu.setSize(420, 300);
        menu.setVisible(true);
        this.setVisible(false);
    }
}
