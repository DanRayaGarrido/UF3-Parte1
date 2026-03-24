import java.util.Scanner;
import java.util.ArrayList;
public class RayaDanMain {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n1. Crear personaje");
            System.out.println("2. Eliminar personaje");
            System.out.println("3. Ranking");
            System.out.println("4. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> crear();
                case 2 -> eliminar();
                case 3 -> ranking();
            }

        } while (opcion != 4);
    }
    // 👇 AQUÍ VAN LOS MÉTODOS

    public static void crear() {
        ArrayList<RayaDanCharacter> lista = RayaDanBinario.cargar();
        System.out.print("Name: ");
        String name = sc.nextLine();
        for (RayaDanCharacter p : lista) {
            if (p.getName().equalsIgnoreCase(name)) {
                System.out.println("Error: ya existe.");
                return;
            }
        }
        System.out.print("Level (1-50): ");
        int level = sc.nextInt();

        System.out.print("EXP (0-9999): ");
        int exp = sc.nextInt();
        if (level < 1 || level > 50 || exp < 0 || exp > 9999) {
            System.out.println("Datos inválidos.");
            return;
        }
        lista.add(new RayaDanCharacter(name, level, exp));
        RayaDanBinario.guardar(lista);

        System.out.println("Personaje creado correctamente.");
    }

    public static void eliminar() {
        ArrayList<RayaDanCharacter> lista = RayaDanBinario.cargar();
        if (lista.isEmpty()) {
            System.out.println("No hay personajes.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ". " + lista.get(i));
        }
        System.out.print("Elige índice: ");
        int index = sc.nextInt();
        if (index < 0 || index >= lista.size()) {
            System.out.println("Error.");
            return;
        }
        lista.remove(index);
        RayaDanBinario.guardar(lista);

        System.out.println("Eliminado correctamente.");
    }

    public static void ranking() {
        ArrayList<RayaDanCharacter> lista = RayaDanBinario.cargar();
        if (lista.isEmpty()) {
            System.out.println("No hay personajes.");
            return;
        }
        lista.sort((a, b) -> b.getExperience() - a.getExperience());
        for (RayaDanCharacter p : lista) {
            System.out.println(p);
        }
    }
}
