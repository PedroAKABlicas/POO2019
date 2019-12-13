import java.io.Serializable;

public class Tarefa implements Serializable{
    private static final long serialVersionUID =6529685098267757690L;
    private Data dataInicio, dataFim;
    private int duaracao;
    private Pessoa responsavel;
    private Double peso=0.0;
    private int taxa=0;

    public Tarefa(Data datai, Data dataf, int duracao, Pessoa responsavel){
        this.dataInicio=datai;
        this.dataFim=dataf;
        this.duaracao=duracao;
        this.responsavel=responsavel;
    }

    public void associaPessoa(Pessoa pessoa){
        this.responsavel=pessoa;
    }

    public void tiraPessoa(){this.responsavel=null;}

    public void mudaTaxa(int taxa){
        this.taxa+=taxa;
    }

    public Double getPeso(){return this.peso;}

    public int getTaxa() {return taxa;}
}
