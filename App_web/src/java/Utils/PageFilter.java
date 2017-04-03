package Utils;

import Dto.Usuario;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        System.out.println("============== Utils.PageFilter.doFilter()");
        //Verifica se a sessão não expirou, se sim volta para a página de login
        /*HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario user = (Usuario) ((HttpServletRequest) request).getAttribute("usuario");
        String ultimoAcesso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(new Date(session.getLastAccessedTime()));
        System.out.println("Filtrando em: " + ultimoAcesso);
        //Usuario user1 = (Usuario) SessionContext.getInstance().getAttribute("user");
        String contextPath = ((HttpServletRequest) request).getContextPath();
        System.out.println("contextPath: " + contextPath);

        if (user == null) {
            System.out.println("Usuario nulo.");
            //Redirecionamos o usuário imediatamente para a página login.xhtml
            ((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");
        } else {
            System.out.println("Usuario: " + user.getNome());
            chain.doFilter(request, response);
        }*/
        //Caso ele esteja logado, apenas deixamos que o fluxo continue     
        chain.doFilter(request, response);
        System.out.println("============== Utils.PageFilter.doFilter()");

    }

    @Override
    public void destroy() {

    }
}
