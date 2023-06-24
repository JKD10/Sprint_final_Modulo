package sprintFinal2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Capacitacion {
    private int identificador;
    private String rutCliente;
    private String dia;
    private String hora;
    private String lugar;
    private String duracion;
    private int cantidadAsistentes;

    public Capacitacion() {}

    public Capacitacion(int identificador, String rutCliente, String dia, String hora, String lugar, String duracion, int cantidadAsistentes) {
        this.identificador = identificador;
        this.rutCliente = rutCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.duracion = duracion;
        this.cantidadAsistentes = cantidadAsistentes;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        if (dia.equalsIgnoreCase("lunes") || dia.equalsIgnoreCase("martes") || dia.equalsIgnoreCase("miercoles") || dia.equalsIgnoreCase("jueves") || dia.equalsIgnoreCase("viernes") || dia.equalsIgnoreCase("sábado") || dia.equalsIgnoreCase("domingo")) {
            this.dia = dia;
        } else {
            System.out.println("El día debe ser un valor permitido entre \"lunes\" y \"domingo\" (en ese formato).");
        }
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setLenient(false);
        try {
            Date d = sdf.parse(hora);
            this.hora = hora;
        } catch (Exception e) {
            System.out.println("La hora debe ser una hora valida del dia, en formato HH:MM (hora desde 0 a 23, minutos entre 0 y 59).");
        }
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        if (lugar.length() >= 10 && lugar.length() <= 50) {
            this.lugar = lugar;
        } else {
            System.out.println("El lugar debe tener entre 10 y 50 caracteres.");
        }
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        if (duracion.length() <= 70) {
            this.duracion = duracion;
        } else {
            System.out.println("La duracion no debe superar los 70 caracteres.");
        }
    }

    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public void setCantidadAsistentes(int cantidadAsistentes) {
        if (cantidadAsistentes < 1000) {
            this.cantidadAsistentes = cantidadAsistentes;
        } else {
            System.out.println("La cantidad de asistentes debe ser un numero entero menor que 1000.");
        }
    }

    @Override
    public String toString() {
        return "Capacitacion [identificador=" + identificador + ", rutCliente=" + rutCliente + ", dia=" + dia + ", hora=" + hora + ", lugar=" + lugar + ", duracion=" + duracion + ", cantidadAsistentes=" + cantidadAsistentes + "]";
    }
    
    public String mostrarDetalle() {
        return "La capacitacion sera en " + lugar + " a las " + hora + " del dia " + dia + ", y durara " + duracion + " minutos.";
    }

   
}

