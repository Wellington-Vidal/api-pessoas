package one.digitalinnovation.apipessoas.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.apipessoas.dto.request.PessoaDTO;
import one.digitalinnovation.apipessoas.dto.request.TelefoneDTO;
import one.digitalinnovation.apipessoas.entity.Pessoa;
import one.digitalinnovation.apipessoas.entity.Telefone;
import one.digitalinnovation.apipessoas.exception.PessoaNaoEncontradaException;
import one.digitalinnovation.apipessoas.repository.PessoaRepository;

@Service
public class PessoasServicos {
    
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoasServicos(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public String adicionaPessoa(PessoaDTO pessoaDto){
        List<Telefone> telefones = new ArrayList<>();

        for (TelefoneDTO foneDto : pessoaDto.getTelefones()) {
            telefones.add(new Telefone(foneDto.getId(), foneDto.getTipo(), foneDto.getNumero()));
        }
        
        LocalDate dataNasc = LocalDate.parse(pessoaDto.getDataNasc(), formato);

        Pessoa pessoa = new Pessoa(pessoaDto.getPrimeiroNome(),
                                   pessoaDto.getUltimoNome(),
                                   pessoaDto.getCpf(),
                                   dataNasc,
                                   telefones);


        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return "Pessoa registrada com ID: " + pessoaSalva.getId();
    }

    public List<PessoaDTO> listaPessoas() {
        List<PessoaDTO> listaPessoasDTO = new ArrayList<>();
        
        for (Pessoa pessoa : pessoaRepository.findAll()) {
            List<TelefoneDTO> listaTelefonesDTO = new ArrayList<>();

            for (Telefone fone : pessoa.getTelefones()) {
                TelefoneDTO telefoneDTO = new TelefoneDTO(fone.getId(), 
                                                          fone.getTipo(), 
                                                          fone.getNumero());
                                                          
                listaTelefonesDTO.add(telefoneDTO);
            }

            String dataFormatada = pessoa.getDataNasc().format(formato);

            PessoaDTO pessoaDTO = new PessoaDTO(pessoa.getId(), 
                                                pessoa.getPrimeiroNome(), 
                                                pessoa.getUltimoNome(), 
                                                pessoa.getCpf(), 
                                                dataFormatada, 
                                                listaTelefonesDTO);
            listaPessoasDTO.add(pessoaDTO);
        }
        
        return listaPessoasDTO;
    }

    public PessoaDTO encontrePeloId(Long id) throws PessoaNaoEncontradaException {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException(id));

        List<TelefoneDTO> listaTelefonesDTO = new ArrayList<>();

        for (Telefone fone : pessoa.getTelefones()) {
            TelefoneDTO telefoneDTO = new TelefoneDTO(fone.getId(), 
                                                      fone.getTipo(), 
                                                      fone.getNumero());
                                                        
            listaTelefonesDTO.add(telefoneDTO);
        }

        String dataFormatada = pessoa.getDataNasc().format(formato);

        return new PessoaDTO(pessoa.getId(), 
                             pessoa.getPrimeiroNome(), 
                             pessoa.getUltimoNome(), 
                             pessoa.getCpf(), 
                             dataFormatada, 
                             listaTelefonesDTO);
    }

    public void deletaPeloId(Long id) {
        if (pessoaRepository.existsById(id)){
            pessoaRepository.deleteById(id);
        }
    }

    public String atualizaPeloId(Long id, @Valid PessoaDTO pessoaDTO) {
        if (pessoaRepository.existsById(id)){
            List<Telefone> telefones = new ArrayList<>();

            for (TelefoneDTO foneDto : pessoaDTO.getTelefones()) {
                telefones.add(new Telefone(foneDto.getId(), foneDto.getTipo(), foneDto.getNumero()));
            }
            
            LocalDate dataNasc = LocalDate.parse(pessoaDTO.getDataNasc(), formato);

            Pessoa pessoa = new Pessoa(pessoaDTO.getPrimeiroNome(),
                                       pessoaDTO.getUltimoNome(),
                                       pessoaDTO.getCpf(),
                                       dataNasc,
                                       telefones);

            pessoa.setId(id);

            pessoaRepository.save(pessoa);

            return "Pessoa atualizada com sucesso";
        }

        return "Pessoa não localizada para atualizar";
    }

}