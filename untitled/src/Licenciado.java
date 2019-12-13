public class Licenciado extends Bolseiro{
    private Pessoa orientador;
    private int custo=800;
    public Licenciado(String user, String email, Data diai, Data diaf, Pessoa orientador) {
        super(user, email, diai, diaf);
        this.orientador=orientador;
    }
    @Override
    public Pessoa getOrientador() {return orientador;}
    @Override
    public int getTipo() {return custo;}
}
