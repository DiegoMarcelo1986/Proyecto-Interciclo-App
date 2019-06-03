package proyectofinal.tutorias.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import proyectofinal.tutorias.modelo.Docente;

@Stateless
public class DocenteDao {

	@Inject
	private EntityManager em;
	
	public void insert(Docente docente) {
		em.persist(docente);
	}
	
	public void update(Docente docente) {
		em.merge(docente);
	}
	
	public void remove(int id) {
		em.remove(this.read(id));	
	}
	
	public Docente read(int id) {
		Docente docente = em.find(Docente.class,id);
		return docente;
	}
	
	public List<Docente> getDocentes(){
		String jpql = "SELECT d FROM Docente d";
		Query query = em.createQuery(jpql, Docente.class);
		List<Docente>listadoDoc=query.getResultList();
		return listadoDoc;
	}
}
