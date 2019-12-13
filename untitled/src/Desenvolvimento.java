public class Desenvolvimento extends Tarefa{
    private Double peso=1.0;
    public Desenvolvimento(String nome, Data datai, int duracao, Pessoa responsavel){
        super(nome, datai, duracao, responsavel);
    }
    @Override
    public Double getPeso(){return this.peso;}
}
