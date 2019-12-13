public class Docente extends Pessoa {
    private int mecanografico;
    private String area;
    public Docente(String user, String email, int mecanografico, String area) {
        super(user, email);
        this.mecanografico=mecanografico;
        this.area=area;
    }

    public int getMecanografico() {return mecanografico;}

    public String getArea() {return area;}
    @Override
    public int getTipo() {return 0;}
}
