[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/peyjF4Bv)
[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=13562379&assignment_repo_type=AssignmentRepo)
# Tres en Raya

¡Vamos a jugar al tres en raya!

Pero no de forma interactiva. Nuestro código será capaz de representar una partida de tres en raya, pero no de jugarla. Jugaremos la versión del juego "en papel", es decir, aquella en la que no se pueden mover las fichas.

Esta vez, la implementación tiene que ser orientada a objetos.

En el fichero ejemplo.txt encontrarás la salida esperada al ejecutar el método main proporcionado.

Debes implementar y documentar las siguientes clases, de forma que superen los tests unitarios:
- **Ficha**: representa las fichas X y O, y debe ser capaz de decir a qué ficha corresponde el siguiente turno.
- **Partida**: gestiona las partidas, es decir, la creación de nuevas partidas, la recepción de las jugadas, el control de turnos (siempre empiezan las X) y la finalización del juego.
- **Tablero**: alberga las fichas que ya han sido jugadas, y realiza las operaciones sobre el tablero.

El diagrama de clases (incompleto, pues no incluye las relaciones ni métodos privados), es el siguiente:

![Diagrama de clases](./prog_prac06-clases.png)

No dejes todo para el "último día", empieza a trabajar desde ya, paso a paso. Aprovecha el orden de los test para ir marcando ese paso a paso. Primero haz que TresEnRaya.java y los tests unitarios compilen, sin que funcionen, creando las clases y los métodos necesarios, pero devolviendo false, null... Luego, intenta superar el test 1, luego el 2, ...

## Requisitos:

- Todo el código debe compilar.
- No debes implementar dos veces "lo mismo".
- Los nombres de las variables, constantes, métodos... deberán ser coherentes con su uso.
- La documentación JavaDoc debe ser completa, coherente y correcta.
- Cuida la presentación de tu código.
- Cuida la presentación de tu repositorio (ritmo y mensajes de commit).
- IMPORTANTE: NO SE CORREGIRÁN PRÁCTICAS EN LAS QUE SE ENTREGUE LA SOLUCIÓN "DE GOLPE". DEBÉIS IR HACIENDO COMMITS SEGÚN VAYÁIS AVANZANDO.

## Rúbrica:

- **Tests automáticos:** 1 punto por test --> 10 puntos
    - Test 1: Clase Ficha
    - Test 2: Tablero Vacío
    - Test 3: Creación de Partida
    - Test 4: Casilla Ocupada
    - Test 5: Ganador (en Tablero)
    - Test 6: Ganador (en Partida)
    - Test 7: Tablero Lleno
    - Test 8: Partida Terminada
    - Test 9: Partidas Completas
    - Test 10: Flexibilidad en el tamaño
- **Revisión manual:** 10 puntos (solo se realizará si se superan los 5 puntos en los tests automáticos)
 
