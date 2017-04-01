package Utils;

import Dto.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /*        
//recupera a sess]ao atual ou cria uma nova
        HttpSession ses = ((HttpServletRequest) request).getSession(true);
        //recuperamos a pagina atual
        String newCurrentPage = ((HttpServletRequest) request).getServletPath();
        //verifica-se se a pagina já não está gravada na sessão. caso não esteja salvamos ela como ultima pagina e atual
        if (ses.getAttribute("currentPage") == null) {
            ses.setAttribute("lastPage", newCurrentPage);
            ses.setAttribute("currentPage", newCurrentPage);
        } else {
            String oldCurrentPage = ses.getAttribute("currentPage").toString();
            if (!oldCurrentPage.equals(newCurrentPage)) {
                ses.setAttribute("lastPage", oldCurrentPage);
                ses.setAttribute("currentPage", newCurrentPage);
            }
        }
        
chain.doFilter(request, response);
         */
//Verifica se a sessão não expirou, se sim volta para a página de login
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        Usuario user = (Usuario) ((HttpServletRequest) request).getAttribute("usuario");
        //Usuario user1 = (Usuario) SessionContext.getInstance().getAttribute("user");

        if (session == null && (user == null || !user.isLogado())) {
            String contextPath = ((HttpServletRequest) request).getContextPath();
            //Redirecionamos o usuário imediatamente 
            //para a página de login.xhtml
            ((HttpServletResponse) response).sendRedirect(contextPath + "/login/login.xhtml");
        } else {
            //Caso ele esteja logado, apenas deixamos 
            //que o fluxo continue
            chain.doFilter(request, response);
        }
/*
        if (session != null && !session.isNew()) {
            chain.doFilter(request, response);
        } else {
            //Retorna para a página de login
            ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/login.xhtml");
        }*/

    }

    @Override
    public void destroy() {

    }

}
