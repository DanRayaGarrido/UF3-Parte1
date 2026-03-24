import java.io.*;
import java.util.ArrayList;

public class RayaDanBinario {
    private static final String FILE = "personajes.dat";
    public static ArrayList<RayaDanCharacter> cargar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
            return (ArrayList<RayaDanCharacter>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    public static void guardar(ArrayList<RayaDanCharacter> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Error al guardar");
        }
    }
}
