package techlab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techlab.entity.Pedido;
import techlab.entity.Producto;
import techlab.entity.DetallePedido;
import techlab.repository.PedidoRepository;
import techlab.repository.ProductoRepository;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public Pedido crearPedido() {
        Pedido pedido = new Pedido();
        return pedidoRepository.save(pedido);
    }

    public Pedido agregarProducto(Long pedidoId, Long productoId, int cantidad) {
        Optional<Pedido> pedidoOpt = pedidoRepository.findById(pedidoId);
        Optional<Producto> productoOpt = productoRepository.findById(productoId);

        if (pedidoOpt.isPresent() && productoOpt.isPresent()) {
            Pedido pedido = pedidoOpt.get();
            Producto producto = productoOpt.get();

            // Buscar si ya existe el detalle con ese producto
            DetallePedido existente = pedido.getDetalles().stream()
                    .filter(d -> d.getProducto().getId().equals(productoId))
                    .findFirst()
                    .orElse(null);

            if (existente != null) {
                // Si ya existe, actualizar cantidad
                existente.setCantidad(existente.getCantidad() + cantidad);
            } else {
                // Si no existe, agregar nuevo detalle
                DetallePedido nuevoDetalle = new DetallePedido(producto, cantidad);
                pedido.agregarDetalle(nuevoDetalle);
            }

            pedido.recalcularTotal();
            return pedidoRepository.save(pedido);

        } else {
            throw new RuntimeException("Pedido o Producto no encontrado.");
        }
    }

    public Pedido eliminarProducto(Long pedidoId, Long detalleId) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        DetallePedido detalleAEliminar = pedido.getDetalles().stream()
                .filter(d -> d.getId().equals(detalleId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Detalle no encontrado"));

        pedido.eliminarDetalle(detalleAEliminar);
        return pedidoRepository.save(pedido);
    }

    public Pedido obtenerPedido(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }
}
