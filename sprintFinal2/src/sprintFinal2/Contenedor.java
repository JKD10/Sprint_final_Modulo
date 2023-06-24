package sprintFinal2;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un contenedor para almacenar asesorías y capacitaciones.
 */

public class Contenedor {
    private List<Asesoria> asesorias;
    private List<Capacitacion> capacitaciones;

    public Contenedor() {
        asesorias = new ArrayList<>();
        capacitaciones = new ArrayList<>();
    }

    public void almacenarCliente(Cliente cliente) {
        asesorias.add(cliente);
    }

    public void almacenarProfesional(Profesional profesional) {
        asesorias.add(profesional);
    }

    public void almacenarAdministrativo(Administrativo administrativo) {
        asesorias.add(administrativo);
    }

    public void almacenarCapacitacion(Capacitacion capacitacion) {
        capacitaciones.add(capacitacion);
    }

    public static void eliminarUsuario(List<Usuario> usuarios, int rut) {
        if (usuarios == null) {
        	usuarios = new ArrayList<>();
        }
    	usuarios.removeIf(usuario -> usuario.getRun() == rut);
    }

    public List<Usuario> listarUsuarios() {
        for (Asesoria asesoria : asesorias) {
            System.out.println(asesoria.toString());
        }
		return null;
    }

    public void listarUsuariosPorTipo(String tipo) {
        for (Asesoria asesoria : asesorias) {
            if (asesoria.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                System.out.println(asesoria.toString());
            }
        }
    }

    public void listarCapacitaciones() {
        for (Capacitacion capacitacion : capacitaciones) {
            System.out.println(capacitacion.toString());
            for (Asesoria asesoria : asesorias) {
                if (asesoria instanceof Cliente && ((Cliente) asesoria).getCapacitaciones().contains(capacitacion)) {
                    System.out.println("Cliente: " + asesoria.getNombreCompleto());
                }
            }
            System.out.println();
        }
    }


}
