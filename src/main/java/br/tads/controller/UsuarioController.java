package br.tads.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.tads.bean.Usuario;
import br.tads.dao.UsuarioDAO;


@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDAO dao;
	
	@RequestMapping("/usuario")
	public String salvar(Usuario usuario) {
		dao.salva(usuario);
		return "redirect:/lista_usuario";
	}

	@RequestMapping("/novo_usuario")
	public String novoUsuario() {
		return "novoUsuario";
	}
	
	@RequestMapping("/lista_usuario")
	public ModelAndView listaUsuario() {
		ModelAndView modelAndView = new ModelAndView("listaUsuario");
		modelAndView.addObject("usuarios", dao.listar());
		return modelAndView;
	}
	
	@RequestMapping("/usuario/remover")
	public String excluirUsuario(int id) {
		dao.remover(id);
		return "redirect:/lista_usuario";
	}
	
	@RequestMapping("/usuario/atualizar")
	public String atualizar(Usuario usuario) {
		dao.update(usuario);
		return "redirect:/lista_usuario";
	}
	
	@RequestMapping("/usuario/editar")
	public ModelAndView editar(int cod) {
		ModelAndView andView = new ModelAndView("atualizarUsuario");
		andView.addObject("usuario", dao.busca(cod));
		return andView;
	}
}
