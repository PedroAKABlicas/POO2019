public class Bolseiro extends Pessoa {
    private static final long serialVersionUID =6529685098267757690L;
    protected Data datai, dataf;
    public Bolseiro(String user, String email, Data diai, Data diaf) {
        super(user, email);
        this.datai = diai;
        this.dataf = diaf;
    }

    public int getTipo() {return 0;}
    public Data getDataFim(){return dataf;}
    public Data getDataInicio(){return datai;}
    @Override
    public Boolean verTarefa(Tarefa tarefa){
        Double peso=0.0;
        Data nova = tarefa.getDataInicio().addData(tarefa.getDuaracao());
        if((this.getDataFim().compare(nova)) && !(this.getDataInicio().compare(nova))){
            System.out.println("ola");
            return false;
        }
        for(Tarefa aux:this.getTarefas()){
            if(aux.getTaxa()!=100){
                peso+=aux.getPeso();
            }
        }
        if(peso+tarefa.getPeso()>1.1){
            return false;
        }else{
            return true;
        }
    }
}
