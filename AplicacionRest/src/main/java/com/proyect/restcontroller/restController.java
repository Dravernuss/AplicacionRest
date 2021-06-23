package com.proyect.restcontroller;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.entity.Usuario;
import com.proyect.service.impl.ServiceImpl;

@RestController
@RequestMapping("/usuarios")
public class restController {
	
	private static final Log LOGGER = LogFactory.getLog(restController.class);
	
	@Autowired
	@Qualifier("Servicio")
	private ServiceImpl serv;
	
	@GetMapping("/lista")
	public List<Usuario> listUser(){
		LOGGER.info("Metodo: 'listUser' -- Mostrando Lista de Usuarios");
		List<Usuario> usuarios =  serv.listUsers();
		return usuarios;
	}

	@GetMapping("/buscarUsuario/{id}")
	public Optional<Usuario> findbyId(@PathVariable long id){
		LOGGER.info("Metodo: 'findbyId' -- Buscando Usuario por el id: '"+id+"'");
		Optional<Usuario> usuario = serv.findbyId(id);
		return usuario;
	}
	
	@PostMapping("/agregarUsuario")
	public Usuario addUser(@RequestBody Usuario user) {
		if (user.getNombres() != "" && user.getApellidos() != "" && user.getCelular() != "" && user.getPassword() !="") {
			LOGGER.info("Metodo: 'addUser' -- Usuario agregado: '"+user.toString()+"'");
			Usuario adduser = serv.addUser(user);
			return adduser;
		} else {
			LOGGER.error("Los datos no son válidos");
		}
		return null;
	}
	
	@PutMapping("/editarUsuario")
	public Usuario editUser(@RequestBody Usuario user) {
		if (user.getNombres() != "" && user.getApellidos() != "" && user.getCelular() != "" && user.getPassword() !="") {
		 LOGGER.info("Metodo: 'editUser' -- Parametros Editados: '"+user.toString()+"'");	
		 Usuario edituser = serv.editUser(user);
		 return edituser;
		}else {
			LOGGER.error("Los datos no son válidos");
		}
		return null;
	}
	
	@DeleteMapping("eliminarUsuario/{id}")
	public String deleteUserById(@PathVariable long id) {
		LOGGER.info("Metodo: 'deleteUserById' -- Usuario Eliminado de id: '"+id+"'");
		String delete = serv.DeleteUserById(id);
		return delete;
	}
}
