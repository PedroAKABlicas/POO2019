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

    public Boolean checkData(){
        if(this.ano%4==0){
            switch(this.mes){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if(this.dia<1 || this.dia>31){
                        return false;
                    }else{
                        return true;
                    }
                case 2:
                    if(this.dia<1 || this.dia>29){
                        return false;
                    }else{
                        return true;
                    }
                case 4:
                case 6:
                case 9:
                case 11:
                    if(this.dia<1 || this.dia>30){
                        return false;
                    }else{
                        return true;
                    }
                default:
                    return false;
            }
        }else{
            switch(this.mes){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if(this.dia<1 || this.dia>31){
                        return false;
                    }else{
                        return true;
                    }
                case 2:
                    if(this.dia<1 || this.dia>28){
                        return false;
                    }else{
                        return true;
                    }
                case 4:
                case 6:
                case 9:
                case 11:
                    if(this.dia<1 || this.dia>30){
                        return false;
                    }else{
                        return true;
                    }
                default:
                    return false;
            }
        }
    }
    public Data addData(int mes){
        this.mes=this.getMes()+mes;
        if(this.mes>12){
            this.ano+=1;
            this.mes=this.mes-12;
            return this;
        }
        return this;
    }
}
