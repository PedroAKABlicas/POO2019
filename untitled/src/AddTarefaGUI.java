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
    public AddTarefaGUI(MainGUI mainGUI){
        this.menu=menu;
        setLayout(null);
        lblDataI = new JLabel("Data de Inicio:");
        lblDataI.setBounds(25,25, 100,30);
        txtDataI= new JTextField();
        txtDataI.setBounds(115,25,100,30);
        lblDataF = new JLabel("Data de Fim:");
        lblDataF.setBounds(225,25, 100,30);
        txtDataF= new JTextField();
        txtDataF.setBounds(305,25,100,30);
        lblResponsavel = new JLabel("Responsavel:");
        lblResponsavel.setBounds(25,75, 100,30);
        comboPessoa = new JComboBox(tipoStrings);
        comboPessoa.setBounds(125,80,100,20);
        lblTipo= new JLabel("Tipo:");
        lblTipo.setBounds(25,125,100,30);
        comboTipo= new JComboBox(tipoStrings);
        comboTipo.setBounds(75,130,100,20);
        lblEstimativa = new JLabel("Estimativa em meses:");
        lblEstimativa.setBounds(25,200,150,30);
        txtEstimativa= new JTextField();
        txtEstimativa.setBounds(155,203,100,25);
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(55, 280, 300, 25);
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
