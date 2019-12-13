public class Design extends Tarefa {
    private Double peso=0.5;
    public Design(String nome, Data datai, int duracao, Pessoa responsavel){
        super(nome, datai, duracao, responsavel);
    }
    @Override
    public Double getPeso(){return this.peso;}
}
