public class Design extends Tarefa {
    private Double peso=0.5;
    public Design(Data datai, Data dataf, int duracao){
        super(datai, dataf, duracao);
    }
    @Override
    public Double getPeso(){return this.peso;}
}
