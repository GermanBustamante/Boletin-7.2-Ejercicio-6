package clases;

import java.util.Random;

import enumerados.Palo;
import enumerados.Valor;

/**
 * La clase Carta es utilizada
 * para representar una carta de una baraja española.
 *  
 * Como propiedades basicas tiene:
 * <ul>
 * 		<li>palo: tipo Palo, no consultable, ni modificable</li>
 * 		<li>valor: tipo Valor, no consultable, ni modificable</li>
 * </ul>
 * 
 * Propiedades compartidas->sumaTotal: tipo int, consultable (con el metodo consultarTotal), no modificable
 * Propiedades derivadas: No hay
 * 
 * Restricciones: sumaTotal debe reflejar el sumatorio de las cartas
 * instanciadas, teniendo en cuenta que las figuras suman 0.5, y el resto 
 * el numero de la carta (como indica el reglamento de las siete y media).
 * 
 * Su interfaz es la siguiente:
 * <ul>
 * 		<li> Constructor sin parametros</li>
 * 		<li> consultarTotal()</li>
 * 		<li> Sobrescribir el metodo toString()</li>
 * </ul>
 * 
 * 
 * @author Raul Sanchez Galan
 * @version 1.0
 *
 */
public class Carta{

	//Atributos
	private Palo palo;
	private Valor valor;
	private static double sumaTotal;//Almacena el sumatorio del valor
	// de las cartas creadas. Su valor inicial es cero.


	/**
	 * <b>Precondicion:</b> Ninguna
	 * <b>Postcondicion:</b> Se instancia un objeto CartaImpl, con sus atributos
	 * generados de forma aleatoria, y se actualiza el valor estatico sumaTotal.
	 * Se pueden repetir cartas. 
	 *  
	 */
	public Carta() {
		Random r = new Random();
		int paloRandom = r.nextInt(4);//Genero un numero entre 0 y 3 (incluidos ambos)
		int valorRandom = r.nextInt(10) ;//Genero un numero entre 0 y 9 (incluidos ambos)
		setValor(valorRandom);//Metodo privado para darle un valor a la carta
		//a partir de un int
		setPalo(paloRandom);//Metodo privado para darle un palo a la carta
		//a partir de un int
	}



	/**
	 * <b>Precondicion:</b> Ninguna
	 * <b>Postcondicion:</b> Devolver un String con las propiedades de la
	 * carta, siguiendo el siguiente formato: -valor- de -palo-. 
	 * 
	 * Entrada: Ninguna
	 * Salida: String
	 * 
	 * @return devuelve un String con las propiedades de la
	 * carta, siguiendo el siguiente formato: -valor- de -palo-
	 */
	@Override
	public String toString() {
		return valor.toString()+" de "+palo.toString();
	}

	/**
	 * <b>Precondicion:</b> Ninguna
	 * <b>Postcondicion:</b> Devuelve el valor del atributo sumaTotal.
	 * sumaTotal debe ser igual al total acumulado de los valores de todas las cartas
	 * generadas, teniendo en cuenta que las figuras tienen como valor 0.5
	 * 
	 *  NOTA: El metodo se podria haber denominado getSumaTotal()
	 * 
	 * Entrada: Ninguna
	 * Salida: valor del atributo sumaTotal
	 * 
	 * @return devuelve el valor del atributo sumaTotal
	 */
	public static double consultarTotal() {
		return sumaTotal;
	}


	//Metodos privados

	//Metodo utilizado para setear el valor del palo, en funcion de un
	//entero. 
	private void setPalo(int palo) {
		switch(palo) {
		case 0-> this.palo=Palo.BASTOS;
		case 1-> this.palo=Palo.COPAS;
		case 2-> this.palo=Palo.OROS;
		case 3-> this.palo=Palo.ESPADA;
		}
	}


	//Metodo utilizado para setear el valor del valor de la carta, en funcion de un
	//entero, y actualizar el valor de la sumaTotal de las cartas generadas 
	private void setValor(int valor) {
		switch(valor) {
		case 0-> {this.valor=Valor.UNO;}
		case 1-> {this.valor=Valor.DOS;}
		case 2-> {this.valor=Valor.TRES;}
		case 3-> {this.valor=Valor.CUATRO;}
		case 4-> {this.valor=Valor.CINCO;}
		case 5-> {this.valor=Valor.SEIS;}
		case 6-> {this.valor=Valor.SIETE;}
		case 7-> {this.valor=Valor.SOTA;}
		case 8-> {this.valor=Valor.CABALLO;}
		case 9-> {this.valor=Valor.REY;}
		}
		sumaTotal+=this.valor.getValorEnum();
	}





}
