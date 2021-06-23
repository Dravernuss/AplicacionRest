package com.proyect.service;

import java.util.List;
import java.util.Optional;

import com.proyect.entity.Usuario;

public interface ServiceInterface {
	
	public List<Usuario> listUsers();
	
	public Optional<Usuario> findbyId(long id);
	
	public Usuario addUser(Usuario user);
	
	public Usuario editUser(Usuario user);
	
	public String DeleteUserById(long id);
}
