package techlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import techlab.entity.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
    // Podés agregar consultas personalizadas más adelante si hiciera falta
}
