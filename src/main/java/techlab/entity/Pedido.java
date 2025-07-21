package techlab.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaCreacion;

    private double total;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detalles = new ArrayList<>();

    public Pedido() {
        this.fechaCreacion = LocalDateTime.now();
        this.total = 0.0;
    }

    // Getters y Setters

    public void agregarDetalle(DetallePedido detalle) {
        detalle.setPedido(this);
        detalles.add(detalle);
        recalcularTotal();
    }

    public void eliminarDetalle(DetallePedido detalle) {
        detalles.remove(detalle);
        recalcularTotal();
    }

    public void recalcularTotal() {
        total = detalles.stream()
                .mapToDouble(DetallePedido::getSubtotal)
                .sum();
    }

    // Getters y setters omitidos por brevedad
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }

}
