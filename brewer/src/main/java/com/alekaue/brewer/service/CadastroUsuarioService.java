package com.alekaue.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alekaue.brewer.model.Usuario;
import com.alekaue.brewer.repository.Usuarios;
import com.alekaue.brewer.service.exception.EmailUsuarioJaCadastradoException;
import com.alekaue.brewer.service.exception.SenhaObrigatoriaUsuarioException;

@Service
public class CadastroUsuarioService {

	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	public void salvar(Usuario usuario) {

		//Optional<Usuario> usuarioExistente = usuarios.findByEmail(usuario.getEmail());
		Optional<Usuario> usuarioExistente = usuarios.findByEmailOrCodigo(usuario.getEmail(), usuario.getCodigo());
		if (usuarioExistente.isPresent() && !usuarioExistente.get().equals(usuario)) {
			throw new EmailUsuarioJaCadastradoException("Email já cadastrado");
		}
		
		if(usuario.isNovo() && StringUtils.isEmpty(usuario.getSenha())){
			throw new SenhaObrigatoriaUsuarioException("Senha é obrigatória para novo usuário");
		}
		
		if(usuario.isNovo() || !StringUtils.isEmpty(usuario.getSenha())){
			usuario.setSenha(this.passwordEncoder.encode(usuario.getSenha()));
		} else if(StringUtils.isEmpty(usuario.getSenha())){
			usuario.setSenha(usuarioExistente.get().getSenha());			
		}
		usuario.setConfirmacaoSenha(usuario.getSenha());
		
		if(!usuario.isNovo() && usuario.getAtivo() == null){
			usuario.setAtivo(usuarioExistente.get().getAtivo());
		}
		

		usuarios.save(usuario);

	}
	
	@Transactional
	public void alterarStatus(Long[] codigos, StatusUsuario statusUsuario) {
		statusUsuario.executar(codigos, usuarios);				 
		
	}

}
