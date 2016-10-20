package DTO;


public class DtoVenda {
    private int idvenda;
    private DtoUsuario usuario ;
    private DtoProduto produto;
    private Double vlvenda;

    public DtoVenda() {
    }

    public DtoVenda(int idvenda, DtoUsuario usuario, DtoProduto produto, Double vlvenda) {
        this.idvenda = idvenda;
        this.usuario = usuario;
        this.produto = produto;
        this.vlvenda = vlvenda;
    }

    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
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

    public Double getVlvenda() {
        return vlvenda;
    }

    public void setVlvenda(Double vlvenda) {
        this.vlvenda = vlvenda;
    }
    
    
    
    
}
