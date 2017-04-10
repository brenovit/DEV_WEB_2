/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dto.Usuario;
import Utils.SessionContext;
import java.io.Serializable;

public class LoginController implements Serializable {

    private String login;
    private String senha;
    private Usuario user;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

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

    public String acessarSistema() {       
        if (!login.equals("breno") || !senha.equals("123")) {
            return "Retornar";
        } else {
            user = new Usuario(login, senha,"Breno nunes Arantes");
            user.setLogado(true);            
            SessionContext.getInstance().setAttibute("user", user);
            return "Logar";
        }
    }
    
    public String sairSistema(){
        SessionContext.getInstance().setAttibute("user", null);
        user.setLogado(false);
        return "login";
    }
}
