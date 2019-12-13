public class Design extends Tarefa {
    private Double peso=0.5;
    public Design(Data datai, Data dataf, int duracao, Pessoa responsavel){
        super(datai, dataf, duracao, responsavel);
    }
    @Override
    public Double getPeso(){return this.peso;}
}
