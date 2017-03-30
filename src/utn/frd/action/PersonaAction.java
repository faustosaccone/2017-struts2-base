package utn.frd.action;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;
import db.PersistentManager;
import utn.frd.bean.Persona;

public class PersonaAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String age;
	private String gender;
	public ArrayList<Persona> personas;
	
	
	public String save(){
		personas = PersistentManager.getInstance();
		int edad = 0;

		try{
			edad = Integer.parseInt(age);
		}catch(Exception e){
			addActionError("Ocurrió un error con la edad");
			return ERROR;
		}

		new Persona(personas.size(), name, edad, gender);
		
		return SUCCESS;
	}

}
