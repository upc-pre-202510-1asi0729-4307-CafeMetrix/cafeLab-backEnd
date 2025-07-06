# Diagramas de Bounded Contexts

Este directorio contiene los diagramas PlantUML que representan la arquitectura de los bounded contexts en CafeLab.

## Bounded Context de Production

### 1. `production-bounded-context.puml`
**Diagrama detallado del bounded context de Production**

Este diagrama muestra:
- **Domain Layer**: Agregados, Value Objects, Commands y Services
- **Application Layer**: Implementaciones de servicios y Facade
- **Infrastructure Layer**: Repositorios JPA
- **Interfaces Layer**: Controladores REST, Resources y Transformers

**Características:**
- Muestra todas las clases e interfaces del bounded context
- Incluye relaciones detalladas entre componentes
- Usa colores para distinguir las capas arquitectónicas
- Representa la implementación completa del patrón CQRS

### 2. `production-hexagonal-architecture.puml`
**Diagrama simplificado de la arquitectura hexagonal**

Este diagrama muestra:
- **Domain Core**: Entidades principales y servicios de dominio
- **Application Services**: Orquestación de casos de uso
- **Infrastructure Adapters**: Adaptadores de persistencia
- **Interface Adapters**: Controladores REST y DTOs

**Características:**
- Vista simplificada de la arquitectura hexagonal
- Enfoque en las capas principales
- Relaciones entre adaptadores y dominio
- Ideal para presentaciones y documentación general

## Bounded Context de Management (Inventory)

### 3. `management-bounded-context.puml`
**Diagrama detallado del bounded context de Management**

Este diagrama muestra:
- **Domain Layer**: Agregado InventoryEntry, Value Object FinalProduct, Commands y Services
- **Application Layer**: Implementaciones de servicios y ManagementContextFacade
- **Infrastructure Layer**: Repositorio JPA para persistencia
- **Interfaces Layer**: Controlador REST, Resources y Transformers

**Características:**
- Muestra la gestión de inventario de productos finales
- Incluye relaciones detalladas entre componentes
- Usa colores para distinguir las capas arquitectónicas
- Implementa el patrón CQRS para operaciones de inventario

### 4. `management-hexagonal-architecture.puml`
**Diagrama simplificado de la arquitectura hexagonal de Management**

Este diagrama muestra:
- **Domain Core**: Entidad InventoryEntry y servicios de dominio
- **Application Services**: Orquestación de casos de uso de inventario
- **Infrastructure Adapters**: Adaptador de persistencia para inventario
- **Interface Adapters**: Controlador REST y DTOs para inventario

**Características:**
- Vista simplificada de la arquitectura hexagonal para gestión
- Enfoque en las operaciones de inventario
- Relaciones entre adaptadores y dominio
- Ideal para presentaciones y documentación general

## Archivos de Diagramas

### 1. `production-bounded-context.puml`
**Diagrama detallado del bounded context de Production**

Este diagrama muestra:
- **Domain Layer**: Agregados, Value Objects, Commands y Services
- **Application Layer**: Implementaciones de servicios y Facade
- **Infrastructure Layer**: Repositorios JPA
- **Interfaces Layer**: Controladores REST, Resources y Transformers

**Características:**
- Muestra todas las clases e interfaces del bounded context
- Incluye relaciones detalladas entre componentes
- Usa colores para distinguir las capas arquitectónicas
- Representa la implementación completa del patrón CQRS

### 2. `production-hexagonal-architecture.puml`
**Diagrama simplificado de la arquitectura hexagonal**

Este diagrama muestra:
- **Domain Core**: Entidades principales y servicios de dominio
- **Application Services**: Orquestación de casos de uso
- **Infrastructure Adapters**: Adaptadores de persistencia
- **Interface Adapters**: Controladores REST y DTOs

**Características:**
- Vista simplificada de la arquitectura hexagonal
- Enfoque en las capas principales
- Relaciones entre adaptadores y dominio
- Ideal para presentaciones y documentación general

## Cómo Visualizar los Diagramas

