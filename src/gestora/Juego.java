package gestora;

import java.util.Scanner;

import clases.Carta;
import menus.Menu;
/**
 * La clase Juego, implementa la interfaz Juego, y es utilizada
 * para ejecutar el juego de las 7 y media.
 *  
 * Como propiedades basicas tiene:
 * <ul>
 * 		<li>finPartida: tipo boolean, no consultable, ni modificable</li>
 * </ul>
 * 
 * Propiedades compartidas->LIMITE_JUEGO: tipo double, consultable, no modificable. 
 * Es una constante. Es utilizada para representar la puntuación limite dle juego.
 * Propiedades derivadas: No hay
 * .
 * 
 * Su interfaz es la siguiente:
 * <ul>
 * 		<li> CJuegoImpl() - Constructor por defecto</li>
 * 		<li> play()</li>
 * </ul>
 * 
 * 
 * @author Raul Sanchez Galan
 * @version 1.0
 *
 */
public class Juego {
	//Constantes
	private static final double LIMITE_JUEGO = 7.5;//Puntuación limite dle juego
	
	//Atributos
	private boolean finPartida;//Indica si la partida ha finalizado
	
	
	//Metodos
	
	//Constructor sin parametros
	public Juego() {
		finPartida=false;
	}
	
	
	/**
	 * <b>Precondicion:</b> Ninguna
	 * <b>Postcondicion:</b> Permite jugar al usuario al juego de las 7.5
	 * Dandole al usuario la opcion en cada turno de coger una carta o plantarse.
	 * El juego termina cuando la puntuación de las cartas supera 7.5 o el usuario se
	 * planta. 
	 * 
	 * Entrada: Ninguna
	 * Salida: Ninguna
	 * 
	 * @return devuelve un String con las propiedades de la
	 * carta, siguiendo el siguiente formato: -valor- de -palo-
	 */
	public void play() {
		Scanner teclado=new Scanner(System.in);//Escaner utilizado para leer los datos
		//introducidos por teclado
		String eleccion;
		//TODO añadir un bucle patra preguntar si se desea continuar la partida
		while(!finPartida){//Bucle principal. Mientras no ha finalizado la partida
			eleccion=Menu.eleccionPrincipal(teclado);//El usuario elige una opcion
			switch(eleccion) {
			case "1"-> nuevaCarta();//Opcion de coger una carta nueva
			case "2"-> plantarse();//Opcion de no coger mas cartas y finalizar el juego
			}
		}
		teclado.close();//Cerramos el escaner
	}

	
	//Metodos privados
	
	//opcion de plantarse
	private void plantarse() {
		finPartida=true;//Se da por finalizada la partida
		double total=0;
		Menu.displayMensajePlantarse();//Se informa al usuario de la opcion tomada
		getNextCard();//Se genera una carta, para ver cual habria salido
		total=Carta.consultarTotal();//Se obtiene el total
		if(total>LIMITE_JUEGO) //Se comprueba si la decision era acertada
			Menu.displayMensajeDecisionCorrecta();//Se informa que se ha acertado con la decision,
		//ya que nos habriamos pasado con la siguiente carta
		else
			Menu.displayMensajeDecisionIncorrecta();//Se informa que no se ha acertado con la decision,
		//ya que no nos habriamos pasado.
	}

	//Opcion de coger una nueva carta
	private void nuevaCarta() {
		getNextCard();//Se ve cual es la proxima carta
		double total=Carta.consultarTotal();//Se obtiene el total
		if(total>LIMITE_JUEGO) {//Se comprueba si supera el limite del juego
			finPartida=true;//En caso afirmativo, se da por finalizado el juego
			Menu.displayMensajeHasPerdido();//Y se avisa al usuario
		}
	}

	//Se muestra cual es la proxima carta que se va a mostrar
	private void getNextCard() {
		Carta carta=new Carta();//Se ve cual es la nueva carta
		Menu.displayCarta(carta);//Se muestra al usuario la carta que ha salido
	}
}
