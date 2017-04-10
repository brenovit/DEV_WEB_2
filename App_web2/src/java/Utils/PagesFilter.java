/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Dto.Usuario;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
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

/**
 *
 * @author breno.arantes
 */
public class PagesFilter implements Filter {
    
    private static final boolean debug = true;
    private static int count = 0;
    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public PagesFilter() {
    }    
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("PagesFilter:DoBeforeProcessing");
        }
        
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        //Verifica se a sessão não expirou, se sim volta para a página de login
        HttpSession session = httpRequest.getSession(false);
        
        Usuario user = (Usuario) httpRequest.getAttribute("usuario");
        
        String ultimoAcesso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(new Date(session.getLastAccessedTime()));
        System.out.println("Filtrando em: " + ultimoAcesso);
        //Usuario user1 = (Usuario) SessionContext.getInstance().getAttribute("user");
        String contextPath = httpRequest.getContextPath();
        System.out.println("contextPath: " + contextPath);

        if (user == null){// || httpRequest.getRequestURI().endsWith("login.xhtml"))) {
            System.out.println("Usuario nulo.");
            //Redirecionamos o usuário imediatamente para a página login.xhtml
            httpResponse.sendRedirect(contextPath + "/login.xhtml");
        }else{
            System.out.println("Usuario ativo.");
            System.out.println(user.getLogin());
        }
    }    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("PagesFilter:DoAfterProcessing");
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        if (debug) {
            log("PagesFilter:doFilter()");
        }
        
        //doBeforeProcessing(request, response);
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        //Verifica se a sessão não expirou, se sim volta para a página de login
        
        HttpSession session = httpRequest.getSession(false);
        Usuario user = null;
        
        count++;        
        System.out.println("Filtrando pela " + count + " vez.");
        String contextPath = httpRequest.getContextPath();  
        
        if(session != null){
            user = (Usuario) session.getAttribute("user");
        }                
        if(user == null){                     
            System.out.println("contextPath: " + contextPath);
            httpResponse.sendRedirect(contextPath + "/login.xhtml");
        }else{
            System.out.println("===== Nome: "+ user.getNome());
            if(!user.isLogado()){            
                httpResponse.sendRedirect(contextPath + "/login.xhtml");
            }
            chain.doFilter(request, response);
        }
    }
        
        

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("PagesFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("PagesFilter()");
        }
        StringBuffer sb = new StringBuffer("PagesFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);                
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");                
                pw.print(stackTrace);                
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
