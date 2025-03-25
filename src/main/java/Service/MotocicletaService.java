package Service;

import java.util.List;
import java.util.Optional;

import model.Motocicleta;


public class MotocicletaService {
	
	@Autowired
	public List<Motocicleta> obtenerTodas() {
        return repository.findAll();
    }

    public Optional<Motocicleta> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Motocicleta guardar(Motocicleta moto) {
        return repository.save(moto);
    }

    public Motocicleta actualizar(Long id, Motocicleta moto) {
        return repository.findById(id).map(m -> {
            m.setMarca(moto.getMarca());
            m.setModelo(moto.getModelo());
            m.setAnio(moto.getAnio());
            m.setPrecio(moto.getPrecio());
            return repository.save(m);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
