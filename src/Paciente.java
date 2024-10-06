

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Scanner;

public class Paciente {
    private ArrayList<String> ids = new ArrayList<>();
    private ArrayList<String> nombres = new ArrayList<>();

    public void altaPaciente(@NotNull Scanner scanner) {
        System.out.print("Ingrese un ID para el Paciente: ");
        String idPaciente = scanner.nextLine();

        // Si ya existe un paciente con el mismo ID marca error
        if (ids.contains(idPaciente)) {
            System.out.println("Error: Ya Existe un Paciente con ese ID!");
            return;
        }

        System.out.print("Ingrese el Nombre del Paciente: ");
        String nombrePaciente = scanner.nextLine();

        // Guardar los datos del paciente
        ids.add(idPaciente);
        nombres.add(nombrePaciente);

        System.out.println("Se ha Registrado a un Nuevo Paciente!");
    }

    public String buscarPaciente(String id) {
        int index = ids.indexOf(id);
        if (index != -1) {
            return nombres.get(index);
        } else {
            return null;
        }
    }
}
