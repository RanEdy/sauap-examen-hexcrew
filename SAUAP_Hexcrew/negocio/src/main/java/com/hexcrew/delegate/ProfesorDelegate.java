package com.hexcrew.delegate;

import com.hexcrew.dao.AdministradorDAO;
import com.hexcrew.dao.ProfesorDAO;
import com.hexcrew.dao.UsuarioDAO;
import com.hexcrew.entidad.Administrador;
import com.hexcrew.entidad.Profesor;
import com.hexcrew.entidad.UnidadAprendizaje;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel
 * Villagomez
 */
@Stateless
public class ProfesorDelegate implements IProfesorDelegate {

    @EJB
    private ProfesorDAO dao;

    @EJB
    private AdministradorDAO admindao;

    @EJB
    private UsuarioDAO usuariodao;

    @Override
    public List<Profesor> listar() {
        return dao.findAll();
    }

    @Override
    public boolean eliminar(Profesor p) {
        //Validar que no tenga unidades asignadas
        Set<UnidadAprendizaje> Asignaciones = p.getUnidades();

        if (Asignaciones.isEmpty()) {
            dao.delete(p);
            
            List<Administrador> administradores = admindao.findAll();
            for (Administrador admin : administradores) {
                if (!admin.getIdUsuario().equals(p.getIdUsuario())) {
                    usuariodao.delete(p.getUsuario());
                    break;
                }
            }
            return true;
        }

        return false;

    }

    @Override
    public Profesor registrar(Profesor p) {
        List<Profesor> profesores = dao.findAll();
        for (Profesor profe : profesores) {
            if (profe.getNumProfesor().equals(p.getNumProfesor())) {
                return null;
            }
        }
        return dao.save(p);
    }

    @Override
    public Profesor editar(Profesor p) {
        return dao.update(p);
    }

    @Override
    public Profesor buscar(Integer id) {
        return dao.find(id);
    }

}
