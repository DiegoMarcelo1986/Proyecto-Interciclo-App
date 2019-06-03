package proyectofinal.tutorias.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import proyectofinal.tutorias.bussines.DocenteBussines;
import proyectofinal.tutorias.modelo.Docente;

@ManagedBean
public class DocenteBean {

	@Inject
	private DocenteBussines db;
	
	@Inject
	private FacesContext facesContext;
	
	private Docente newDocente;
	
	private List<Docente>docentes;
	
	private boolean editar;
	
	private String email;
	private String clave;
	
	@PostConstruct
	
	public void init() {
		
		newDocente = new Docente();
		editar=false;
		docentes = db.getListadoDocente();
		System.out.println("clientes");
	}

	public DocenteBussines getDb() {
		return db;
	}

	public void setDb(DocenteBussines db) {
		this.db = db;
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public Docente getNewDocente() {
		return newDocente;
	}

	public void setNewDocente(Docente newDocente) {
		this.newDocente = newDocente;
	}

	public List<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
public String guardar() {
	
	
	try {
		if(editar) {
			System.out.println("Editando");
			db.actualizar(newDocente);
		}else {
			db.save(newDocente);
			System.out.println("Registro Guardado");
			return "listar-docente?faces-redirect=true";
		}
	}catch(Exception e) {
		System.out.println("Error al guardar");
		e.printStackTrace();
		
		
		FacesMessage m= new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
		facesContext.addMessage(null, m);
	}
	return null;
}
	public String eliminar(int id) {
		
		try {
			
			db.eliminar(id);
			System.out.println("Registro eliminado");
			return "listar-docente?faces-redirect=true";
			
		}catch(Exception e) {
			System.out.println("Error al eliminar");
			e.printStackTrace();
			FacesMessage m= new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);	
			
		}
		
		return null;
	}
	
	
	public String ediatar(Docente docente) {
		editar=true;
		System.out.println(docente);
		newDocente=docente;
		return "ingreso-docente.xhtml";
	}
	
	
}
