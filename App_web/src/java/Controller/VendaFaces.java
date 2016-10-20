
package Controller;

import Dto.DtoVenda;
import Model.VendaDao;
import java.sql.SQLException;
import java.util.List;

public class VendaFaces {
    private VendaDao vendaDao;
    private DtoVenda venda;
    private List<DtoVenda> lista = null;
    
    public VendaFaces() {
    }

    public DtoVenda getVenda() {
        return venda;
    }

    public void setVenda(DtoVenda venda) {
        this.venda = venda;
    }

    public List<DtoVenda> getLista() throws ClassNotFoundException, SQLException {
        if(lista ==null){
            lista = vendaDao.getRetornaTodos();
        }
        return lista;
    }    
}
