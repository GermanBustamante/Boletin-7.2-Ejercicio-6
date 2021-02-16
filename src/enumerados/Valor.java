package enumerados;

/**
 * El enunmerado Valor, es utilizado para representar los diferentes tipos de numeros
 * de una baraja española. Se ha añadido un atributo denominado valor, para representar
 * el valor de dicha carta en el juego de las 7 y media.
 * 
 * @author Raul
 * @version 1.0
 *
 */

public enum Valor {
	//Listado de enumerados
	UNO(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), SOTA(0.5), CABALLO(0.5), REY(0.5);
	
	//Atributo utilziado para alamacenar el valor de cada numero dentro del juego de las
	//7 y media
	private double valorParaSienetYMedia;

	//Constructor privado con parametros
    private Valor(double valor) {
        this.valorParaSienetYMedia = valor;
    }

	/**
	 * <b>Precondicion:</b> Ninguna
	 * <b>Postcondicion:</b> Devuelve el valor establecido para el enumerado en
	 * el juego de las siete y media, siendo 0.5 para las figuras (sota, caballo y rey),
	 * e igual al numero para el resto de valores. 
	 * 
	 * Entrada: Ninguna
	 * Salida: double
	 * 
	 * @return devuelve un double que representa el valor del enumerado dentro del
	 * juego de las 7 y media. El valor será 0.5 para las figuras, e igual al valor 
	 * del enumerado para el resto de casos.
	 */
    public double getValorEnum() {
        return valorParaSienetYMedia;
    }
}
