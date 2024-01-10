package cevaja.repository;

import cevaja.model.TipoCerveja;
import cevaja.model.Usuario;
import cevaja.model.dto.converter.TipoCervejaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CervejaRepository extends JpaRepository<TipoCerveja, Long> {

    public TipoCerveja findByNome(String nome);

}
