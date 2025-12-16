# Casos de Uso – Recipe App

Este documento describe los principales casos de uso del sistema Recipe App, los cuales detallan la interacción entre el usuario y el sistema para cumplir los requisitos funcionales definidos.

## Actor principal
- Usuario

## CU-01: Registro de usuario

**Actor:** Usuario  
**Descripción:** El usuario crea una cuenta en el sistema para acceder a las funcionalidades de la aplicación.  
**Requisitos asociados:** RF-01  

### Flujo principal
1. El usuario ingresa su correo electrónico y contraseña.
2. El sistema valida la información ingresada.
3. El sistema registra al usuario correctamente.
4. El sistema confirma el registro.

### Flujos alternos
- 2a. El correo electrónico ya se encuentra registrado → el sistema muestra un mensaje de error.

---

## CU-02: Iniciar sesión

**Actor:** Usuario  
**Descripción:** El usuario accede al sistema mediante sus credenciales.  
**Requisitos asociados:** RF-02  

### Flujo principal
1. El usuario ingresa su correo electrónico y contraseña.
2. El sistema valida las credenciales.
3. El sistema permite el acceso al usuario.

### Flujos alternos
- 2a. Las credenciales son incorrectas → el sistema muestra un mensaje de error.

---

## CU-03: Crear receta

**Actor:** Usuario  
**Descripción:** El usuario crea una nueva receta dentro del sistema.  
**Requisitos asociados:** RF-05  

### Flujo principal
1. El usuario accede a la opción de crear receta.
2. El usuario ingresa la información de la receta.
3. El sistema valida los datos ingresados.
4. El sistema guarda la receta.
5. El sistema confirma la creación de la receta.

### Flujos alternos
- 3a. La información ingresada es incompleta → el sistema solicita corregir los datos.

---

## CU-04: Ver lista de recetas

**Actor:** Usuario  
**Descripción:** El usuario visualiza una lista de recetas disponibles en el sistema.  
**Requisitos asociados:** RF-06  

### Flujo principal
1. El usuario accede a la sección de recetas.
2. El sistema obtiene las recetas disponibles.
3. El sistema muestra la lista de recetas al usuario.

---

## CU-05: Ver detalle de receta

**Actor:** Usuario  
**Descripción:** El usuario visualiza la información detallada de una receta.  
**Requisitos asociados:** RF-07  

### Flujo principal
1. El usuario selecciona una receta.
2. El sistema obtiene la información de la receta.
3. El sistema muestra el detalle de la receta.

---

## CU-06: Guardar receta como favorita

**Actor:** Usuario  
**Descripción:** El usuario guarda una receta para acceder a ella posteriormente.  
**Requisitos asociados:** RF-10  

### Flujo principal
1. El usuario selecciona una receta.
2. El usuario marca la receta como favorita.
3. El sistema guarda la receta en la lista de favoritos del usuario.
4. El sistema confirma la acción.

---

## CU-07: Editar receta

**Actor:** Usuario  
**Descripción:** El usuario modifica una receta creada previamente por él.  
**Requisitos asociados:** RF-08  

### Flujo principal
1. El usuario selecciona una de sus recetas.
2. El usuario edita la información de la receta.
3. El sistema valida los cambios.
4. El sistema guarda la información actualizada.
5. El sistema confirma la modificación.

### Flujos alternos
- 1a. El usuario intenta editar una receta que no le pertenece → el sistema restringe la acción.

---

## CU-08: Eliminar receta

**Actor:** Usuario  
**Descripción:** El usuario elimina una receta creada previamente por él.  
**Requisitos asociados:** RF-09  

### Flujo principal
1. El usuario selecciona una de sus recetas.
2. El usuario confirma la eliminación.
3. El sistema elimina la receta.
4. El sistema confirma la eliminación.
