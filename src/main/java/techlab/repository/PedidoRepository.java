package techlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import techlab.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Acá podés agregar métodos personalizados si los necesitás más adelante
}
