import java.io.Serializable;
import java.util.ArrayList;

public class Projeto implements Serializable {
    private static final long serialVersionUID =6529685098267757690L;
    private String nome, acronimo;
    private Data dataInicio, dataFim;
    private int duracao;
    private ArrayList<Pessoa> equipa = new ArrayList<>();
    private ArrayList<Tarefa> tarefas = new ArrayList<>();
    private Pessoa chefe;
    private Boolean acabado=false;

    public Projeto(String nome, String acronimo, Data dataI, Data dataF, int duracao, Pessoa chefe){
        this.nome=nome;
        this.acronimo=acronimo;
        this.dataInicio=dataI;
        this.dataFim=dataF;
        this.duracao=duracao;
        this.chefe=chefe;
        this.equipa.add(chefe);
    }

    public String getNome(){return nome;}

    public void setNome(String nome){this.nome=nome;}

    public String getAcronimo(){return acronimo;}

    public void setAcronimo(String acronimo){this.acronimo=acronimo;}

    public Data getDataInicio(){return dataInicio;}

    public Data getDataFim(){return dataFim;}

    public int getDuaracao(){return duracao;}

    public Pessoa getChefe(){return chefe;}

    public void associaPessoa(Pessoa pessoa){
        equipa.add(pessoa);
    }

    public String getCusto(){
        int custo=0;
        for (Pessoa pessoa : equipa){
            custo+=pessoa.getTipo();
        }
        return String.valueOf(custo);
    }

    public void addTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }

    public ArrayList<Tarefa> getTarefas(){return this.tarefas;}

    public ArrayList<Pessoa> getEquipa(){return this.equipa;}

    public Boolean getAcabado(){return this.acabado;}
}
