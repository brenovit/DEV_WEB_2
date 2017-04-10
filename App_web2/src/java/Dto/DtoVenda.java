package Dto;

public class DtoVenda {
    private int idVenda;
    private Double vlVenda;
    
    private DtoUsuario usuario;
    private DtoProduto produto;    

    public DtoVenda() {
    }

    public DtoVenda(int idVenda, Double vlVenda, DtoUsuario usuario, DtoProduto produto) {
        this.idVenda = idVenda;
        this.vlVenda = vlVenda;
        this.usuario = usuario;
        this.produto = produto;
    }
        
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public DtoUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(DtoUsuario usuario) {
        this.usuario = usuario;
    }

    public DtoProduto getProduto() {
        return produto;
    }

    public void setProduto(DtoProduto produto) {
        this.produto = produto;
    }

    public Double getVlVenda() {
        return vlVenda;
    }

    public void setVlVenda(Double vlVenda) {
        this.vlVenda = vlVenda;
    }
}
