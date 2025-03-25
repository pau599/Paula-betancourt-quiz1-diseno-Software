package PatronRepository2;

import java.sql.SQLException;
import java.util.List;

import DTO.UserDTO;
import Exception.InvalidUserDataException;
import Repository.MotocicletaRepository;
import Service.UserService;
import model.Motocicleta;

public class Application {
	public static void main (String [] args) {
		MotocicletaRepository repo = new MotocicletaRepository();

        try {
            // Crear una nueva motocicleta
            Motocicleta moto = new Motocicleta(0, "Yamaha", "R1", 2023, 18000.00);
            repo.guardar(moto);
            System.out.println("Motocicleta guardada con éxito.");

            // Listar todas las motocicletas
            List<Motocicleta> motos = repo.obtenerTodas();
            for (Motocicleta m : motos) {
                System.out.println("ID: " + m.getId() + ", Marca: " + m.getMarca());
            }

            // Eliminar una motocicleta por ID
            repo.eliminar(1);
            System.out.println("Motocicleta eliminada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	}