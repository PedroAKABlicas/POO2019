import java.io.Serializable;

public class Tarefa implements Serializable{
    private static final long serialVersionUID =6529685098267757690L;
    private Data dataInicio, dataFim;
    private int duaracao;
    private Pessoa responsavel=null;
    private String tipo;
    private int taxa=0;

    public Tarefa(Data datai, Data dataf, int duracao, String tipo){
        this.dataInicio=datai;
        this.dataFim=dataf;
        this.duaracao=duracao;
        this.tipo=tipo;
    }

    public void associaPessoa(Pessoa pessoa){
        this.responsavel=pessoa;
    }

    public void mudaTaxa(int taxa){
        this.taxa+=taxa;
    }

    public int getTaxa() {return taxa;}
}
