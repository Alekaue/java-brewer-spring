package com.alekaue.brewer.repository.helper.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alekaue.brewer.model.Usuario;
import com.alekaue.brewer.repository.filter.UsuarioFilter;

public interface UsuariosQueries {
	
	public Optional<Usuario> porEmailEAtivo(String email);
	
	public List<String> permissoes(Usuario usuario);

	public Page<Usuario> filtrar(UsuarioFilter filtro, Pageable pageeable);
	
	public Usuario buscarComGrupos(Long codigo);
}
