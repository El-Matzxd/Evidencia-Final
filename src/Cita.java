

import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cita {
    private ArrayList<String> ids = new ArrayList<>();
    private ArrayList<String> fechasHoras = new ArrayList<>();
    private ArrayList<String> motivos = new ArrayList<>();
    private ArrayList<String> doctores = new ArrayList<>();
    private ArrayList<String> pacientes = new ArrayList<>();

    public void crearCita(@NotNull Scanner scanner, Doctor doctor, Paciente paciente) {

        System.out.print("Ingrese un ID para la Cita: ");
        String idCita = scanner.nextLine();

        // Si ya existe una cita con el mismo ID marca error
        if (ids.contains(idCita)) {
            System.out.println("Error: Ya Existe una Cita con ese ID");
            return;
        }

        // Pedimos los datos del paciente y doctor
        System.out.print("Ingrese el ID del Paciente: ");
        String idPaciente = scanner.nextLine();
        String nombrePaciente = paciente.buscarPaciente(idPaciente);

        if (nombrePaciente == null) {
            System.out.println("Error: Paciente no encontrado.");
            return;
        }

        System.out.print("Ingrese el ID del Doctor: ");
        String idDoctor = scanner.nextLine();
        String nombreDoctor = doctor.buscarDoctor(idDoctor);

        if (nombreDoctor == null) {
            System.out.println("Error: Doctor no encontrado.");
            return;
        }

        // Pedimos fecha, hora y motivo de la cita
        System.out.print("Ingrese la Fecha y Hora de la Cita: ");
        String fechaHora = scanner.nextLine();
        System.out.print("Motivo: ");
        String motivo = scanner.nextLine();

        // Guardamos los datos de la cita
        ids.add(idCita);
        fechasHoras.add(fechaHora);
        motivos.add(motivo);
        doctores.add(nombreDoctor);
        pacientes.add(nombrePaciente);

        System.out.println("Se ha Agendado una Cita!");

        // Llamar al metodo para crear el "ticket"
        crearArchivoCita(idCita, fechaHora, motivo, nombreDoctor, nombrePaciente);
    }

    // Metodo para crear el "ticket"
    private void crearArchivoCita(String idCita, String fechaHora, String motivo, String nombreDoctor, String nombrePaciente) {
        try {
            // Crear un archivo con el nombre del ID de la cita
            FileWriter fileWriter = new FileWriter(idCita + ".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Pasar los datos al txt
            printWriter.println("Detalles:");
            printWriter.println("ID de la Cita: " + idCita);
            printWriter.println("Motivo: " + motivo);
            printWriter.println("Fecha y Hora: " + fechaHora);
            printWriter.println("Doctor: " + nombreDoctor);
            printWriter.println("Paciente: " + nombrePaciente);

            // Cerrar el txt
            printWriter.close();

            System.out.println("Tome su Ticket! " + idCita + ".txt");
        } catch (IOException e) {
            System.out.println("Error al Generar Ticket :( " + e.getMessage());
        }
    }

    public void buscarCita(@NotNull Scanner scanner) {
        System.out.print("Ingrese el ID de la Cita: ");
        String idCita = scanner.nextLine();
        int index = ids.indexOf(idCita);

        if (index != -1) {
            System.out.println("\nDetalles:");
            System.out.println("ID de la Cita: " + ids.get(index));
            System.out.println("Motivo: " + motivos.get(index));
            System.out.println("Fecha y Hora: " + fechasHoras.get(index));
            System.out.println("Doctor: " + doctores.get(index));
            System.out.println("Paciente: " + pacientes.get(index));

        } else {
            System.out.println("Error: Esa Cita NO esta Agendada :(");
        }
    }
}
