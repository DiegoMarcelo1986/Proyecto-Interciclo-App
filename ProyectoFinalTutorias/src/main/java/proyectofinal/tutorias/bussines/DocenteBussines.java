package proyectofinal.tutorias.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import proyectofinal.tutorias.dao.DocenteDao;
import proyectofinal.tutorias.modelo.Docente;

@Stateless
public class DocenteBussines {

	@Inject
	private DocenteDao Ddao;
	
	public boolean save(Docente docente) throws Exception {
		Docente aux= Ddao.read(docente.getId());
		if(aux!=null)
			throw new Exception("Docente ya existe");
		else
			Ddao.insert(docente);
		return true;
		
	}
	
	public List<Docente>getListadoDocente(){
		return Ddao.getDocentes();
	}
	
	public void eliminar(int id)throws Exception {
		Docente aux= Ddao.read(id);
		if(aux==null)
			throw new Exception("Docente no existe");
		else
			Ddao.remove(id);
	}
	
	public void actualizar(Docente docente)throws Exception {
		Docente aux= Ddao.read(docente.getId());
		if(aux==null)
			throw new Exception("Docente no existe");
		else
			Ddao.update(docente);
	}
	
}
