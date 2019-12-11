import java.io.Serializable;
import java.util.ArrayList;

public class Projeto implements Serializable {
    private String nome, acronimo;
    private Data dataInicio, dataFim;
    private int duaracao;
    private ArrayList<Pessoa> equipa;
    private ArrayList<Tarefa> tarefas;

    public Projeto(String nome, String acronimo, Data dataI, Data dataF, int duracao){
        this.nome=nome;
        this.acronimo=acronimo;
        this.dataInicio=dataI;
        this.dataFim=dataF;
        this.duaracao=duracao;
    }

    public void associaPessoa(Pessoa pessoa){
        equipa.add(pessoa);
    }

    /*public int getCusto(){
        int custo=0;
        for (Tarefa tarefa : tarefas){
            custo+=tarefa.custo;
        }
        return custo;
    }*/
}
