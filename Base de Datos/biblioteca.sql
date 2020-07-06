CREATE DATABASE biblioteca;

USE biblioteca;

CREATE TABLE material(
    id INT,
    tipo_material VARCHAR(30),
    titulo VARCHAR(30),
    autor VARCHAR(30),
    anio INT,
    area_conocimiento VARCHAR(30),
    numero_ejemplares INT,
    isbn VARCHAR(30),
    volumen INT,
    numero INT,
    pagina_descarga VARCHAR(30),
    clave_temporal INT
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
    nombre VARCHAR(30),
    apellido_paterno VARCHAR(30),
    apellido_materno VARCHAR(30),
    fecha_nacimiento DATE,
    domicilio VARCHAR(30), -- Termina clase Persona
    horario_entrada_empleado INT, -- Exclusivo de (3)
    horario_salida_empleado INT, -- Exclusivo de (3)
    clave_acceso_empleado INT, -- Exclusivo de (3)
    clave INT,
    nombre_usuario VARCHAR(30), -- Termina clase Usuario
    numero_empleado VARCHAR(30), -- Exclusivo de (1)
    boleta_alumno INT, -- Exclusivo de (2)
    nivel_alumno VARCHAR(30) -- Exclusivo de (3)
);

CREATE TABLE telefono(
    id_persona INT,
    telefono VARCHAR(10)
);

CREATE TABLE materia(
    id INT,
    nombre VARCHAR(30)
);

CREATE TABLE docente_imparte_materia(
    id_docente INT,
    id_materia INT
);
