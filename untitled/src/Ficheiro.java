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

    public void WriteTarefaToFile(ArrayList<Tarefa> tarefas){
        try{
            FileOutputStream fileOut = new FileOutputStream(pessoaPath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(tarefas);
            objectOut.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public ArrayList<Pessoa> ReadPessoaFromFile(String path){
        try{
            FileInputStream fileIn = new FileInputStream(path);
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
    public ArrayList<Projeto> ReadProjFromFile(String path){
        try{
            FileInputStream fileIn = new FileInputStream(path);
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
    public ArrayList<Tarefa> ReadTarefaFromFile(String path){
        try{
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            ArrayList<Tarefa> tarefas = (ArrayList<Tarefa>) objectIn.readObject();
            objectIn.close();
            return tarefas;
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
