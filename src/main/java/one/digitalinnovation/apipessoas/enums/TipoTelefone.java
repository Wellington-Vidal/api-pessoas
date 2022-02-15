package one.digitalinnovation.apipessoas.enums;

public enum TipoTelefone {
    
    RESIDENCIAL("Residencial"),
    MOVEL("Movel"),
    COMERCIAL("Comercial");

    private final String descricao;

    private TipoTelefone(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}