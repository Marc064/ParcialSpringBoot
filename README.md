# Parcial Spring Boot 

## Marco Antonio Vargas Garcia - 202015214
 
## Intrucciones HTTP

### Products

findAll (GET)
ruta: /products
resultado: Todos los productos

findById (Get)
ruta: /products/{id}
parametros: id
resultado: Producto con el id establecido

save (POST)
ruta: /products
body: name - String, stock - short, dueDate - LocalDate, price - float
resultado: Producto Guardado

### Customers

findAll (GET)
ruta: /customers
resultado: Todos los clientes

findById (Get)
ruta: /customers/{id}
parametros: id
resultado: Cliente con el id establecido

save (POST)
ruta: /customers
body: name - String, birthday - LocalDate, email - String, phone - String
resultado: Cliente guardado

DELETE (DELETE)
ruta: /customers/{id}
parametros: id
resultado: Cliente eliminado

### Sale

save (POST)
ruta: /sales/{idProduct}/{idCostumer}/{amount}
parametros: id del producto, id del cliente, cantidad
Resultado: Venta