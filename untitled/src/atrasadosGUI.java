import javax.swing.*;
import java.util.ArrayList;

public class atrasadosGUI extends JFrame {
    public JLabel lblTitulo;
    public JList listProjeto;
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    public atrasadosGUI(ArrayList<Projeto> projetos){
        for(Projeto proj : projetos){
            listModel.addElement(proj.getNome());
        }
    }
}
