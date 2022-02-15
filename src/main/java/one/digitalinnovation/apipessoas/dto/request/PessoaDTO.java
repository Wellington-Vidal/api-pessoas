package one.digitalinnovation.apipessoas.dto.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class PessoaDTO {
    
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String primeiroNome;
    
    @NotEmpty
    @Size(min = 2, max = 100)
    private String ultimoNome;

    @NotEmpty
    @CPF
    private String cpf;

    @NotEmpty
    @Size(min = 10, max = 10)
    private String dataNasc;

    @Valid
    @NotEmpty
    private List<TelefoneDTO> telefones;

    public PessoaDTO(Long id, String primeiroNome, String ultimoNome, String cpf, String dataNasc, List<TelefoneDTO> telefones) {
        this.id = id;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.telefones = telefones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public List<TelefoneDTO> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneDTO> telefones) {
        this.telefones = telefones;
    }
}