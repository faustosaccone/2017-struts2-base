package utn.frd.bean;

public class Persona {
	private long id;
	private String name;
	private int age;
	private String gender;
	private int casa;
	
	public Persona(int identificador, String nombre, int edad, String genero){
		id = identificador;
		name = nombre;
		age = edad;
		gender = genero;
	}
	
	public static void main(String[] args) {
		
	}

}

