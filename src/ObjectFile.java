import java.io.*;

public class ObjectFile {
    private ObjectInputStream iS;
    private ObjectOutputStream oS;

    //Open the file for reading
    public void openRead(File file) throws IOException {
        iS = new ObjectInputStream(new FileInputStream(file));
    }

    //Open the file for writing
    //param: file name
    public void openWrite(File file) throws IOException {
        oS = new ObjectOutputStream(new FileOutputStream(file));
    }

    //Read from file
    //Returns an object
    public Object readObj() throws IOException, ClassNotFoundException {
        return iS.readObject();
    }

    //Write to file
    //param: object to write
    public void writeObj(Object o) throws IOException {
        oS.writeObject(o);
    }

    //Close file (reading)
    public void closeRead() throws IOException {
        iS.close();
    }

    //Close file (writing)
    public void closeWrite() throws IOException {
        oS.close();
    }
}
