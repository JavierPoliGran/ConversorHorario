/* EFETCG8 - Integrantes: Javier Ladino Prada y Javier Jaimes. - Ingeniería de Software. - Politécnico Grancolombiano. -2023*/

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ConversorHorario {
    public static void main(String[] args) {
        // Obtener la hora actual en Colombia
        ZoneId zonaColombia = ZoneId.of("America/Bogota");
        LocalDateTime horaActualColombia = LocalDateTime.now(zonaColombia);

        System.out.println("\n¡Bienvenido! este es un algoritmo que convierte la fecha y hora local de Colombia a la fecha y hora de otros lugares del mundo.");
        System.out.println("\nInstrucciones:");
        System.out.println("\nA continuación podrá visualizar la fecha y hora actual de Colombia:");

        // Mostrar la hora actual en Colombia
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("\nLa fecha y hora actual en Colombia es: " + horaActualColombia.format(formato));

        // Obtener todas las zonas horarias disponibles
        Set<String> zonasHorariasDisponibles = ZoneId.getAvailableZoneIds();
        TreeSet<String> zonasHorariasOrdenadas = new TreeSet<>(zonasHorariasDisponibles);

        // Mostrar el menú desplegable de zonas horarias
        System.out.println("\nA continuación podrá visualizar la lista de zonas horarias disponibles:");
        System.out.println("\n");

        int opcion = 1;
        for (String zonaHoraria : zonasHorariasOrdenadas) {
            System.out.println(opcion + ". " + zonaHoraria);
            opcion++;
        }

        // Leer la elección del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPor favor seleccione una zona horaria (Ingrese el número): ");
        int seleccion = scanner.nextInt();

        // Validar la selección del usuario
        if (seleccion < 1 || seleccion > zonasHorariasOrdenadas.size()) {
            System.out.println("\nSelección inválida. Ejecute de nuevo el aplicativo e intente con una opción valida. Gracias.");
            return;
        }

        // Obtener la zona horaria seleccionada
        String zonaHorariaSeleccionada = zonasHorariasOrdenadas.toArray()[seleccion - 1].toString();

        // Convertir la hora de Colombia a la zona horaria seleccionada
        ZoneId zonaSeleccionada = ZoneId.of(zonaHorariaSeleccionada);
        ZonedDateTime horaSeleccionada = horaActualColombia.atZone(zonaColombia).withZoneSameInstant(zonaSeleccionada);

        // Mostrar la hora en la zona horaria seleccionada
        System.out.println("\nLa fecha y hora actual en " + zonaHorariaSeleccionada + " es: " + horaSeleccionada.format(formato));
        System.out.println("\nGracias por utilizar nuestro servicio. ¡Hasta pronto!");
    }
}