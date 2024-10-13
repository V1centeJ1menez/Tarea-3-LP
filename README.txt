# README.txt

## No Java Sky

Este proyecto es parte de la materia de Lenguajes de Programación (LP) y está diseñado para ofrecer una experiencia interactiva de juego en Java. 

### Descripción

El juego permite a los jugadores interactuar con varios elementos en un universo ficticio, donde pueden explorar diferentes planetas y gestionar recursos.
A través de un sistema de menús, los jugadores pueden tomar decisiones que afectarán el curso del juego.

### Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

```
Tarea3LP_202373523-k/                # Raíz del proyecto
│
├── bin/                             # Carpeta donde se guardarán los archivos .class compilados
│
├── src/                             # Carpeta de código fuente
│   └── usm/                         # Paquete principal
│       └── vjimenez/                # Subpaquete
│           └── nojavasky/           # Subpaquete para el juego
│               ├── hud/             # Carpeta para la interfaz de usuario
│               │   ├── estados/      # Estados del juego
│               │   │   ├── EstadoCentroGalactico.java
│               │   │   ├── EstadoExtraccionRecursos.java
│               │   │   ├── EstadoMainMenu.java
│               │   │   ├── EstadoOrbita.java
│               │   │   ├── EstadoVisitaAsentamientos.java
│               │   │   └── EstadoVisitandoPlaneta.java
│               │   └── GameStateManager.java
│               │
│               ├── juego/           # Lógica del juego
│               │   ├── controladores/ # Controladores del juego
│               │   │   ├── Jugador.java
│               │   │   ├── Nave.java
│               │   │   └── MapaGalactico.java
│               │   ├── entidades/    # Entidades del juego
│               │   │   ├── Alienigena.java
│               │   │   ├── planetas/ # Planetas del juego
│               │   │   │   ├── Planeta.java
│               │   │   │   └── tipos/ # Tipos de planetas
│               │   │   │       ├── CentroGalactico.java
│               │   │   │       ├── Helado.java
│               │   │   │       ├── Oceanico.java
│               │   │   │       ├── Radioactivo.java
│               │   │   │       └── Volcanico.java
│               │   │   └── inventario/ # Sistema de inventario
│               │   │       └── Inventario.java
│               │   └── utilidad/     # Clases utilitarias
│               │       └── Utilidad.java
│               │
│               └── NoJavaSky.java   # Clase principal
│
├── Makefile                          # Archivo Makefile para la compilación y ejecución
└── README.txt                        # Archivo de documentación del proyecto

```

### Requisitos

- Java JDK 21.0.4 o superior
- Un sistema operativo compatible (Linux, Windows, macOS)

### Compilación y Ejecución

Para compilar y ejecutar el proyecto, utiliza el siguiente comando en la terminal:

1. Abre la terminal y navega al directorio del proyecto:
   ```bash
   cd /ruta/a/Tarea3LP_202373523-k
   ```

2. Compila el proyecto:
   ```bash
   make
   ```

3. Ejecuta el juego:
   ```bash
   make run
   ```

### Limpieza

Para limpiar los archivos `.class` generados, utiliza el siguiente comando:
```bash
make clean
```


