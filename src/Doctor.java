

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Scanner;

public class Doctor {
    private ArrayList<String> ids = new ArrayList<>();
    private ArrayList<String> nombres = new ArrayList<>();
    private ArrayList<String> especialidades = new ArrayList<>();

    public void altaDoctor(@NotNull Scanner scanner) {
        System.out.print("Ingrese un ID para el Doctor: ");
        String idDoctor = scanner.nextLine();

        // Si ya existe un doctor con el mismo ID marca error
        if (ids.contains(idDoctor)) {
            System.out.println("Error: Ya Existe un Doctor con ese ID!");
            return;
        }

        System.out.print("Ingrese el Nombre del Doctor: ");
        String nombreDoctor = scanner.nextLine();
        System.out.print("Ingrese la ESPECIALIDAD del Doctor: ");
        String especialidadDoctor = scanner.nextLine();

        // Guardar los datos del doctor
        ids.add(idDoctor);
        nombres.add(nombreDoctor);
        especialidades.add(especialidadDoctor);

        System.out.println("Se ha Registrado un Nuevo Doctor!");
    }

    public String buscarDoctor(String id) {
        int index = ids.indexOf(id);
        if (index != -1) {
            return nombres.get(index);
        } else {
            return null;
        }
    }
}
