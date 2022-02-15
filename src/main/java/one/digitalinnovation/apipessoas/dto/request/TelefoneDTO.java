package one.digitalinnovation.apipessoas.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import one.digitalinnovation.apipessoas.enums.TipoTelefone;

public class TelefoneDTO {
    
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoTelefone tipo;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String numero;

    public TelefoneDTO(Long id, TipoTelefone tipo, String numero) {
        this.id = id;
        this.tipo = tipo;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoTelefone getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefone tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
