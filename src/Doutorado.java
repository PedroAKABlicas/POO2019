public class Doutorado extends Bolseiro {
    public Doutorado(String user, String email, Data diai, Data diaf) {
        super(user, email, diai, diaf);
    }

    private String getTipo() {return "Doutorado";}
}
