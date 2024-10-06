

public class Admin {
    // Matriz con las crednciales de Administrador
    private String[][] admins = {
            {"Lisa@MTS.com", "Bote213"},
            {"Mateo@MTS.com", "Casa055"},
            {"Paola@MTS.com", "MPGM2010"},
            {"Joel@MTS.com", "Contra123"},
            {"Lisa@MTS.com", "$Dinero5"},
            {"Maria@MTS.com", "LSQS4"},
            {"MiguelD@MTS.com", "WASD123"}
    };

    // Permitir accesos
    public boolean validarAcceso(String id, String password) {
        for (int i = 0; i < admins.length; i++) {
            // Comparar el ID y la contraseña
            if (admins[i][0].equals(id) && admins[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}
