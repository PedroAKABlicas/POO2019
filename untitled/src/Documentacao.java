public class Documentacao extends Tarefa{
    private double peso=0.25;
    public Documentacao(Data datai, Data dataf, int duracao){
        super(datai, dataf, duracao);
    }
    @Override
    public Double getPeso(){return this.peso;}

}
