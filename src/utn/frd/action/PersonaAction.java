package utn.frd.action;
import utn.frd.bean.Persona;
import db.PersistentManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.opensymphony.xwork2.ActionSupport;


public class PersonaAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
    private long id;
	private String name;
    private String age;
    private String gender;
    private ArrayList<Persona> personas;
    
    Persona p;

public String execute(){
    personas = PersistentManager.getInstance();
    return SUCCESS;
}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}


	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
		}


	public String save(){
        int edad = 0;
        personas = PersistentManager.getInstance();

        try{ 
            edad = Integer.parseInt(age);
        }catch(Exception e){
            addActionError("Ocurrió un error con la edad");
            return ERROR;
        }
    
        if( id==0 ){
        	p = new Persona(personas.size()+1, name, edad, gender);
        	PersistentManager.getInstance().add(p);

        }else{
        	
        	p = personas.stream().filter(p->p.getId()==id).findFirst().get();
        	p.setName(name);
        	p.setAge(edad);
        	p.setGender(gender);
        
        }
        
        name = "";
        age = "";
        gender = "";

        return SUCCESS;
	}

	public String delete(){
		personas = PersistentManager.getInstance();
		personas.removeIf(p->p.getId()==id);
		return SUCCESS;
}

	public String modify(){
		personas = PersistentManager.getInstance();
		Persona persona = personas.stream().filter(p->p.getId()==id).findFirst().get();
		id = persona.getId();
		name = persona.getName();
		gender = persona.getGender();
		age = String.valueOf(persona.getAge());
		return SUCCESS;
}
	
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id=id;
	}
	
		
}

