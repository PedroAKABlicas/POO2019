public class Licenciado extends Bolseiro{
    private Pessoa orientador;
    public Licenciado(String user, String email, Data diai, Data diaf) {
        super(user, email, diai, diaf);
    }

    public Pessoa getOrientador() {return orientador;}
    @Override
    public String getTipo() {return "Licenciado";}
}
