package com.alekaue.brewer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alekaue.brewer.model.Usuario;
import com.alekaue.brewer.repository.helper.usuario.UsuariosQueries;

public interface Usuarios extends JpaRepository<Usuario, Long>, UsuariosQueries{
	
	public Optional<Usuario> findByEmailOrCodigo (String email, Long codigo);

	public List<Usuario> findByCodigoIn(Long[] codigos);

}
