package Controller;

import Dto.DtoUsuario;
import Model.UsuarioDao;
import java.sql.SQLException;
import java.util.List;

public class UsuarioFaces {

    private List<DtoUsuario> listaUsuarios = null;
    private UsuarioDao usuarioDao = new UsuarioDao();
    private DtoUsuario dto;

    public UsuarioFaces() {
    }

    public List<DtoUsuario> getListaUsuarios() throws ClassNotFoundException, SQLException {
        if (listaUsuarios == null) {
            listaUsuarios = usuarioDao.getRetornaTodos();
        }
        return listaUsuarios;
    }

    public void setListaUsuarios(List<DtoUsuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public DtoUsuario getDto() {
        return dto;
    }

    public void setDto(DtoUsuario dto) {
        this.dto = dto;
    }

    public String PreparaInclusao() {
        this.dto = new DtoUsuario();
        return "Incluir";
    }

    public String IncluirUsuario() throws ClassNotFoundException, SQLException {
        if (usuarioDao.setAdicionar(dto)) {
            this.listaUsuarios = null;
            this.dto = null;
        }
        return "VoltarListagem";
    }

    public String AlterarUsuario() throws ClassNotFoundException, SQLException {
        if (usuarioDao.setAlterar(this.getDto())) {
            this.listaUsuarios = null;
        }
        return "Alterar";
    }

    public String DeletarUsuario() throws ClassNotFoundException, SQLException {
        if (usuarioDao.setDeletar(dto)) {
            this.listaUsuarios = null;
        }
        return "Excluir";
    }
}
