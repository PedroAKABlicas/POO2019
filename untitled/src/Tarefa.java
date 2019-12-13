import java.io.Serializable;
import java.time.LocalDate;

public class Tarefa implements Serializable{
    private static final long serialVersionUID =6529685098267757690L;
    private String nome;
    private Data dataInicio, dataFim=null;
    private int duaracao;
    private Pessoa responsavel;
    private Double peso=0.0;
    private int taxa=0;

    public Tarefa(String nome, Data datai,int duracao, Pessoa responsavel){
        this.nome=nome;
        this.dataInicio=datai;
        this.duaracao=duracao;
        this.responsavel=responsavel;
    }

    public void associaPessoa(Pessoa pessoa){
        this.responsavel=pessoa;
    }

    public void tiraPessoa(){this.responsavel=null;}

    public void mudaTaxa(int taxa){
        this.taxa+=taxa;
        if(this.taxa==100){
            LocalDate data = java.time.LocalDate.now();
            this.dataFim= new Data(data.getDayOfMonth(), data.getMonthValue(), data.getYear());
        }
    }

    public Double getPeso(){return this.peso;}

    public int getDuaracao(){return duaracao;}

    public int getTaxa() {return taxa;}

    public Data getDataInicio(){return dataInicio;}

    public String getNome(){return nome;}
}
