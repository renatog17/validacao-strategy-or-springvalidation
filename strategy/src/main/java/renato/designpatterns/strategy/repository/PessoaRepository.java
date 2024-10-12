package renato.designpatterns.strategy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import renato.designpatterns.strategy.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
