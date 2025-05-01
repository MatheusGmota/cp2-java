package fiap.com.br.brinquedos.controllers;

import fiap.com.br.brinquedos.entities.Brinquedo;
import fiap.com.br.brinquedos.services.BrinquedoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    BrinquedoService service;

    @PostMapping()
    public Object getBrinquedo(@RequestBody Brinquedo brinquedo) {;
        Object retorno = service.salvar(brinquedo);

        if (retorno == null) return "Não foi possivel cadastrar brinquedo, objeto null";
        else return retorno;
    }

    @PutMapping()
    public Object postBrinquedo(@RequestBody Brinquedo brinquedo) {
        Brinquedo retorno = service.atualizar(brinquedo);

        if (retorno == null) return "Não foi possivel atualizar brinquedo, objeto null";
        else return retorno;
    }

    @GetMapping()
    public List<Brinquedo> getTodosBrinquedos() {
        return service.obterTodos();
    }

    @GetMapping()
    public Object getBrinquedoPorId(@RequestParam("id") Long id) {
        Brinquedo brinquedo = service.obterPorId(id);
        if (brinquedo == null) return "Objeto não encontrado";
        else return brinquedo;
    }

    @DeleteMapping()
    public Object deleteBrinquedo(@RequestParam("id") Long id, @RequestBody Brinquedo brinquedo) {
        Brinquedo retorno = service.deletar(id, brinquedo);
        return "Brinquedo deletado com sucesso";
    }
}
