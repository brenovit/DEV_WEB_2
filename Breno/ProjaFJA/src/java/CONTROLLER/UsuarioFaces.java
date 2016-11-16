
package CONTROLLER;

import DTO.DtoUsuario;
import MODEL.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;


public class UsuarioFaces {
    private List<DtoUsuario> usuarios;
    private UsuarioDAO userDao = new UsuarioDAO();

    public UsuarioFaces() {
    }
    
    public List<DtoUsuario> getUsuarios() throws ClassNotFoundException, SQLException{
        usuarios = userDao.getRetornaTodos();
        return usuarios;
    }
}
