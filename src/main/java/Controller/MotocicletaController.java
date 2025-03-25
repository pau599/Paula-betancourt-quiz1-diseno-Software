package Controller;

import java.net.http.HttpResponse.ResponseInfo;
import java.util.List;
import java.util.Optional;

import Service.MotocicletaService;
import model.Motocicleta;

public class MotocicletaController {
	
	private static final String ResponseEntity = null;
	private MotocicletaService service;

    public List<Motocicleta> listar() {
        return service.obtenerTodas();
    }

    public ResponseInfo<Motocicleta> obtenerPorId( Long id) {
        Optional<Motocicleta> moto = service.obtenerPorId(id);
        return moto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Motocicleta> agregar( Motocicleta moto) {
        return ResponseEntity.ok(service.guardar(moto));
    }

    public ResponseEntity<Motocicleta> actualizar( Long id, Motocicleta moto) {
        Motocicleta updatedMoto = service.actualizar(id, moto);
        return updatedMoto != null ? ResponseEntity.ok(updatedMoto) : ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> eliminar(Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
