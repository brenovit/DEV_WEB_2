package Utils;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

//Singleton para a sessão
public class SessionContext {

    private static SessionContext instance = null;

    public static SessionContext getInstance() {
        if (instance == null) {
            instance = new SessionContext();
        }
        return instance;
    }

    private SessionContext() {    
    }

    private ExternalContext currentExternalContext() {
        System.out.println("SessionContext : currentExternalContext");
        if (FacesContext.getCurrentInstance() == null) {
            throw new RuntimeException("O FacesContext não pode ser chamado fora de uma requisição HTTP");
        } else {
            return FacesContext.getCurrentInstance().getExternalContext();
        }
    }

    public void encerraSessao() {
        System.out.println("Utils.SessionContext.encerraSessao()");
        currentExternalContext().invalidateSession();
    }

    public Object getAttribute(String name) {
        System.out.println("Utils.SessionContext.getAttribute()");
        return currentExternalContext().getSessionMap().get(name);
    }

    public void setAttibute(String name, Object value) {
        System.out.println("Utils.SessionContext.setAttibute()");
        currentExternalContext().getSessionMap().put(name, value);
    }
}
