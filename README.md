Proyecto Java Backend
Este proyecto utiliza base de Datos en H2 para los productos y se inicia con 20 productos de ejemplo en la base de datos.
Posee los endpoint para:
1) Listar productos
2) Agregar productos
3) Buscar productos por id
4) Buscar por nombre
5) editar precio productos
6) eliminar productos
7) Crear pedido
8) Agregar producto a pedido
9) Eliminar producto del pedido
10) Consultar pedido

las rutas para los llamados a la API son:

1) GET localhost:8080/productos/listar
2) POST localhost:8080/productos/
   json
   {
   "nombre": "transistor BD139",
   "precio": 1250,
   "stock": 100,
   "descripcion": "transistor uso general"
   }

3) GET http://localhost:8080/productos/{id}
4) GET http://localhost:8080/productos/buscar?nombreBusqueda='String'
5) PUT http://localhost:8080/productos/{id}?nuevoPrecio=Valor
6) DELETE http://localhost:8080/productos/{id}
7) POST http://localhost:8080/pedidos
8) POST http://localhost:8080/pedidos/{idPedido}/agregar?productoId=Id&cantidad=Cantidad
9) DELETE http://localhost:8080/pedidos/{idPedido}/detalle/{Item}
10) GET http://localhost:8080/pedidos/{idPedido}
