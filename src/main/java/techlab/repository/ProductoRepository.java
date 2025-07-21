package techlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import techlab.entity.Producto;
import java.util.ArrayList;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    ArrayList<Producto> findByNombreContainingIgnoreCase(String busqueda);
}
