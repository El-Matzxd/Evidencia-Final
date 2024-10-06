

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();

        boolean accesoPermitido = false;
        while (!accesoPermitido) {

            System.out.println("---------------------------");
            System.out.println("(Hecho por Maximiliano GM)");
            System.out.println("Sanatorio El Sol");
            System.out.println("---------------------------\n");
            System.out.println("Ingrese sus Credenciales");
            System.out.print("ID: ");
            String adminID = scanner.nextLine();
            System.out.print("Contraseña:");
            String password = scanner.nextLine();


            if (admin.validarAcceso(adminID, password)) {
                accesoPermitido = true;
            } else {
                System.out.println("Credenciales Incorrectas, Itentelo de Nuevo\n");
            }
        }

        Doctor doctor = new Doctor();
        Paciente paciente = new Paciente();
        Cita cita = new Cita();

        int opcion = 0;

        while (opcion != 5) {
            try {
                // Men principal
                System.out.println("\nMenu:");
                System.out.println("1- Registrar a un Doctor");
                System.out.println("2- Registar a un Paciente");
                System.out.println("3- Agendar una Cita");
                System.out.println("4- Revisar los Detalles de una Cita Agendada (Con ID)");
                System.out.println("5- Salir");
                System.out.print("Elige una Opcion: ");
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        doctor.altaDoctor(scanner);
                        break;
                    case 2:
                        paciente.altaPaciente(scanner);
                        break;
                    case 3:
                        cita.crearCita(scanner, doctor, paciente);
                        break;
                    case 4:
                        cita.buscarCita(scanner);
                        break;
                    case 5:
                        System.out.println("Hasta Pronto!");
                        break;
                    default:
                        System.out.println("Por Favor Selecciona una Opcion Valida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada Invalida\n Por Favor Intentelo de Nuevo ");
            }
        }
    }
}
