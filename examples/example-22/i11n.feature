# language: es

Necesidad del negocio: Los clientes pueden iniciar sesión en la tienda online.
    Puedo escribir lo que quiera aquí, esto es para humanos.

@una-etiqueta @otra-etiqueta
Escenario: El usuario no inicia sesión correctamente
    Dado que el usuario navega a la página de inicio
    Cuando el usuario "John" inicia sesión
    Entonces el usuario no debería iniciar sesión.