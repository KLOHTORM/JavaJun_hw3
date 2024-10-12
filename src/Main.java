import java.io.*;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();

        try{
            FileOutputStream fos = new FileOutputStream("output.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(person);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (
                FileInputStream fis = new FileInputStream("output.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
        )
        {
            Object var = ois.readObject();
            System.out.println(var);

        }catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}