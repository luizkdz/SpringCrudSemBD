package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.CrudSemBD.Usuario;

@Repository
public class UsuarioDaoImplement implements UsuarioDao {
	private static List<Usuario> lista;
	
	
	public UsuarioDaoImplement() {
		
	}
	
	public List<Usuario> createListUsers() {
		if(lista == null) {
			lista.add(new Usuario(System.currentTimeMillis() + 1L,"Luiz", 30,"luizgrfc@gmail.com"));
			lista.add(new Usuario(System.currentTimeMillis() + 2L,"Marcos", 20,"FelipeMarcos@gmail.com"));
			lista.add(new Usuario(System.currentTimeMillis() + 3L,"Felipe", 25,"marcosFelipe@hotmail.com"));
		}
		return lista;
	}
	
	public void adicionarUsuario(Usuario usuario) {
		usuario.setId(System.currentTimeMillis());
		lista.add(usuario);
	}
	
	public void excluirUsuario(Long id) {
		lista.removeIf((u) -> u.getId().equals(id));
	}
	
	public void editarUsuario(Usuario usuario) {
		lista.stream().filter((u) -> u.getId().equals(usuario.getId())).forEach((u) -> { 
			u.setNome(usuario.getNome());
		u.setIdade(usuario.getIdade());
		u.setEmail(usuario.getEmail());
		});
	}
	
	
	public List<Usuario> getTodos(){
		return lista;
	}
	
	
	public Usuario getId(Long id) {
	    return lista.stream()
	                .filter(u -> Long.valueOf(u.getId()).equals(id))
	                .findFirst()
	                .orElse(null);
	}
		
	
	
	
	
}
