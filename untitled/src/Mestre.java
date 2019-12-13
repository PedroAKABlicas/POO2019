public class Mestre extends Bolseiro{
    private Pessoa orientador;
    private int custo=1000;
    public Mestre(String user, String email, Data diai, Data diaf, Pessoa orientador) {
        super(user, email, diai, diaf);
        this.orientador=orientador;
    }
    @Override
    public Pessoa getOrientador() {return orientador;}
    @Override
    public int getTipo() {return custo;}
    @Override
    public Data getDataFim(){return dataf;}
}
