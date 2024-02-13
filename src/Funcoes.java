import java.io.File;

public class Funcoes {
    public static EnterpriseList LerFicheiro(File f, ObjectFile fo){
        EnterpriseList StarThrive= new EnterpriseList();

        //Ler ficheiros

        //Ficheiro de Objetos

        //Se existir
        if (f.exists()){

            try {
                //Abrir o ficheiro
                fo.openRead(f);
                //Ler o objeto do ficheiro (lista) e armazená-lo em StarThrive
                StarThrive = (EnterpriseList) fo.readObj();
                //Fechar o ficheiro
                fo.closeRead();
            }
            //Exceções
            catch (Exception e){
                e.printStackTrace();
            }
        }
        //Se não existir
        else {

            //Ficheiro de Texto
            File t = new File ("starthrive.txt");
            TextFile ft = new TextFile();

            //Se existir
            if (t.exists()){

                try {
                    //Abrir o ficheiro, armazenar info em StarThrive e fechar o ficheiro
                    ft.read(t, StarThrive);
                }
                //Exceções
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            //Se não existir
            else {
                System.out.println("Missing file: data not found.");
                StarThrive.Add(new Cafe("Moçambique", "Restauracao", "Coimbra", new GPS(532.12, 444.672), 4, 100, 18, 1000, 39, 30000));
            }
        }
        return StarThrive;
    }
    public static void GuardarFicheiro(EnterpriseList StarThrive, File f, ObjectFile fo){
        //Guardar no ficheiro

        //Ficheiro de Objetos

        try {
            fo.openWrite(f);
            fo.writeObj(StarThrive);
            fo.closeWrite();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
