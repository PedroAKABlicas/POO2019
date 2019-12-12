import java.io.*;
import java.util.ArrayList;

public class Ficheiro {
    private static final String pessoaPath ="files/pessoas";
    private static final String projPath = "files/projetos";
    private static final String tarefaPath="files/tarefas";

    public void WritePessoaToFile(ArrayList<Pessoa> pessoas){
        try{
            /*File fPessoa = new File(pessoaPath);*/
            FileOutputStream fileOut = new FileOutputStream(pessoaPath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(pessoas);
            objectOut.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void WriteProjetoToFile(ArrayList<Projeto> projetos){
        try{
            File fProj = new File(projPath);
            FileOutputStream fileOut = new FileOutputStream(fProj);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(projetos);
            objectOut.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public ArrayList<Pessoa> ReadPessoaFromFile(){
        try{
            FileInputStream fileIn = new FileInputStream(pessoaPath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) objectIn.readObject();
            objectIn.close();
            return pessoas;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Projeto> ReadProjFromFile(){
        try{
            FileInputStream fileIn = new FileInputStream(projPath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            ArrayList<Projeto> projetos = (ArrayList<Projeto>) objectIn.readObject();
            objectIn.close();
            return projetos;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
