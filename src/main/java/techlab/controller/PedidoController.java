package techlab.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import techlab.entity.Pedido;
import techlab.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido crearPedido() {
        return pedidoService.crearPedido();
    }

    @PostMapping("/{id}/agregar")
    public Pedido agregarProducto(@PathVariable Long id,
                                  @RequestParam Long productoId,
                                  @RequestParam int cantidad) {
        return pedidoService.agregarProducto(id, productoId, cantidad);
    }

    @DeleteMapping("/{pedidoId}/detalle/{itemId}")
    public Pedido eliminarProducto(@PathVariable Long pedidoId,
                                   @PathVariable Long itemId) {
        return pedidoService.eliminarProducto(pedidoId, itemId);
    }

    @GetMapping("/{id}")
    public Pedido obtenerPedido(@PathVariable Long id) {
        return pedidoService.obtenerPedido(id);
    }
}
