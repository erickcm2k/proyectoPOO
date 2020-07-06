CREATE DATABASE biblioteca;

USE biblioteca;

CREATE TABLE material( -- (1) -> Libro, (2) -> Revista, (3) -> Material Electrónico
    id INT,
    tipo_material VARCHAR(100),
    titulo VARCHAR(100),
    autor VARCHAR(100),
    anio INT,
    area_conocimiento VARCHAR(100),
    numero_ejemplares INT, -- Termina clase Material
    isbn VARCHAR(100), -- Exclusivo de (1)
    volumen INT, -- Exclusivo de (2)
    numero INT, -- Exclusivo de (2)
    pagina_descarga VARCHAR(100), -- Exclusivo de (3)
    clave_temporal INT -- Exclusivo de (3)
);

CREATE TABLE material_prestado(
    id_material INT,
    id_prestamo INT
);

CREATE TABLE prestamo(
    id INT,
    id_persona INT,
    id_material INT,
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    multa DOUBLE
);

CREATE TABLE persona( -- (1) -> Profesor, (2) -> Alumno, (3) -> Empleado
    id INT,
    nombre VARCHAR(100),
    apellido_paterno VARCHAR(100),
    apellido_materno VARCHAR(100),
    fecha_nacimiento DATE,
    domicilio VARCHAR(100), -- Termina clase Persona
    horario_entrada_empleado INT, -- Exclusivo de (3)
    horario_salida_empleado INT, -- Exclusivo de (3)
    clave_acceso_empleado INT, -- Exclusivo de (3)
    clave INT,
    nombre_usuario VARCHAR(100), -- Termina clase Usuario
    numero_empleado VARCHAR(100), -- Exclusivo de (1)
    boleta_alumno INT, -- Exclusivo de (2)
    nivel_alumno VARCHAR(100) -- Exclusivo de (3)
);

CREATE TABLE telefono(
    id_persona INT,
    telefono VARCHAR(10)
);

CREATE TABLE materia(
    id INT,
    nombre VARCHAR(100)
);

CREATE TABLE docente_imparte_materia(
    id_docente INT,
    id_materia INT
);
