import java.io.*;
import java.util.ArrayList;

public class Ficheiro {
    private static final String objPath ="files/obj_file", txtPath="txt_file";
    File file;

    public void WriteToFile(Cisuc cisuc){
        try{
            /*File fPessoa = new File(pessoaPath);*/
            FileOutputStream fileOut = new FileOutputStream(objPath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(cisuc.listaPessoas);
            objectOut.writeObject(cisuc.listaProjeto);

            objectOut.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void ReadFromFile(Cisuc cisuc){
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        file = new File(objPath);
        String line;
        String[] info, data;
        Data datai, dataf;
        if(file.exists() && file.isFile()){
            try{
                FileInputStream fileIn = new FileInputStream(objPath);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);

                cisuc.listaPessoas = (ArrayList<Pessoa>) objectIn.readObject();
                cisuc.listaProjeto = (ArrayList<Projeto>) objectIn.readObject();
                objectIn.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            try{
                FileReader fr = new FileReader("txt_file.txt");
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine())!=null){
                    info=line.split("\\|");
                    switch(info[0]){
                        case "Licenciado":
                            data=info[3].split("/");
                            datai=new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                            data=info[4].split("/");
                            dataf=new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                            Pessoa licenciado = new Licenciado(info[1], info[2], datai, dataf, cisuc.listaPessoas.get(Integer.parseInt(info[5])));
                            cisuc.listaPessoas.add(licenciado);
                            break;
                        case "Docente":
                            Pessoa docente = new Docente(info[1], info[2], Integer.parseInt(info[3]), info[4]);
                            cisuc.listaPessoas.add(docente);
                            break;
                        case "Mestre":
                            data=info[3].split("/");
                            datai=new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                            data=info[4].split("/");
                            dataf=new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                            Pessoa mestre = new Licenciado(info[1], info[2], datai, dataf, cisuc.listaPessoas.get(Integer.parseInt(info[5])));
                            cisuc.listaPessoas.add(mestre);
                            break;
                        case "Doutorado":
                            data=info[3].split("/");
                            datai=new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                            data=info[4].split("/");
                            dataf=new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                            Pessoa doutorado = new Doutorado(info[1], info[2], datai, dataf);
                            cisuc.listaPessoas.add(doutorado);
                            break;
                        case "Design":
                            data=info[2].split("/");
                            datai=new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                            Tarefa design = new Design(info[1], datai, Integer.parseInt(info[3]), cisuc.listaPessoas.get(Integer.parseInt(info[4])));
                            tarefas.add(design);
                            cisuc.listaPessoas.get(Integer.parseInt(info[4])).associaTarefa(design);
                            break;
                        case "Documentacao":
                            data=info[2].split("/");
                            datai=new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                            Tarefa doc = new Documentacao(info[1], datai, Integer.parseInt(info[3]), cisuc.listaPessoas.get(Integer.parseInt(info[4])));
                            tarefas.add(doc);
                            cisuc.listaPessoas.get(Integer.parseInt(info[4])).associaTarefa(doc);
                            break;
                        case "Desenvolvimento":
                            data=info[2].split("/");
                            datai=new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                            Tarefa desenvolvimento = new Desenvolvimento(info[1], datai, Integer.parseInt(info[3]), cisuc.listaPessoas.get(Integer.parseInt(info[4])));
                            tarefas.add(desenvolvimento);
                            cisuc.listaPessoas.get(Integer.parseInt(info[4])).associaTarefa(desenvolvimento);
                            break;
                        case "Projeto":
                            data=info[3].split("/");
                            datai=new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                            data=info[4].split("/");
                            dataf=new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                            Projeto projeto = new Projeto(info[1], info[2], datai, dataf, Integer.parseInt(info[5]), cisuc.listaPessoas.get(Integer.parseInt(info[6])));
                            projeto.associaPessoa(cisuc.listaPessoas.get(Integer.parseInt(info[7])));
                            projeto.addTarefa(tarefas.get(Integer.parseInt(info[8])));
                            projeto.addTarefa(tarefas.get(Integer.parseInt(info[9])));
                            cisuc.listaProjeto.add(projeto);
                    }
                }
                this.WriteToFile(cisuc);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
