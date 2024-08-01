import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rastreamentos")
public class RastreamentoController {

    @Autowired
    private RastreamentoService rastreamentoService;

    // POST /rastreamentos - Adiciona um novo rastreamento
    @PostMapping
    public Rastreamento addRastreamento(@RequestBody Rastreamento rastreamento) {
        return rastreamentoService.addRastreamento(rastreamento);
    }

    // GET /rastreamentos/{id} - Consulta todos os rastreamentos de um pacote específico
    @GetMapping("/{id}")
    public ResponseEntity<List<Rastreamento>> getRastreamentosByPacoteId(@PathVariable Long id) {
        List<Rastreamento> rastreamentos = rastreamentoService.getRastreamentosByPacoteId(id);
        return ResponseEntity.ok(rastreamentos);
    }
}
