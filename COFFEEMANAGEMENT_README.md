# Bounded Context: Coffee Management

## Descripción

El bounded context `coffeemanagement` es responsable de gestionar el inventario de café, específicamente el registro de consumo de lotes de café. Este contexto se integra con el bounded context `coffeeproduction` para obtener información de los lotes de café disponibles.

## Arquitectura DDD

### Domain Layer

#### Aggregates
- **InventoryEntry**: Representa una entrada de inventario que registra el consumo de un lote de café específico.

#### Value Objects
- **InventoryEntryId**: Identificador único de una entrada de inventario
- **LotId**: Identificador del lote de café (reutilizado del bounded context coffeeproduction)
- **UserId**: Identificador del usuario (reutilizado del bounded context coffeeproduction)
- **QuantityUsed**: Cantidad de café consumida (debe ser positiva)
- **DateUsed**: Fecha y hora del consumo
- **FinalProduct**: Producto final resultante del consumo

#### Commands
- **CreateInventoryEntryCommand**: Comando para crear una nueva entrada de inventario
- **UpdateInventoryEntryCommand**: Comando para actualizar una entrada de inventario existente
- **DeleteInventoryEntryCommand**: Comando para eliminar una entrada de inventario

#### Queries
- **GetAllInventoryEntriesQuery**: Consulta para obtener todas las entradas de inventario de un usuario
- **GetInventoryEntryByIdQuery**: Consulta para obtener una entrada de inventario por ID
- **GetInventoryEntriesByLotQuery**: Consulta para obtener entradas de inventario por lote de café

#### Services
- **InventoryEntryCommandService**: Servicio para operaciones de escritura (comandos)
- **InventoryEntryQueryService**: Servicio para operaciones de lectura (consultas)

### Application Layer

#### Command Services
- **InventoryEntryCommandServiceImpl**: Implementación del servicio de comandos

#### Query Services
- **InventoryEntryQueryServiceImpl**: Implementación del servicio de consultas
- **CoffeeLotQueryService**: Servicio para consultar lotes desde el bounded context coffeeproduction

### Infrastructure Layer

#### Persistence
- **InventoryEntryEntity**: Entidad JPA para la tabla `inventory_entries`
- **InventoryEntryRepository**: Repositorio JPA con métodos personalizados

#### Database Migration
- **V1_2__create_inventory_entries.sql**: Migración para crear la tabla `inventory_entries`

### Interfaces Layer

#### REST Controllers
- **InventoryEntryController**: Controlador REST con endpoints para:
  - POST `/api/inventory-entries` - Crear entrada de inventario
  - GET `/api/inventory-entries` - Obtener todas las entradas de un usuario
  - GET `/api/inventory-entries/{id}` - Obtener entrada por ID
  - GET `/api/inventory-entries/by-lot/{lotId}` - Obtener entradas por lote
  - GET `/api/inventory-entries/available-lots` - Obtener lotes disponibles
  - PUT `/api/inventory-entries/{id}` - Actualizar entrada
  - DELETE `/api/inventory-entries/{id}` - Eliminar entrada

#### DTOs
- **InventoryEntryDto**: DTO para respuestas de entradas de inventario
- **CreateInventoryEntryRequest**: DTO para solicitudes de creación
- **UpdateInventoryEntryRequest**: DTO para solicitudes de actualización
- **LotDto**: DTO para lotes de café (reutilizado del bounded context coffeeproduction)

#### Transformers
- **InventoryEntryTransformer**: Transformador para entradas de inventario
- **LotTransformer**: Transformador para lotes de café

## Integración con Frontend

### Cambios en el Frontend

1. **InventoryService**: Actualizado para usar el nuevo backend en lugar de MockAPI
2. **Componentes**: Actualizados para pasar el `userId` en las llamadas al servicio
3. **Environment**: Configurado con la URL del API del backend

### Endpoints Utilizados

- `GET /api/inventory-entries?userId={userId}` - Obtener entradas de inventario
- `POST /api/inventory-entries?userId={userId}` - Crear entrada de inventario
- `GET /api/inventory-entries/available-lots?userId={userId}` - Obtener lotes disponibles
- `GET /api/inventory-entries/by-lot/{lotId}` - Obtener entradas por lote

## Dependencias

### Bounded Context coffeeproduction
El bounded context `coffeemanagement` depende del bounded context `coffeeproduction` para:
- Obtener información de lotes de café disponibles
- Validar que los lotes existan antes de crear entradas de inventario

### Integración
- **CoffeeLotQueryService**: Actúa como cliente del bounded context `coffeeproduction`
- **LotTransformer**: Reutiliza la estructura de lotes del bounded context `coffeeproduction`

## Base de Datos

### Tabla: inventory_entries
```sql
CREATE TABLE inventory_entries (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    coffee_lot_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    quantity_used DOUBLE NOT NULL,
    date_used TIMESTAMP NOT NULL,
    final_product VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_user_id (user_id),
    INDEX idx_coffee_lot_id (coffee_lot_id),
    INDEX idx_date_used (date_used),
    INDEX idx_created_at (created_at),
    FOREIGN KEY (coffee_lot_id) REFERENCES lots(id) ON DELETE CASCADE
);
```

## Reglas de Negocio

1. **Cantidad Positiva**: La cantidad consumida debe ser mayor a cero
2. **Fecha Válida**: La fecha de consumo no puede ser nula
3. **Producto Final**: El producto final no puede estar vacío
4. **Lote Existente**: El lote de café debe existir en el bounded context coffeeproduction
5. **Usuario Válido**: El usuario debe estar autenticado

## Ejecución

Para ejecutar el bounded context `coffeemanagement`:

1. Asegúrate de que el bounded context `coffeeproduction` esté funcionando
2. Ejecuta la migración de base de datos: `V1_2__create_inventory_entries.sql`
3. Inicia la aplicación Spring Boot
4. El frontend debe estar configurado para usar la URL del backend

## Próximos Pasos

1. Implementar validaciones adicionales de negocio
2. Agregar métricas de consumo por período
3. Implementar alertas de stock bajo
4. Agregar reportes de consumo
5. Implementar auditoría de cambios 