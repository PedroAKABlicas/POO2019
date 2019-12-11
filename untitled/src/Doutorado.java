public class Doutorado extends Bolseiro {
    public Doutorado(String user, String email, Data diai, Data diaf) {
        super(user, email, diai, diaf);
    }
    @Override
    public String getTipo() {return "Doutorado";}
}
