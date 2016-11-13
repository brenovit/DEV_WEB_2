package DTO;

public class DtoVenda {
    private int idVenda;
    private DtoUsuario usuario ;
    private DtoProduto produto;
    private Double vlvenda;

    public DtoVenda() {
    }
    
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdvenda(int idvenda) {
        this.idVenda = idvenda;
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
