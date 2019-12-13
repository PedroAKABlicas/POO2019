public class Licenciado extends Bolseiro{
    private Pessoa orientador;
    public Licenciado(String user, String email, Data diai, Data diaf, Pessoa orientador) {
        super(user, email, diai, diaf);
        this.orientador=orientador;
    }
    @Override
    public Pessoa getOrientador() {return orientador;}
    @Override
    public String getTipo() {return "Licenciado";}
}
