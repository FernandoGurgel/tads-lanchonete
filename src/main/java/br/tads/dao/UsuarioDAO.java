package br.tads.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.tads.bean.Usuario;

@Repository
@Transactional
public class UsuarioDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void salva(Usuario usuario) {
		manager.persist(usuario);
	}

	public List<Usuario> listar() {
		return manager.createQuery("select u from Usuario u",Usuario.class).getResultList();
	}

	public boolean remover(int cod) {
		boolean result = ( manager.createQuery("delete from Usuario where cod=?").setParameter(1, cod).executeUpdate() > 1 ? false : true); 
		return 	result;
	}

	public Usuario busca(int cod) {
		return manager.find(Usuario.class, cod);
	}

	public void update(Usuario usuario) {
		manager.merge(usuario);
	}

}
