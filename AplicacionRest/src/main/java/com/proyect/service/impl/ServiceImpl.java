package com.proyect.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyect.entity.Usuario;
import com.proyect.repository.Repository;
import com.proyect.service.ServiceInterface;

@Service("Servicio")
public class ServiceImpl implements ServiceInterface{

	@Autowired
	@Qualifier("repositorio")
	private Repository repo;
	
	@Override
	public List<Usuario> listUsers() {
		List<Usuario> lista = repo.findAll();
		return lista;
	}

	@Override
	public Optional<Usuario> findbyId(long id) {
		Optional<Usuario> user = repo.findById(id);
		return user;
	}

	@Override
	public Usuario addUser(Usuario user) {
		Usuario addUser = repo.save(user);
		return addUser;
	}

	@Override
	public Usuario editUser(Usuario user) {
		Usuario editUser = repo.findById(user.getId()).orElse(null);
		editUser.setNombres(user.getNombres());
		editUser.setApellidos(user.getApellidos());
		editUser.setCelular(user.getCelular());
		editUser.setPassword(user.getPassword());
		repo.save(editUser);
		return editUser;
	}

	@Override
	public String DeleteUserById(long id) {
		Usuario usuario = repo.findById(id).orElse(null);
		repo.delete(usuario);
		return "Se ha eliminado al usuario: " + usuario.getNombres()+" con éxito";
	}

}
