public class Documentacao extends Tarefa{
    private double peso=0.25;
    public Documentacao(Data datai, Data dataf, int duracao, Pessoa responsavel){
        super(datai, dataf, duracao, responsavel);
    }
    @Override
    public Double getPeso(){return this.peso;}

}
