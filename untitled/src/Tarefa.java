import java.io.Serializable;

public class Tarefa implements Serializable{
    private static final long serialVersionUID =6529685098267757690L;
    private Data dataInicio, dataFim;
    private int duaracao;
    private Pessoa responsavel=null;
    private Double peso=0.0;
    private int taxa=0;

    public Tarefa(Data datai, Data dataf, int duracao){
        this.dataInicio=datai;
        this.dataFim=dataf;
        this.duaracao=duracao;
    }

    public void associaPessoa(Pessoa pessoa){
        this.responsavel=pessoa;
    }

    public void mudaTaxa(int taxa){
        this.taxa+=taxa;
    }

    public Double getPeso(){return this.peso;}

    public int getTaxa() {return taxa;}
}
