-- MATERIAL ~ LIBRO
INSERT INTO material(
id, tipo_material, titulo, autor, anio, area_conocimiento, numero_ejemplares, isbn
)
VALUES("", "", "", "", "", "", "", "");
-- MATERIAL ~ REVISTA
INSERT INTO material(
id, tipo_material, titulo, autor, anio, area_conocimiento, numero_ejemplares, volumen, numero
)
VALUES("", "", "", "", "", "", "", "", "");
-- MATERIAL ~ MATERIAL ELECTRÓNICO
INSERT INTO material(
id, tipo_material, titulo, autor, anio, area_conocimiento, numero_ejemplares, pagina_descarga, clave_temporal
)
VALUES("", "", "", "", "", "", "", "", "");



-- PRESTAMO
INSERT INTO prestamo(
    id_prestamo, id_persona, id_material, fecha_prestamo, fecha_devolucion, multa
)
VALUES("", "", "", "", "", "");



-- USUARIO ~ USUARIO COMÚN
INSERT INTO usuario(
    id, nombre, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, clave, nombre_usuario
)
VALUES("", "", "", "", "", "", "", "");
-- USUARIO ~ PROFESOR
INSERT INTO usuario(
    id, nombre, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, clave, nombre_usuario, numero_empleado
)
VALUES("", "", "", "", "", "", "", "", "");
-- USUARIO ~ ALUMNO
INSERT INTO usuario(
    id, nombre, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, clave, nombre_usuario, boleta_alumno, nivel_alumno
)
VALUES("", "", "", "", "", "", "", "", "", "");



-- TELEFONO
INSERT INTO telefono(
    id_usuario, telefono
)
VALUES("", "");



-- MATERIA
INSERT INTO materia(
    id_materia, nombre
)
VALUES("", "");



-- DOCENTE_IMPARTE_MATERIA
INSERT INTO docente_imparte_materia(
    id_docente, id_materia
)
VALUES("", "");