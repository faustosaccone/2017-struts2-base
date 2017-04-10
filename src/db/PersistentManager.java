package db;
import java.util.ArrayList;
import utn.frd.bean.Persona;

public class PersistentManager {
	
	private static ArrayList<Persona> personas = new ArrayList<Persona>();
	
	public static ArrayList<Persona> getInstance(){
		return personas;
		
	}

}
