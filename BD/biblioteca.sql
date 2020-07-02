CREATE DATABASE biblioteca;

USE biblioteca;

CREATE TABLE material(
    id INT,
    tipo_material VARCHAR(30),
    titulo VARCHAR(30),
    autor VARCHAR(30),
    anio INT,
    area_conocimiento VARCHAR(30),
    numero_ejemplares VARCHAR(30),
    isbn VARCHAR(30),
    volumen VARCHAR(30),
    numero VARCHAR(30),
    pagina_descarga VARCHAR(30),
    clave_temporal INT
);

CREATE TABLE prestamo(
    id_prestamo INT,
    id_persona INT,
    id_material INT,
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    multa DOUBLE
);

CREATE TABLE usuario(
    id INT,
    nombre VARCHAR(30),
    apellido_paterno VARCHAR(30),
    apellido_materno VARCHAR(30),
    fecha_nacimiento DATE,
    domicilio VARCHAR(30),
    clave INT,
    nombre_usuario VARCHAR(30),
    numero_empleado VARCHAR(30),
    boleta_alumno INT,
    nivel_alumno VARCHAR(30)
);

CREATE TABLE telefono(
    id_usuario INT,
    telefono INT
);

CREATE TABLE materia(
    id_materia INT,
    nombre VARCHAR(30)
);

CREATE TABLE docente_imparte_materia(
    id_docente INT,
    id_materia INT
);
