import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class atrasadosGUI extends JFrame {
    public JLabel lblTitulo;
    public JList listProjeto;
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    public atrasadosGUI(ArrayList<Projeto> projetos){
        LocalDate dataAtual=java.time.LocalDate.now();
        for(Projeto proj : projetos){
            if(proj.getDataFim().comparator(dataAtual))
            listModel.addElement(proj.getNome());
        }
        listProjeto.setModel(listModel);
    }
}
