public class Documentacao extends Tarefa{
    private double peso=0.25;
    public Documentacao(String nome, Data datai, int duracao, Pessoa responsavel){
        super(nome, datai, duracao, responsavel);
    }
    @Override
    public Double getPeso(){return this.peso;}

}
