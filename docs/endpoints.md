# Diseño de Endpoints REST – Recipe App

Este documento define los endpoints REST del backend de Recipe App, especificando las operaciones disponibles, los métodos HTTP y el propósito de cada endpoint. Estos endpoints serán consumidos por la aplicación Android.

---

## 1. Autenticación

### POST /auth/register
**Descripción:** Registra un nuevo usuario en el sistema.

**Request Body:**
- email
- password

**Response:**
- Usuario creado correctamente

---

### POST /auth/login
**Descripción:** Permite al usuario iniciar sesión.

**Request Body:**
- email
- password

**Response:**
- JWT token

---

## 2. Usuarios

### GET /users/me
**Descripción:** Obtiene la información del usuario autenticado.

**Headers:**
- Authorization: Bearer token

---

## 3. Recetas

### POST /recipes
**Descripción:** Crea una nueva receta.

**Headers:**
- Authorization: Bearer token

**Request Body:**
- title
- description
- ingredients
- steps
- imageUrl
- categoryId

---

### GET /recipes
**Descripción:** Obtiene la lista de recetas.

**Query Params (opcionales):**
- search
- category

---

### GET /recipes/{id}
**Descripción:** Obtiene el detalle de una receta.

---

### PUT /recipes/{id}
**Descripción:** Actualiza una receta existente (solo propietario).

**Headers:**
- Authorization: Bearer token

---

### DELETE /recipes/{id}
**Descripción:** Elimina una receta existente (solo propietario).

**Headers:**
- Authorization: Bearer token

---

## 4. Favoritos

### POST /favorites/{recipeId}
**Descripción:** Marca una receta como favorita.

**Headers:**
- Authorization: Bearer token

---

### GET /favorites
**Descripción:** Obtiene la lista de recetas favoritas del usuario.

**Headers:**
- Authorization: Bearer token

---

### DELETE /favorites/{recipeId}
**Descripción:** Elimina una receta de favoritos.

**Headers:**
- Authorization: Bearer token

---

## 5. Calificaciones

### POST /recipes/{id}/ratings
**Descripción:** Agrega una calificación a una receta.

**Headers:**
- Authorization: Bearer token

**Request Body:**
- score
- comment

---

### GET /recipes/{id}/ratings
**Descripción:** Obtiene las calificaciones de una receta.

---

## 6. Convenciones REST

- Uso correcto de métodos HTTP (GET, POST, PUT, DELETE).
- Endpoints basados en recursos.
- Uso de JSON para requests y responses.
- Autenticación mediante JWT.

---

## 7. Consideraciones

- Los endpoints protegidos requieren token JWT.
- Se validan permisos para edición y eliminación.
- Diseño preparado para futuras extensiones.

