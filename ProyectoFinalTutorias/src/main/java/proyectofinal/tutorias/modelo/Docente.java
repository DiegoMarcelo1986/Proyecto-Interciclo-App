package proyectofinal.tutorias.modelo;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@ManagedBean
@Entity
public class Docente {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="doc_id")
	private int id;
	@Column(name="doc_cedula")
	@Size(min = 10, max = 10)
	private String cedula;
	@Column(name="doc_nombre")
	private String nombre;
	@Column(name="doc_apellido")
	private String apellido;
	@Column(name="doc_especialidad")
	private String especialidad;
	@Column(name="doc_telefono")
	private String telefono;
	@Column(name="doc_email")
	private String email;
	@Column(name="doc_contraseña")
	private String contraseña;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	
	
}
