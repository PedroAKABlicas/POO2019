public class Doutorado extends Bolseiro {
    private int custo=1200;
    public Doutorado(String user, String email, Data diai, Data diaf) {
        super(user, email, diai, diaf);
    }
    @Override
    public int getTipo() {return custo;}
    @Override
    public Data getDataFim(){return dataf;}
}
