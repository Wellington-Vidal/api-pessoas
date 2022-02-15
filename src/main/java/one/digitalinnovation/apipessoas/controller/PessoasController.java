package one.digitalinnovation.apipessoas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.apipessoas.dto.request.PessoaDTO;
import one.digitalinnovation.apipessoas.exception.PessoaNaoEncontradaException;
import one.digitalinnovation.apipessoas.service.PessoasServicos;

@RestController
@RequestMapping(path = "/api/v1/pessoa")
public class PessoasController {
    
    private PessoasServicos pessoasServicos;

    @Autowired
    public PessoasController(PessoasServicos pessoasServicos) {
        this.pessoasServicos = pessoasServicos;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String adicionaPessoa(@RequestBody @Valid PessoaDTO pessoaDTO){
        return pessoasServicos.adicionaPessoa(pessoaDTO);
    }

    @GetMapping
    public List<PessoaDTO> getListaPessoas(){
        return pessoasServicos.listaPessoas();
    }

    @GetMapping("/{id}")
    public PessoaDTO getPessoa(@PathVariable Long id) throws PessoaNaoEncontradaException{
        return pessoasServicos.encontrePeloId(id);
    }

    @PutMapping("/{id}")
    public String atualizaPessoa(@PathVariable Long id, @RequestBody @Valid PessoaDTO pessoaDTO){
        return pessoasServicos.atualizaPeloId(id, pessoaDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaPessoa(@PathVariable Long id){
        pessoasServicos.deletaPeloId(id);
    }
}