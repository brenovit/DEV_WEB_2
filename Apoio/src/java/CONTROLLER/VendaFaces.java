
package CONTROLLER;

import DTO.DtoProduto;
import DTO.DtoUsuario;
import DTO.DtoVenda;
import MODEL.VendaDAO;
import java.sql.SQLException;
import java.util.List;


public class VendaFaces {
    private VendaDAO venDAO = new VendaDAO();
    private DtoVenda venda;
    private List<DtoVenda> listaVendas = null;    
    
    public VendaFaces() {
    }

    public DtoVenda getVenda() {
        return venda;
    }

    public void setVenda(DtoVenda venda) {
        this.venda = venda;
    }

    public List<DtoVenda> getListaVendas() throws ClassNotFoundException, SQLException {
        if (this.listaVendas == null) {
            listaVendas = venDAO.getRetornaTodos();
        }
        return listaVendas;
    }    
    
    public String preparaInclusao(){
        venda = new DtoVenda();
        venda.setUsuario(new DtoUsuario());
        venda.setProduto(new DtoProduto());
                
        return "VaiParaNovavenda";
    }
    
    public String finalizarVenda() throws ClassNotFoundException, SQLException{
        venDAO.setAdicionar(venda);
        this.venda = null;
        this.listaVendas = null;
        return "VoltaParaListagem";
    }
    
    public String finalizaDelecao() throws ClassNotFoundException, SQLException {
        venDAO.setDeletar(venda);
        this.venda = null;
        this.listaVendas = null;
        return "Deletar";
    }
    
    public String listagemVendasVendedor(){
        venda = new DtoVenda();
        venda.setUsuario(new DtoUsuario());
        venda.setProduto(new DtoProduto());
        return "ListagemVendaVendedor";
    }
    
    public String listagemVendas(){
        venda = null;
        return "ListagemVenda";
    }       
    
    public String voltarPrincipal(){
        return "VoltarPrincipal";
    }
    
    public String buscaVendasVendedor() throws ClassNotFoundException, SQLException{
        if (venda.getUsuario().getIdusuario() == 0) {
            listaVendas = venDAO.getRetornaTodos();
        }else{
           listaVendas = venDAO.getPorVendedor(venda);       
        }      
        
        venda = new DtoVenda();
        venda.setUsuario(new DtoUsuario());
        venda.setProduto(new DtoProduto());
        return "buscaVendaVendedor";
    }
}
