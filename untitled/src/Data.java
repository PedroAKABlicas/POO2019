import java.io.Serializable;

public class Data implements Serializable {
    private static final long serialVersionUID =6529685098267757690L;
    public int dia, mes, ano;

    public Data (int dia, int mes, int ano){
        this.dia=dia;
        this.mes=mes;
        this.ano=ano;
    }

    public int getAno() {
        return ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public Boolean compare(Data dataAtual){
        if(dataAtual.ano>this.ano){
            return true;
        }else{
            if(this.ano==dataAtual.ano){
                if(dataAtual.mes>this.mes){
                    return true;
                }else{
                    if(dataAtual.mes==this.mes){
                        if(dataAtual.dia>this.dia){
                            return true;
                        }
                        else{
                            return false;
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.dia+"/"+this.mes+"/"+this.ano;
    }
}
