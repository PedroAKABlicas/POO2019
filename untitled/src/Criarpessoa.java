import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;

public class Criarpessoa extends JFrame{
    protected JButton btnAddPessoa, btnVoltar;
    protected JLabel lblCargo,lblOrientador,lblMail,lblNome;
    String[] cargoStrings = { "Docente", "Licenciatura", "Mestrado", "Doutoramento" };
    protected JComboBox cargo,orientador;
    protected JTextField txtNome, txtMail;
    MainGUI menu;
    public Criarpessoa (MainGUI menu){
        setLayout(null);
        this.menu=menu;
        lblCargo = new JLabel("Cargo");
        lblCargo.setBounds(50,25, 200,30);
        cargo = new JComboBox(cargoStrings);
        cargo.setBounds(125,30,200,20);
        lblOrientador = new JLabel("Test");
        lblOrientador.setText("Orientador:");
        lblOrientador.setBounds(50,67, 200,30);
        orientador = new JComboBox();
        orientador.setBounds(125,71,200,20);
        txtMail= new JTextField();
        txtMail.setBounds(125,110,200,25);
        lblMail = new JLabel("Mail:");
        lblMail.setBounds(50,108, 200,30);
        txtNome= new JTextField();
        txtNome.setBounds(125,150,200,25);
        lblNome = new JLabel("Nome:");
        lblNome.setBounds(50,146, 200,30);
        btnAddPessoa = new JButton("Registar Pessoa");
        btnAddPessoa.setBounds(55, 200, 300, 25);
        btnVoltar = new JButton("Back");
        btnVoltar.setBounds(55, 240, 300, 25);
        add(btnAddPessoa);
        add(lblCargo);
        add(txtNome);
        add(lblOrientador);
        add(lblMail);
        add(orientador);
        add(cargo);
        add(lblNome);
        add(txtMail);
        add(btnVoltar);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnVoltarActionListener();
            }
        });
        cargo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargoActionListener(e);
            }
        });

        btnAddPessoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAddPessoaActionListener();
            }
        });
    }

    private void btnAddPessoaActionListener(){
        int carg = cargo.getSelectedIndex();
        switch(carg){
            case 0:
                Pessoa doc = new Docente(txtNome.getText(), txtMail.getText(), 0, null);
                break;
            case 1:
                Pessoa lic = new Licenciado(txtNome.getText(), txtMail.getText(), )
        }
        String role = cargoStrings[carg];

    }


    private void btnVoltarActionListener(){
        MainGUI menu = new MainGUI(this.menu.cisuc);
        menu.setSize(420, 300);
        menu.setVisible(true);
        this.setVisible(false);
    }
    private void cargoActionListener(ActionEvent e){
        JComboBox cb=(JComboBox)e.getSource();
        Integer carg=cb.getSelectedIndex();
        if ((carg) ==0 || carg==3) {
            orientador.disable();
        }
    }
}

