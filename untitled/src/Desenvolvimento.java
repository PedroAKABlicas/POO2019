public class Desenvolvimento extends Tarefa{
    private Double peso=1.0;
    public Desenvolvimento(Data datai, Data dataf, int duracao, Pessoa responsavel){
        super(datai, dataf, duracao, responsavel);
    }
    @Override
    public Double getPeso(){return this.peso;}
}
