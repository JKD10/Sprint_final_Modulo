package sprintFinal2;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Almacenar cliente");
            System.out.println("2. Almacenar profesional");
            System.out.println("3. Almacenar administrativo");
            System.out.println("4. Almacenar capacitacion");
            System.out.println("5. Eliminar usuario");
            System.out.println("6. Listar usuarios");
            System.out.println("7. Listar usuarios por tipo");
            System.out.println("8. Listar capacitaciones");
            System.out.println("9. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    almacenarCliente(contenedor, scanner);
                    break;
                case 2:
                    almacenarProfesional(contenedor, scanner);
                    break;
                case 3:
                    almacenarAdministrativo(contenedor, scanner);
                    break;
                case 4:
                    almacenarCapacitacion(contenedor, scanner);
                    break;
                case 5:
                    eliminarUsuario(contenedor, scanner);
                    break;
                case 6:
                    listarUsuarios(contenedor);
                    break;
                case 7:
                    listarUsuariosPorTipo(contenedor);
                    break;
                case 8:
                    listarCapacitaciones(contenedor);
                    break;
                case 9:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente.");
            }
        } while (opcion != 9);
    }

    private static void almacenarCliente(Contenedor contenedor, Scanner scanner) {
        System.out.print("Ingrese el RUT del cliente: ");
        int rut = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombres = scanner.nextLine();
        System.out.print("Ingrese el apellido del cliente: ");
        String apellidos = scanner.nextLine();
        System.out.print("Ingrese el telefono del cliente: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese la AFP del cliente: ");
        String afp = scanner.nextLine();
        System.out.print("Ingrese el sistema de salud del cliente (1: FONASA, 2: ISAPRE): ");
        int sistemaSalud = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la direccion del cliente: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese la comuna del cliente: ");
        String comuna = scanner.nextLine();
        System.out.print("Ingrese la edad del cliente: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = new Cliente(nombres, apellidos, rut, telefono, afp, sistemaSalud, direccion, comuna, edad);
        contenedor.almacenarCliente(cliente);
        System.out.println("Cliente almacenado exitosamente.");
    }


    private static void almacenarProfesional(Contenedor contenedor, Scanner scanner) {
        System.out.print("Ingrese el RUT del profesional: ");
        int rut = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del profesional: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del profesional: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese la fecha de nacimiento del profesional (formato yyyy-MM-dd): ");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
        System.out.print("Ingrese el correo electronico del profesional: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese el titulo del profesional: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese la especialidad del profesional: ");
        String especialidad = scanner.nextLine();
        System.out.print("Ingrese la fecha de ingreso del profesional (formato yyyy-MM-dd): ");
        LocalDate fechaIngreso = LocalDate.parse(scanner.nextLine());
        Profesional profesional = new Profesional(nombre, apellido, rut, correo, fechaNacimiento, titulo, fechaIngreso);
        contenedor.almacenarProfesional(profesional);
        System.out.println("Profesional almacenado exitosamente.");
    }

    private static void almacenarAdministrativo(Contenedor contenedor, Scanner scanner) {
        System.out.print("Ingrese el RUT del administrativo: ");
        int rut = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del administrativo: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del administrativo: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el correo electronico del administrativo: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese la fecha de nacimiento del administrativo (en formato AAAA-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
        System.out.print("Ingrese el area del administrativo: ");
        String area = scanner.nextLine();
        System.out.print("Ingrese la experiencia previa del administrativo: ");
        String experienciaPrevia = scanner.nextLine();
        Administrativo administrativo = new Administrativo(nombre, apellido, rut, correo, fechaNacimiento, area, experienciaPrevia);
        contenedor.almacenarAdministrativo(administrativo);
        System.out.println("Administrativo almacenado exitosamente.");
    }


    private static void almacenarCapacitacion(Contenedor contenedor, Scanner scanner) {
        System.out.print("Ingrese el identificador de la capacitacion: ");
        int identificador = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el RUT del cliente: ");
        String rutCliente = scanner.nextLine();
        System.out.print("Ingrese el día de la capacitacion: ");
        String dia = scanner.nextLine();
        System.out.print("Ingrese la hora de la capacitacion: ");
        String hora = scanner.nextLine();
        System.out.print("Ingrese el lugar de la capacitación: ");
        String lugar = scanner.nextLine();
        System.out.print("Ingrese la duracion de la capacitacion: ");
        String duracion = scanner.nextLine();
        System.out.print("Ingrese la cantidad de asistentes: ");
        int cantidadAsistentes = scanner.nextInt();
        Capacitacion capacitacion = new Capacitacion(identificador, rutCliente, dia, hora, lugar, duracion, cantidadAsistentes);
        contenedor.almacenarCapacitacion(capacitacion);
        System.out.println("Capacitacion almacenada exitosamente.");
    }


    private static void eliminarUsuario(Contenedor contenedor, Scanner scanner) {
        System.out.print("Ingrese el RUT del usuario a eliminar: ");
        try {
            int rut = scanner.nextInt();
            List<Usuario> usuarios = contenedor.listarUsuarios();
            Contenedor.eliminarUsuario(usuarios, rut);
            System.out.println("Usuario eliminado exitosamente.");
        } catch (InputMismatchException e) {
            System.out.println("El valor ingresado no es un numero entero valido.");
            scanner.next(); // Limpiar el buffer de entrada
        }
    }



    private static void listarUsuarios(Contenedor contenedor) {
        contenedor.listarUsuarios();
    }

    private static void listarUsuariosPorTipo(Contenedor contenedor) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== LISTADO DE USUARIOS POR TIPO ===");
            System.out.println("1. Listar clientes");
            System.out.println("2. Listar profesionales");
            System.out.println("3. Listar administrativos");
            System.out.println("4. Volver al menu principal");
            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    contenedor.listarUsuariosPorTipo("Cliente");
                    break;
                case 2:
                    contenedor.listarUsuariosPorTipo("Profesional");
                    break;
                case 3:
                    contenedor.listarUsuariosPorTipo("Administrativo");
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente.");
            }
        } while (opcion != 4);
    }


    private static void listarCapacitaciones(Contenedor contenedor) {
        contenedor.listarCapacitaciones();
    }
}

