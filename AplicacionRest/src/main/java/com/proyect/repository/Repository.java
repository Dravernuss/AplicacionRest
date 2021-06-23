package com.proyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyect.entity.Usuario;

@org.springframework.stereotype.Repository("repositorio")
public interface Repository extends JpaRepository<Usuario, Long> {

}
