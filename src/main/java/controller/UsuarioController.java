package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.CrudSemBD.Usuario;

import repository.UsuarioDaoImplement;

@Controller
@RequestMapping(value = "/", method =RequestMethod.GET )
public class UsuarioController {

	@Autowired
	UsuarioDaoImplement u;
	
	@GetMapping(value = "/todos")
	public String retornaTodos(Model model) {
		model.addAttribute("usuarios", u.getTodos());
		return "listaUsuario";
	}
	
	@GetMapping(value = "/{id}")
	public Model retornaPorId(@PathVariable long id, Model model) {
		Usuario usuario = u.getId(id);
		model.addAttribute("usuarios", usuario);
		return model;
	}

	@PostMapping(value = "/cadastrar")
	public String cadastraUsuario(@ModelAttribute Usuario usuario, RedirectAttributes attr) {
			u.adicionarUsuario(usuario);
			attr.addFlashAttribute("mensagem", "O usuario foi cadastrado com sucesso");
			return "redirect:/todos";
			}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deletaUsuario(@PathVariable long id, Usuario usuario, RedirectAttributes attr) {
		u.excluirUsuario(id);
		attr.addFlashAttribute("mensagem", "O usuario foi deletado com sucesso");
		return "redirect:/todos";
	}
	@GetMapping(value = "/update/{id}")
	public ModelAndView preUpdate(@PathVariable long id, ModelMap model) {
		Usuario usuario = u.getId(id);
		model.addAttribute("usuarios", usuario);
		return new ModelAndView("paginasWeb/cadastraUsuario", model);
		
	}
	@PostMapping(value = "/update")
	public ModelAndView update(@ModelAttribute Usuario usuario, RedirectAttributes attr) {
		u.editarUsuario(usuario);
		attr.addFlashAttribute("mensagem", "O usuario foi alterado com sucesso");
		return new ModelAndView("redirect:/paginasWeb/listaUsuario");
	}
	
	
}