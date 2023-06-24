package sprintFinal2;

import java.util.List;

/**
 * Clase que representa un Cliente, que es un tipo de Usuario y puede brindar Asesoría.
 */

public class Cliente extends Usuario implements Asesoria {
    private int rut;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String afp;
    private int sistemaSalud;
    private String direccion;
    private String comuna;
    private int edad;

    /**
     * Constructor vacío de la clase Cliente.
     */
    
    public Cliente() {}
    
    /**
     * Constructor de la clase Cliente.
     *
     * @param nombres         Nombres del cliente.
     * @param apellidos       Apellidos del cliente.
     * @param rut             Rut del cliente.
     * @param telefono        Teléfono del cliente.
     * @param afp             AFP del cliente.
     * @param sistemaSalud    Sistema de salud del cliente.
     * @param direccion       Dirección del cliente.
     * @param comuna          Comuna del cliente.
     * @param edad            Edad del cliente.
     */

    public Cliente(String nombres, String apellidos,int rut, String telefono, String afp, int sistemaSalud, String direccion, String comuna, int edad) {
        super();
    	this.nombres = nombres;
        this.apellidos = apellidos;
        this.rut = rut;
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        if (rut < 99999999) {
            this.rut = rut;
        } else {
            System.out.println("El RUT debe ser menor a 99.999.999.");
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        if (apellidos.length() >= 5 && apellidos.length() <= 30) {
            this.apellidos = apellidos;
        } else {
            System.out.println("Los apellidos deben tener entre 5 y 30 caracteres.");
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        if (afp.length() >= 4 && afp.length() <= 30) {
            this.afp = afp;
        } else {
            System.out.println("La AFP debe tener entre 4 y 30 caracteres.");
        }
    }

    public int getSistemaSalud() {
        return sistemaSalud;
    }

    public void setSistemaSalud(int sistemaSalud) {
        if (sistemaSalud == 1 || sistemaSalud == 2) {
            this.sistemaSalud = sistemaSalud;
        } else {
            System.out.println("El sistema de salud debe ser 1 (Fonasa) o 2 (Isapre).");
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion.length() <= 70) {
            this.direccion = direccion;
        } else {
            System.out.println("La direccion no puede tener mas de 70 caracteres.");
        }
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        if (comuna.length() <= 50) {
            this.comuna = comuna;
        } else {
            System.out.println("La comuna no puede tener mas de 50 caracteres.");
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 0 && edad < 150) {
            this.edad = edad;
        } else {
            System.out.println("La edad debe ser mayor o igual a cero y menor a 150.");
        }
    }

    public String toString() {
        return super.toString() + ",Nombres: " + nombres + ", RUT: " + rut + ", Apellidos: " + apellidos + ", Telefono: " + telefono + ", AFP: " + afp + ", Sistema de salud: " + sistemaSalud + ", Direccion: " + direccion + ", Comuna: " + comuna + ", Edad: " + edad;
    }
    
    public String obtenerSistemaSalud() {
        if (sistemaSalud == 1) {
            return "Fonasa";
        } else if (sistemaSalud == 2) {
            return "Isapre";
        } else {
            return "Sistema de salud no definido";
        }
    }

    public String obtenerNombre() {
        return getNombre() + " " + getApellido();
    }

    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Direccion: " + direccion + ", Comuna: " + comuna);
    }
    
    private List<Capacitacion> capacitaciones;

    public List<Capacitacion> getCapacitaciones() {
        return capacitaciones;
    }

    public void setCapacitaciones(List<Capacitacion> capacitaciones) {
        this.capacitaciones = capacitaciones;
    }

    public String getNombreCompleto() {
        return getNombre() + " " + getApellidos();
    }
}
