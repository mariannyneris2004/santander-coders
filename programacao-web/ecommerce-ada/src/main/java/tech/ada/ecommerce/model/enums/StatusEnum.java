package tech.ada.ecommerce.model.enums;

public enum StatusEnum {
    EM_ABERTO("em aberto"),
    PGTO_APROVADO("pagamento aprovado"),
    PGTO_PROCESSAMENTO("pagamento em processamento"),
    PGTO_REJEITADO("pagamento_rejeitado"),
    CANCELADA("compra cancelada"),
    EM_TRANSPORTE("em transporte"),
    FINALIZADO("compra finalizada");

    public String statusDaCompra;

    StatusEnum(String statusDaCompra) {
        this.statusDaCompra = statusDaCompra;
    }

    public String getStatusDaCompra() {
        return statusDaCompra;
    }
}
