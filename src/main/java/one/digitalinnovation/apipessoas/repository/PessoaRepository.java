package one.digitalinnovation.apipessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.apipessoas.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
}
