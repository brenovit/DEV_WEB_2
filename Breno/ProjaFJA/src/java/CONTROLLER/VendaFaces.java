package CONTROLLER;

import DTO.DtoProduto;
import DTO.DtoUsuario;
import DTO.DtoVenda;
import MODEL.VendaDAO;
import java.sql.SQLException;
import java.util.List;

public class VendaFaces {
    private final VendaDAO venDAO = new VendaDAO();
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
        if (venda.getUsuario().getIdusuario() == 0) {
           listaVendas = venDAO.getRetornaTodos();
        } else {
           listaVendas = venDAO.getPorVendedor(venda);       
        }          
        return listaVendas;
    }    
    
    public String preparaInclusao(){
        LimparVenda();
        return "IncluirVenda";
    }
    
    public String finalizarVenda() throws ClassNotFoundException, SQLException{
        venDAO.setAdicionar(venda);
        listaVendas = null;         
        venda = null;
        LimparVenda();
        return "VoltarListagem";
    }
    
    public String finalizaDelecao() throws ClassNotFoundException, SQLException {
        venDAO.setDeletar(venda);
        listaVendas = null;
        return "Atualizar";
    }
    
    public String listagemVendas(){
        LimparVenda();
        return "ListagemVenda";
    }
        
    
    public String voltarPrincipal(){
        return "VoltarPrincipal";
    }
    
    public String buscaVendasVendedor() throws ClassNotFoundException, SQLException{               
        return "Atualizar";
    }
    
    private void LimparVenda(){
        venda = null;
        venda = new DtoVenda();
        venda.setUsuario(new DtoUsuario());
        venda.setProduto(new DtoProduto());
    }
}