### Opción 1: PlantUML Online
1. Ve a [PlantUML Online Server](http://www.plantuml.com/plantuml/uml/)
2. Copia el contenido del archivo `.puml`
3. Pega en el editor
4. El diagrama se generará automáticamente

### Opción 2: Extensiones de IDE
- **VS Code**: Instala la extensión "PlantUML"
- **IntelliJ IDEA**: Instala el plugin "PlantUML integration"
- **Eclipse**: Instala el plugin "PlantUML"

### Opción 3: Línea de Comandos
```bash
# Instalar PlantUML
npm install -g plantuml

# Generar PNG
plantuml production-bounded-context.puml

# Generar SVG
plantuml -tsvg production-bounded-context.puml
```

## Estructura de los Bounded Contexts

### Bounded Context de Production

#### Domain Layer
- **Aggregates**: CoffeeLot, RoastProfile, Supplier
- **Value Objects**: CoffeeLotName, CoffeeType, ProcessingMethod, etc.
- **Commands**: CreateCoffeeLotCommand, UpdateCoffeeLotCommand, etc.
- **Services**: Interfaces para comandos y consultas

#### Application Layer
- **Internal**: Implementaciones de servicios de aplicación
- **ACL**: CoffeeproductionContextFacade para comunicación entre bounded contexts

#### Infrastructure Layer
- **Persistence**: Repositorios JPA para persistencia de datos

#### Interfaces Layer
- **REST**: Controladores REST para exponer la API
- **Resources**: DTOs para la comunicación con el frontend
- **Transform**: Ensambladores para convertir entre recursos y comandos

### Bounded Context de Management (Inventory)

#### Domain Layer
- **Aggregates**: InventoryEntry
- **Value Objects**: FinalProduct
- **Commands**: CreateInventoryEntryCommand, UpdateInventoryEntryCommand, DeleteInventoryEntryCommand
- **Services**: Interfaces para comandos y consultas de inventario

#### Application Layer
- **Internal**: Implementaciones de servicios de aplicación para inventario
- **ACL**: ManagementContextFacade para comunicación entre bounded contexts

#### Infrastructure Layer
- **Persistence**: Repositorio JPA para persistencia de datos de inventario

#### Interfaces Layer
- **REST**: Controlador REST para exponer la API de inventario
- **Resources**: DTOs para la comunicación con el frontend
- **Transform**: Ensambladores para convertir entre recursos y comandos

## Patrones Arquitectónicos Utilizados

1. **Arquitectura Hexagonal (Ports & Adapters)**
2. **Domain-Driven Design (DDD)**
3. **Command Query Responsibility Segregation (CQRS)**
4. **Repository Pattern**
5. **Facade Pattern**

## Endpoints REST

### Bounded Context de Production

#### Coffee Lots
- `POST /api/v1/coffee-lots` - Crear lote de café
- `GET /api/v1/coffee-lots` - Listar todos los lotes
- `GET /api/v1/coffee-lots/{id}` - Obtener lote por ID
- `PUT /api/v1/coffee-lots/{id}` - Actualizar lote
- `DELETE /api/v1/coffee-lots/{id}` - Eliminar lote

#### Roast Profiles
- `POST /api/v1/roast-profile` - Crear perfil de tostado
- `GET /api/v1/roast-profile` - Listar todos los perfiles
- `GET /api/v1/roast-profile/{id}` - Obtener perfil por ID
- `PUT /api/v1/roast-profile/{id}` - Actualizar perfil
- `DELETE /api/v1/roast-profile/{id}` - Eliminar perfil

#### Suppliers
- `POST /api/v1/suppliers` - Crear proveedor
- `GET /api/v1/suppliers` - Listar todos los proveedores
- `GET /api/v1/suppliers/{id}` - Obtener proveedor por ID
- `PUT /api/v1/suppliers/{id}` - Actualizar proveedor
- `DELETE /api/v1/suppliers/{id}` - Eliminar proveedor

### Bounded Context de Management (Inventory)

#### Inventory Entries
- `POST /api/v1/inventory-entries` - Crear entrada de inventario
- `GET /api/v1/inventory-entries` - Listar todas las entradas de inventario
- `GET /api/v1/inventory-entries/{id}` - Obtener entrada de inventario por ID
- `PUT /api/v1/inventory-entries/{id}` - Actualizar entrada de inventario
- `DELETE /api/v1/inventory-entries/{id}` - Eliminar entrada de inventario
- `GET /api/v1/inventory-entries/user/{userId}` - Obtener entradas de inventario por usuario

## Convenciones de Nomenclatura

- **Aggregates**: Nombres en singular (CoffeeLot, RoastProfile)
- **Value Objects**: Nombres descriptivos (CoffeeLotName, ProcessingMethod)
- **Commands**: Sufijo "Command" (CreateCoffeeLotCommand)
- **Services**: Sufijo "Service" (CoffeeLotCommandService)
- **Controllers**: Sufijo "Controller" (CoffeeLotsController)
- **Resources**: Sufijo "Resource" (CoffeeLotResource)
- **Repositories**: Sufijo "Repository" (CoffeeLotRepository) 