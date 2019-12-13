import java.io.Serializable;
import java.util.ArrayList;

public class Pessoa implements Serializable {
    private static final long serialVersionUID =6529685098267757690L;
    private String user, email;
    private ArrayList<Tarefa> tarefas=new ArrayList<>();

    public Pessoa(String user, String email){
        this.user=user;
        this.email = email;
    }

    public String getUser(){return user;}

    public String getEmail() {return email;}

    public ArrayList<Tarefa> getTarefas() {return tarefas;}

    public void associaTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }

    public Boolean verTarefa(Tarefa tarefa){
        Double peso=0.0;
        for(Tarefa aux:tarefas){
            if(aux.getTaxa()!=100){
                peso+=aux.getPeso();
            }
        }
        if(peso+tarefa.getPeso()>1){
            return false;
        }else{
            return true;
        }
    }

    public int getTipo(){return 0;}


    public Pessoa getOrientador(){return null;}

}
