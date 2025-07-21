package techlab.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import techlab.entity.Producto;

@Repository
// Hacemos operaciones principalmente de:
// * filtrado
// * ordenamiento
// * paginado
// * modificaciones de datos
public class ProductRepository {
  // "BASE DE DATOS" en memoria
  private final ArrayList<Producto> productos;

  public ProductRepository() {
    this.productos = new ArrayList<>();
  }

  public String agregarProducto(Producto producto){
    productos.add(producto);

    return "☣ Producto cargado exitosamente! ☣ \n ID del Producto: " + producto.getId();
  }

  public List<Producto> listarProductos() {
    return this.productos;
  }

  public ArrayList<Producto> buscarProducto(String busqueda) {
    ArrayList<Producto> productosEncontrados = new ArrayList<>();

   for (Producto producto : productos){
      if (producto.contieneNombre(busqueda)){
        productosEncontrados.add(producto);
      }
   }

    return productosEncontrados;
  }

  public Producto buscarPorId(Long id) {
    for (Producto producto : productos){
      if (producto.getId() == id){
        return producto;
      }
    }

    // si llega aca es porque no encontro el producto
    return null;
  }

  public Producto eliminarProducto(Producto producto) {
    this.productos.remove(producto);

    return producto;
  }



}
