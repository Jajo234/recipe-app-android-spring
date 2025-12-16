# Arquitectura del Sistema – Recipe App

Este documento describe la arquitectura general del sistema Recipe App, definiendo cómo interactúan la aplicación Android y el backend, así como la organización interna del backend con Spring Boot.

---

## 1. Visión General

El sistema está compuesto por dos componentes principales:

- **Aplicación Android** desarrollada en **Kotlin**, encargada de la interfaz de usuario y la interacción con el usuario final.
- **Backend** desarrollado en **Spring Boot**, encargado de la lógica de negocio, seguridad y persistencia de datos.

La comunicación entre ambos se realiza mediante una **API REST** usando **HTTP/HTTPS** y formato **JSON**.

---

## 2. Arquitectura General

```
[ Android App (Kotlin) ]
            |
            |  HTTP (JSON)
            v
[ Backend API (Spring Boot) ]
            |
            v
[ Base de Datos ]
```

---

## 3. Arquitectura del Backend (Spring Boot)

El backend sigue una **arquitectura en capas**, lo que facilita el mantenimiento, pruebas y escalabilidad del sistema.

### 3.1 Capas del Backend

#### 1. Controller (Capa de Presentación)
- Expone los endpoints REST.
- Recibe las peticiones desde la app Android.
- Valida datos básicos de entrada.
- No contiene lógica de negocio.

Ejemplo:
- `AuthController`
- `RecipeController`

---

#### 2. Service (Capa de Negocio)
- Contiene la lógica principal del sistema.
- Aplica reglas de negocio.
- Orquesta las operaciones entre repositorios.

Ejemplo:
- `UserService`
- `RecipeService`

---

#### 3. Repository (Capa de Persistencia)
- Se encarga del acceso a la base de datos.
- Usa Spring Data JPA.
- Define operaciones CRUD.

Ejemplo:
- `UserRepository`
- `RecipeRepository`

---

#### 4. Model (Capa de Dominio)
- Contiene las entidades JPA.
- Representa el modelo de datos del sistema.

Ejemplo:
- `User`
- `Recipe`
- `Category`

---

## 4. Seguridad

- Autenticación basada en **JWT (JSON Web Token)**.
- El usuario se autentica con email y contraseña.
- El backend genera un token que la app Android envía en cada petición.
- Las contraseñas se almacenan cifradas.

---

## 5. Responsabilidades por Componente

### Aplicación Android
- Interfaz de usuario.
- Validaciones básicas de formularios.
- Consumo de la API REST.
- Manejo del token de autenticación.

### Backend
- Autenticación y autorización.
- Lógica de negocio.
- Validaciones complejas.
- Persistencia de datos.

---

## 6. Escalabilidad y Mantenibilidad

- Separación clara de responsabilidades.
- Arquitectura desacoplada.
- Permite agregar nuevas funcionalidades (comentarios, etiquetas, dificultad).

---

## 7. Tecnologías Utilizadas

- Android: Kotlin
- Backend: Spring Boot
- Comunicación: REST + JSON
- Base de datos: PostgreSQL / H2 (desarrollo)
- Seguridad: JWT

---

## 8. Conclusión

La arquitectura propuesta garantiza un sistema modular, mantenible y alineado con buenas prácticas de desarrollo backend y mobile.

