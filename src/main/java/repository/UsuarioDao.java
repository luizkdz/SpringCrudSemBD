package repository;

import java.util.List;

import com.example.CrudSemBD.Usuario;

public interface UsuarioDao {
	public void adicionarUsuario(Usuario usuario);
		
	
	public void excluirUsuario(Long Id);
		
	public void editarUsuario(Usuario usuario);
	
	public List<Usuario> getTodos();
	
	
	public Usuario getId(Long id);
		
}
