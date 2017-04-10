/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dto.Usuario;
import Utils.SessionContext;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author breno.arantes
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private String login;
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LoginController() {
    }

    public String AcessarSistema() {
        Usuario user = new Usuario(login, senha);
        if (!login.equals("breno") && !senha.equals("123")) {
            return "Retornar";
        }
        user.setLogado(true);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
        SessionContext.getInstance().setAttibute("usuario", user);
        return "Logar";
    }

}
