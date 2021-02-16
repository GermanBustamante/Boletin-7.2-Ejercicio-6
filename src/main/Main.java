package main;


import gestora.Juego;

public class Main {
	public static void main(String[] args) {
		Juego sieteYMedia=new Juego();//Creamos un objeto de la clase Juego.
		//El cual va a actuar como controlador, o gestor.
		sieteYMedia.play();//Llamamos al metodo play para iniciar el juego.
	}
}
