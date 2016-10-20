
package CONTROLLER;

import DTO.DtoVenda;
import MODEL.VendaDAO;
import java.sql.SQLException;
import java.util.List;


public class VendaFaces {
    private VendaDAO venDAO = new VendaDAO();
    private DtoVenda vendaselecionada;
    private List<DtoVenda> vendas = null;    
    
    public VendaFaces() {
    }

    public DtoVenda getVendaselecionada() {
        return vendaselecionada;
    }

    public void setVendaselecionada(DtoVenda vendaselecionada) {
        this.vendaselecionada = vendaselecionada;
    }

    public List<DtoVenda> getVendas() throws ClassNotFoundException, SQLException {
        if (this.vendas==null){
            this.vendas = venDAO.getRetornaTodos();
        }
        return this.vendas;
    }    
    
    
}
