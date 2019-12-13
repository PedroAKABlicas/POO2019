import java.io.*;
import java.util.ArrayList;

public class Ficheiro {
    private static final String objPath ="files/obj_file", txtPath="files/txt_file";

    public void WritePessoaToFile(Cisuc cisuc){
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

    public ArrayList<Pessoa> ReadPessoaFromFile(){
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        ArrayList<Projeto> projetos = new ArrayList<>();
        try{
            FileInputStream fileIn = new FileInputStream(objPath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            pessoas = (ArrayList<Pessoa>) objectIn.readObject();
            projetos = (ArrayList<Projeto>) objectIn.readObject();
            objectIn.close();
            return pessoas;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return pessoas;
        } catch (IOException e) {
            e.printStackTrace();
            return pessoas;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return pessoas;
        }
    }
    public ArrayList<Projeto> ReadProjFromFile(){
        ArrayList<Projeto> projetos = new ArrayList<>();
        try{
            FileInputStream fileIn = new FileInputStream(projPath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            projetos = (ArrayList<Projeto>) objectIn.readObject();
            objectIn.close();
            return projetos;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return projetos;
        } catch (IOException e) {
            e.printStackTrace();
            return projetos;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return projetos;
        }
    }
}
