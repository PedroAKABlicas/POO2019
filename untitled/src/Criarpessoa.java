import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;

public class Criarpessoa extends JFrame{
    protected JButton btnAddPessoa, btnVoltar;
    private String[] cargoStrings = { "Docente", "Licenciatura", "Mestrado", "Doutoramento" };
    protected JComboBox cargo, orientador;
    protected JLabel lblCargo,lblOrientador,lblMail,lblNome,lblNumero,lblDataI,lblDataF;
    protected JTextField txtNome, txtMail,txtNumero,txtDataI,txtDataF;
    private String[] aux;
    protected DefaultComboBoxModel modelDoc;
    private ArrayList<Pessoa> docs = new ArrayList<>();
    MainGUI menu;
    public Criarpessoa (MainGUI menu){
        this.menu=menu;
        setLayout(null);
        lblCargo = new JLabel("Cargo");
        lblCargo.setBounds(50,25, 200,30);
        cargo = new JComboBox(cargoStrings);
        cargo.setBounds(125,30,200,20);
        cargo.setSelectedIndex(0);
        lblOrientador = new JLabel("Orientador");
        lblOrientador.setBounds(50,67, 200,30);
        orientador = new JComboBox(AtualizaDoc());
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
        btnAddPessoa.setBounds(55, 350, 300, 25);
        btnVoltar = new JButton("Back");
        btnVoltar.setBounds(55, 390, 300, 25);
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
        lblDataI = new JLabel("Data de Inicio de Bolsa:");
        lblDataI.setBounds(50,200, 200,30);
        txtDataI= new JTextField();
        txtDataI.setBounds(205,203,150,25);
        lblDataF = new JLabel("Data de Fim de Bolsa:");
        lblDataF.setBounds(50,250, 200,30);
        txtDataF= new JTextField();
        txtDataF.setBounds(205,253,150,25);
        lblNumero = new JLabel("Numero Mecanografico");
        lblNumero.setBounds(50,300, 200,30);
        txtNumero= new JTextField();
        txtNumero.setBounds(205,303,150,25);
        add(lblDataF);
        add(lblDataI);
        add(txtDataF);
        add(txtDataI);
        add(txtNumero);
        add(lblNumero);
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
        String nome;
        String[] data;
        Data dataI, dataF;
        switch(carg){
            case 0:
                Pessoa doc = new Docente(txtNome.getText(), txtMail.getText(), 0, null);
                menu.cisuc.listaPessoas.add(doc);
                AtualizaDoc();
                guardaFile(menu.cisuc.listaPessoas);
                break;
            case 1:
                nome = orientador.getSelectedItem().toString();
                data = txtDataI.getText().split("/");
                dataI = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                data = txtDataF.getText().split("/");
                dataF = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                Pessoa lic = new Licenciado(txtNome.getText(), txtMail.getText(), dataI, dataF, getOrientador(nome));
                menu.cisuc.listaPessoas.add(lic);
                break;
            case 2:
                data = txtDataI.getText().split("/");
                dataI = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                data = txtDataF.getText().split("/");
                dataF = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                nome = orientador.getSelectedItem().toString();
                Pessoa mestre = new Mestre(txtNome.getText(), txtMail.getText(), dataI, dataF, getOrientador(nome));
                menu.cisuc.listaPessoas.add(mestre);
                guardaFile(menu.cisuc.listaPessoas);
                break;
            case 3:
                data = txtDataI.getText().split("/");
                dataI = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                data = txtDataF.getText().split("/");
                dataF = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                Pessoa dout = new Doutorado(txtNome.getText(), txtMail.getText(), dataI, dataF);
                menu.cisuc.listaPessoas.add(dout);
                guardaFile(menu.cisuc.listaPessoas);
                break;
        }
        guardaPessoas();
        JOptionPane.showMessageDialog(null, "Pessoa Registada!");
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
        if ((carg) ==0) {
            orientador.disable();
            txtDataF.disable();
            txtDataI.disable();
            txtNumero.enable();
        }else{
            orientador.enable();
            txtDataF.enable();
            txtDataI.enable();
            txtNumero.disable();
        }
    }

    private Pessoa getOrientador(String nome){
        for(Pessoa pessoa : menu.cisuc.listaPessoas){
            if(nome.equals(pessoa.getUser())){
                return pessoa;
            }
        }

        return null;
    }

    private void guardaPessoas(){
        Ficheiro ficheiro = new Ficheiro();
        ficheiro.WriteToFile(menu.cisuc);
    }

    private DefaultComboBoxModel AtualizaDoc(){
        for(Pessoa pessoa : menu.cisuc.listaPessoas){
            if(pessoa.getTipo()==0){
                docs.add(pessoa);
            }
        }
        aux = new String[docs.size()];
        for(int i=0; i<docs.size(); i++){
            aux[i]=docs.get(i).getUser();
        }
        modelDoc = new DefaultComboBoxModel<>(aux);
        return modelDoc;
    }
    private void guardaFile(ArrayList<Pessoa> lista){
        Ficheiro ficheiro = new Ficheiro();
        ficheiro.WriteToFile(menu.cisuc);
    }
}

