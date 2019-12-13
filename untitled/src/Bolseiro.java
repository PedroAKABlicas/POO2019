public class Bolseiro extends Pessoa {
    private Data datai, dataf;
    public Bolseiro(String user, String email, Data diai, Data diaf) {
        super(user, email);
        this.datai = diai;
        this.dataf = diaf;
    }

    public int getTipo() {return 0;}
}
