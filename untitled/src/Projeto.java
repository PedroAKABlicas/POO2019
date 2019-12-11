import java.io.Serializable;
import java.util.ArrayList;

public class Projeto implements Serializable {
    private String nome, acronimo;
    private Data dataInicio, dataFim;
    private int duaracao;
    private ArrayList<Pessoa> equipa;
    private ArrayList<Tarefa> tarefas;
    private Pessoa chefe;

    public Projeto(String nome, String acronimo, Data dataI, Data dataF, int duracao/*, Pessoa chefe*/){
        this.nome=nome;
        this.acronimo=acronimo;
        this.dataInicio=dataI;
        this.dataFim=dataF;
        this.duaracao=duracao;
        //this.chefe=chefe;
    }

    public void associaPessoa(Pessoa pessoa){
        equipa.add(pessoa);
    }

    public int getCusto(){
        int custo=0;
        for (Pessoa pessoa : equipa){
            String tipo = pessoa.getTipo();
            if (tipo=="Licencidado"){
                custo+=800;
            }else{
                if (tipo=="Mestre"){
                    custo+=1000;
                }
                else{
                    if(tipo=="Doutorado"){
                        custo+=1200;
                    }
                }
            }
        }
        return custo;
    }

    public ArrayList<Tarefa> getTarefas(){return tarefas;}
}
