import java.io.Serializable;

public class Data implements Serializable {
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

    public Boolean comparator(Data datai, Data dataf){
        if(dataf.ano>datai.ano){
            return true;
        }else{
            if(datai.ano==dataf.ano){
                if(dataf.mes>datai.mes){
                    return true;
                }else{
                    if(dataf.mes==datai.mes){
                        if(dataf.dia>datai.dia){
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
        return super.toString();
    }
}
