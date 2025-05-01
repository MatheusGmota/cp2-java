package fiap.com.br.brinquedos.services;

import fiap.com.br.brinquedos.entities.Brinquedo;
import fiap.com.br.brinquedos.repositories.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrinquedoService {

    @Autowired
    BrinquedoRepository repository;

    public Brinquedo salvar(Brinquedo brinquedo) {
        if (brinquedo != null) {
            repository.save(brinquedo);
        }
        return brinquedo;
    }

    public Brinquedo atualizar(Brinquedo brinquedo) {
        if (brinquedo != null) {
            repository.saveAndFlush(brinquedo);
        }
        return brinquedo;
    }

    public List<Brinquedo> obterTodos() {
        return repository.findAll();
    }

    public Brinquedo obterPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Brinquedo deletar(Long id, Brinquedo brinquedo) {
        if (brinquedo == null) {
            Brinquedo b = repository.findById(id).orElse(null);
            if (b != null) repository.delete(b);
            return b;
        }

        repository.delete(brinquedo);
        return brinquedo;
    }

}
