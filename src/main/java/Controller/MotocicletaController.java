package Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import Service.MotocicletaService;
import model.Motocicleta;

public class MotocicletaController {

    private MotocicletaService service = new MotocicletaService();

    public List<Motocicleta> listar() throws SQLException {
        return service.obtenerTodas();
    }

    public String obtenerPorId(int id) throws SQLException {
        Optional<Motocicleta> moto = service.obtenerPorId(id);
        return moto.map(m -> "Motocicleta encontrada: " + m.getMarca() + " " + m.getModelo())
                   .orElse("Motocicleta no encontrada");
    }

    public String agregar(Motocicleta moto) throws SQLException {
        service.guardar(moto);
        return "Motocicleta agregada exitosamente";
    }

    public String actualizar(int id, Motocicleta moto) throws SQLException {
        boolean actualizado = service.actualizar(id, moto);
        return actualizado ? "Motocicleta actualizada" : "Motocicleta no encontrada";
    }
    
    public String eliminar(int id) throws SQLException {
        boolean eliminado = service.eliminar(id); // Se asigna el resultado a una variable
        return eliminado ? "Motocicleta eliminada con éxito." : "Error: No se encontró la motocicleta.";
    }

}
