# Modelo de Datos - Recipe App

Este documento define las entidades principales del sistema Recipe App, sus atributos y relaciones, alineados con los requisitos funcionales y casos de uso.

## Entidad: Usuario
Descripción: Representa a las personas que usan la aplicación.

### Atributos 
- id (Long): Identificador único del usuario.
- email (String): Correo electrónico del usuario (único).
- password (String): Contraseña del usuario.
- createdAt (LocalDateTime): Fecha de creación de la cuenta.

### Relaciones 
- Un usuario puede crear muchas recetas.
- Un usuario puede tener muchas recetas favoritas.
- Un usuario puede calificar muchas recetas.

---

## Entidad: Receta
Descripción: Representa una receta creada por un usuario.

### Atributos 
- id (Long): Identificador único de la receta.
- title (String): Nombre de la receta.
- description (String): Descripción general de la receta.
- ingredients (Text): Lista o texto con los ingredientes.
- steps (Text): Pasos para preparar la receta.
- imageUrl (String): Imagen del plato
- createdAt (LocalDateTime): Fecha de creación de la receta.

### Relaciones 
- Una receta pertenece a un usuario.
- Una receta pertenece a una categoría.
- Una receta puede ser marcada como favorita por muchos usuarios.
- Una receta puede tener muchas calificaciones.

---

## Entidad: Categoría
Descripción: Clasifica las recetas por tipo.

### Atributos 
- id (Long): Identificador único de la categoría.
- name (String): Nombre de la categoría.

### Relaciones 
- Una categoría puede tener muchas recetas.

---

## Entidad: Favorito
Descripción: Relación que permite a un usuario guardar recetas favoritas.

### Atributos 
- id (Long): Identificador único del favorito.
- createdAt (LocalDateTime): Fecha en la que la receta fue marcada como favorita.

### Relaciones 
- Un Favorito pertenece a un Usuario
- Un Favorito pertenece a una Receta

---

## Entidad: Calificación
Descripción: Representa la valoración que un usuario da a una receta.

### Atributos 
- id (Long): Identificador único de la calificación.
- score (Integer): Valor de la calificación (por ejemplo, de 1 a 5).
- comment (String): Comentario opcional del usuario.
- createdAt (LocalDateTime): Fecha de la calificación.

### Relaciones 
- Una Calificación pertenece a un Usuario
- Una Calificación pertenece a una Receta

## Resumen de Relaciones

- Usuario 1:N Receta
- Categoría 1:N Receta
- Usuario N:M Receta (mediante Favorito)
- Usuario 1:N Calificación
- Receta 1:N Calificación

## Consideraciones

- Las contraseñas se almacenan cifradas (hash).
- Las relaciones N:M se manejan mediante entidades intermedias.
- El modelo es extensible (ej. comentarios, etiquetas, dificultad).