package techlab.inicio;


import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/productos")
public class productController {
    private ArrayList<Producto> productos;
    private List<Pedido> pedidos = new ArrayList<>();

    public productController(){
        this.productos = new ArrayList<>();
        agregarProductosDeEjemplo();
    }
    @GetMapping
    public List<Producto> listarProductos(){
        return this.productos;
    }
    @PostMapping("/add")
    public String crearProducto(@RequestBody Producto producto){
        return agregarProducto(producto);
    }
    @DeleteMapping ("/{id}")
    public Producto deleteProduct(@PathVariable long id){
        return eliminarProducto(id);
    }
    @GetMapping("/find")
    public List<Producto> buscarProductosNombre(@RequestParam String nombreBusqueda){
        return this.buscarProducto(nombreBusqueda);
    }
    @GetMapping("/{id}")
    public Producto buscarProductoPorId(@PathVariable Long id){
        return this.buscarPorId(id);
    }
    @PutMapping("/{id}")
    public Producto editarPrecioProducto(@PathVariable Long id, @RequestParam Double nuevoPrecio){
        return this.modificarProducto(id, nuevoPrecio);
    }

    public String agregarProducto(Producto producto){
        productos.add(producto);
        return "✅ Producto cargado exitosamente!\n ID del Producto: " + producto.getId();
    }

    // Agrego productos de ejemplo para que queden en memoria ya que no tenemos DB
    public void agregarProductosDeEjemplo() {
        productos.add(new Producto("Resistencia 220Ω", 0.10, 500));
        productos.add(new Producto("Condensador 10uF 16V", 0.25, 300));
        productos.add(new Producto("Transistor BC547", 0.15, 200));
        productos.add(new Producto("Diodo 1N4007", 0.10, 400));
        productos.add(new Producto("LED Rojo 5mm", 0.05, 600));
        productos.add(new Producto("LED Verde 5mm", 0.05, 600));
        productos.add(new Producto("Circuito Integrado 555", 0.50, 150));
        productos.add(new Producto("Microcontrolador ATmega328P", 2.50, 80));
        productos.add(new Producto("Placa Arduino Uno", 9.99, 100));
        productos.add(new Producto("Protoboard 830 puntos", 4.00, 75));
        productos.add(new Producto("Cables Dupont (40 unidades)", 1.20, 120));
        productos.add(new Producto("Sensor de temperatura LM35", 0.60, 90));
        productos.add(new Producto("Potenciómetro 10kΩ", 0.30, 150));
        productos.add(new Producto("Motor DC 3V-6V", 1.10, 70));
        productos.add(new Producto("Relevo 5V 1 canal", 0.90, 60));
        productos.add(new Producto("Módulo Bluetooth HC-05", 3.20, 50));
        productos.add(new Producto("Módulo WiFi ESP8266", 3.50, 45));
        productos.add(new Producto("Multímetro digital", 12.99, 30));
        productos.add(new Producto("Fuente de alimentación 5V 2A", 5.50, 40));
        productos.add(new Producto("Soldador eléctrico 60W", 8.75, 25));
    }

    public Producto eliminarProducto(long id) {
        Producto producto = this.buscarPorId(id);

        if (producto == null) {
            return null;
        }
        this.productos.remove(producto);
        return producto;
    }

    private ArrayList<Producto> buscarProducto(String busqueda) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();

        for (Producto producto : productos){
            if (producto.getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
                productosEncontrados.add(producto);
            }
        }

        return productosEncontrados;
    }

    private Producto buscarPorId(Long id) {
        for (Producto producto : productos){
            if (producto.getId() == id){
                return producto;
            }
        }

        // si llega aca es porque no encontro el producto
        return null;
    }

    public Producto modificarProducto(Long id, Double precio) {
        Producto producto = buscarPorId(id);

        if (producto == null){
            return null;
        }
        producto.setPrecio(precio);
        return producto;
    }

}
