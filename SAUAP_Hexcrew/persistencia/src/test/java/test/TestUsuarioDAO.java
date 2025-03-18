/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */
import com.hexcrew.dao.UsuarioDAO;
import com.hexcrew.entidad.Usuario;

public class TestUsuarioDAO
{
    public static void main(String[] args)
    {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.find(0);
        System.out.println(usuario);
    }
}
