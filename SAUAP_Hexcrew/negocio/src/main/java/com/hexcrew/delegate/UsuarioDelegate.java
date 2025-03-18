package com.hexcrew.delegate;

import com.hexcrew.dao.AdministradorDAO;
import com.hexcrew.dao.UsuarioDAO;
import com.hexcrew.entidad.Administrador;
import com.hexcrew.entidad.Usuario;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Stateless
public class UsuarioDelegate implements IUsuarioDelegate
{
    @EJB
    UsuarioDAO dao;
    @EJB
    AdministradorDAO daoAdmin;
    
    public Usuario guardar(Usuario u)
    {
        return dao.save(u);
    }
    
    public Usuario editar(Usuario u)
    {
        return dao.update(u);
    }
    
    public List<Usuario> listar()
    {
        return dao.findAll();
    }

    @Override
    public Usuario buscar(Integer id) {
        return dao.find(id);
    }

    @Override
    public void eliminar(Usuario u) {
        dao.delete(u);
    }
    
//    @Override
//    public Usuario obtenerUsuarioLogin(String email, String password)
//    {
//        List<Usuario> usuarios = dao.usuariosLogin(email, password);
//        
//        if(!usuarios.isEmpty() ){
//            if(daoAdmin.AdministradoresLogin(usuarios.get(0).getIdUsuario()).isEmpty()){
//                return usuarios.get(0);
//            }
//        return null;
//        }
//        return null;
//    }
}
