package Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import Repository.MotocicletaRepository;
import model.Motocicleta;

public class MotocicletaService {

    private MotocicletaRepository repository;

    public MotocicletaService() {
        this.repository = new MotocicletaRepository();
    }

    public List<Motocicleta> obtenerTodas() throws SQLException {
        return repository.obtenerTodas();
    }

    public Optional<Motocicleta> obtenerPorId(int id) throws SQLException {
        return repository.obtenerTodas().stream()
                .filter(m -> m.getId() == id)
                .findFirst();
    }

    public void guardar(Motocicleta moto) throws SQLException {
        repository.guardar(moto);
    }

    public boolean actualizar(int id, Motocicleta moto) throws SQLException {
        Optional<Motocicleta> motoExistente = obtenerPorId(id);
        if (motoExistente.isPresent()) {
            Motocicleta m = motoExistente.get();
            m.setMarca(moto.getMarca());
            m.setModelo(moto.getModelo());
            m.setAnio(moto.getAnio());
            m.setPrecio(moto.getPrecio());
            repository.guardar(m);
            return true;
        }
        return false;
    }

    public boolean eliminar(int id) throws SQLException {
        Optional<Motocicleta> motoExistente = obtenerPorId(id);
        if (motoExistente.isPresent()) {
            repository.eliminar(id);
            return true;
        }
        return false;
    }
}
