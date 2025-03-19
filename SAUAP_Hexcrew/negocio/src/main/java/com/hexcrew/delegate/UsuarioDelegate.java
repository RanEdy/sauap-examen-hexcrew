package com.hexcrew.delegate;

import com.hexcrew.dao.AdministradorDAO;
import com.hexcrew.dao.UsuarioDAO;
import com.hexcrew.entidad.Administrador;
import com.hexcrew.entidad.Usuario;
import com.hexcrew.persistencia.ServiceLocator;
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
    ServiceLocator locator;

    
    @Override
    public Usuario guardar(Usuario u)
    {
        //return dao.save(u);
        return locator.getUsuarioDAOInstance().save(u);
    }
    
    @Override
    public Usuario editar(Usuario u)
    {
        //return dao.update(u);
        return locator.getUsuarioDAOInstance().update(u);
    }
    
    @Override
    public List<Usuario> listar()
    {
        //return dao.findAll();
        return locator.getUsuarioDAOInstance().findAll();
    }

    @Override
    public Usuario buscar(Integer id) {
        //return dao.find(id);
        return locator.getUsuarioDAOInstance().find(id);
    }

    @Override
    public void eliminar(Usuario u) {
        //dao.delete(u);
        locator.getUsuarioDAOInstance().delete(u);
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
