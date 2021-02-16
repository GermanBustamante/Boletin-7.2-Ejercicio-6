package menus;


import java.util.Scanner;

import clases.Carta;

public class Menu {

	private static final String TOTAL = "TOTAL = ";
	private static final String MENSAJE_PLANTARSE = "Has seleccionado plantarte. La carta que habría salido habría sido: ";
	private static final String MENSAJE_DECISION_CORRECTA = "Has ganado!! Acertaste con la decisión";
	private static final String MENSAJE_DECISION_INCORRECTA = "Has perdido!! No acertaste con la decisión";
	private static final String MENSAJE_ELECCION = ""
			+ "***************\r\n"
			+ "1 - Nueva Carta \r\n"
			+ "2 - Me planto \r\n"
			+ "***************\r\n"
			+ "¿Que opcion desea realizar? :";
	private static final String MENSAJE_ELECCION_SEGUNDA_VEZ= "Seleccion incorrecta. Por favor, seleccione un valor entre 1 y 2";
	private static final String MENSAJE_HAS_PERDIDO = "Has perdido!!";

	public static void displayCarta(Carta carta) {
		System.out.println(carta);
		System.out.println(TOTAL+Carta.consultarTotal());
	}

	public static String eleccionPrincipal(Scanner teclado) {
		String eleccion;
		displayMensajeEleccion();
		eleccion=teclado.nextLine();
		while(!validaEleccion(eleccion)) {
			displayMensajeEleccionSegundaVez();
			eleccion=teclado.nextLine();
		}
		System.out.println();
		return eleccion;
	}

	public static void displayMensajePlantarse() {
		System.out.println(MENSAJE_PLANTARSE);	
	}

	public static void displayMensajeDecisionCorrecta() {
		System.out.println(MENSAJE_DECISION_CORRECTA);
	}
	
	public static void displayMensajeDecisionIncorrecta() {
		System.out.println(MENSAJE_DECISION_INCORRECTA);
	}
	
	private static void displayMensajeEleccionSegundaVez() {
		System.out.println(MENSAJE_ELECCION_SEGUNDA_VEZ);
	}

	private static boolean validaEleccion(String eleccion) {
		return eleccion.equals("1") || eleccion.equals("2");
		
	}

	private static void displayMensajeEleccion() {
		System.out.print(MENSAJE_ELECCION);
	}

	public static void displayMensajeHasPerdido() {
		System.out.println(MENSAJE_HAS_PERDIDO);
	}

}
