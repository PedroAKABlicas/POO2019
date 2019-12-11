import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class novoProjetoGUI extends JFrame {
    private JLabel labelNome, labelAcronimo, labelDuracao, labelDataI, labelDataF;
    private JTextField txtNome, txtAcronimo, txtDuracao, txtDataI, txtDataF;
    protected JButton btnCria, btnVoltar;
    ArrayList<Projeto> projetos = new ArrayList<>();
    Projeto proj;
    public novoProjetoGUI() {
        setLayout(null);
        labelNome = new JLabel("Nome do projeto: ");
        labelNome.setBounds(40, 40, 200, 20);
        labelAcronimo = new JLabel("Acrónimo: ");
        labelAcronimo.setBounds(40, 70, 150, 20);
        labelDuracao = new JLabel("Duração do projeto:");
        labelDuracao.setBounds(40, 100, 500, 20);
        txtNome = new JTextField();
        txtNome.setBounds(160, 40, 233, 20);
        txtAcronimo = new JTextField();
        txtAcronimo.setBounds(120, 70, 100, 20);
        txtDuracao = new JTextField("em meses");
        txtDuracao.setBounds(160, 100, 100, 20);
        labelDataI = new JLabel("Data de inicio:");
        labelDataI.setBounds(40, 130, 225, 20);
        labelDataF = new JLabel("Data de fim:");
        labelDataF.setBounds(240, 130, 225, 20);
        txtDataI = new JTextField("dd/mm/yyyy");
        txtDataI.setBounds(140, 130, 80, 20);
        txtDataF = new JTextField("dd/mm/yy");
        txtDataF.setBounds(330, 130, 80, 20);
        btnCria = new JButton("Criar");
        btnCria.setBounds(120, 160, 80, 20);
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(220, 160, 80, 20);
        add(btnVoltar);
        add(labelAcronimo);
        add(labelDataF);
        add(labelDataI);
        add(labelNome);
        add(labelNome);
        add(labelDuracao);
        add(txtAcronimo);
        add(txtDuracao);
        add(txtNome);
        add(txtDataI);
        add(txtDataF);
        add(btnCria);
        btnCria.addActionListener(e->{
            if (txtDuracao.getText()==null || txtAcronimo.getText()==null || txtDataF.getText()==null || txtDataI.getText()==null || txtNome.getText()==null){
                JOptionPane.showMessageDialog(null, "Preencha os campos todos");
            }
            String[] data = txtDataI.getText().split("/");
            Data dataI = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            data = txtDataF.getText().split("/");
            Data dataF = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            proj = new Projeto(txtNome.getText(), txtAcronimo.getText(), dataI, dataF, Integer.parseInt(txtDuracao.getText()));
            projetos.add(proj);
            Ficheiro ficheiro = new Ficheiro();
            ficheiro.WriteProjetoToFile(projetos);
        });
        txtDuracao.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                txtDuracao.setText("");
            }

            public void focusLost(FocusEvent e) {
                // nothing
            }
        });

        txtDataI.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                txtDataI.setText("");
            }

            public void focusLost(FocusEvent e) {
                // nothing
            }
        });

        txtDataF.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                txtDataF.setText("");
            }

            public void focusLost(FocusEvent e) {
                // nothing
            }
        });
    }
}
