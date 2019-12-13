public class Desenvolvimento extends Tarefa{
    private Double peso=1.0;
    public Desenvolvimento(Data datai, Data dataf, int duracao){
        super(datai, dataf, duracao);
    }
    @Override
    public Double getPeso(){return this.peso;}
}
