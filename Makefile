# Definición de variables
JC = javac  # El compilador de Java que se utilizará para compilar los archivos .java
SRC_DIR = src/usm/vjimenez/nojavasky  # Directorio fuente donde se encuentran los archivos Java
BIN_DIR = bin  # Directorio de salida donde se almacenarán los archivos .class compilados
MAIN_CLASS = usm.vjimenez.nojavasky.NoJavaSky  # Clase principal del programa

# Definición de clases que se deben compilar
CLASSES = \
    $(SRC_DIR)/*.java \  # Todos los archivos .java en el directorio fuente
    $(SRC_DIR)/hud/*.java \  # Todos los archivos .java en el subdirectorio hud
    $(SRC_DIR)/hud/estados/*.java \  # Todos los archivos .java en el subdirectorio hud/estados
    $(SRC_DIR)/juego/controladores/*.java \  # Todos los archivos .java en el subdirectorio juego/controladores
    $(SRC_DIR)/juego/entidades/*.java \  # Todos los archivos .java en el subdirectorio juego/entidades
    $(SRC_DIR)/juego/entidades/planetas/*.java \  # Todos los archivos .java en el subdirectorio juego/entidades/planetas
    $(SRC_DIR)/juego/entidades/planetas/tipos/*.java \  # Todos los archivos .java en el subdirectorio juego/entidades/planetas/tipos
    $(SRC_DIR)/juego/inventario/*.java \  # Todos los archivos .java en el subdirectorio juego/inventario
    $(SRC_DIR)/utilidad/*.java  # Todos los archivos .java en el subdirectorio utilidad

# Objetivo por defecto que se ejecuta al llamar `make`
default: classes

# Objetivo para compilar las clases
classes:
	mkdir -p $(BIN_DIR)  # Crea el directorio de salida si no existe
	$(JC) -d $(BIN_DIR) $(CLASSES)  # Compila los archivos .java y los coloca en el directorio de salida

# Objetivo para ejecutar el programa
run: classes  # Asegúrate de que las clases estén compiladas antes de ejecutar
	java -cp $(BIN_DIR) $(MAIN_CLASS)  # Ejecuta la clase principal

# Objetivo para limpiar los archivos compilados
clean:
	rm -rf $(BIN_DIR)/*.class  # Elimina todos los archivos .class en el directorio de salida
