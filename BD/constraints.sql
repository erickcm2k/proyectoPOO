-- Constraints tabla usuario
ALTER TABLE usuario
ADD CONSTRAINT usuario_pkey
PRIMARY KEY(id);

-- Constraints tabla teléfono
ALTER TABLE telefono
ADD CONSTRAINT id_usuario_fkey
FOREIGN KEY(id_usuario) REFERENCES usuario(id)
-- ON DELETE SET NULL 
ON UPDATE CASCADE;

ALTER TABLE telefono
ADD CONSTRAINT telefono_pkey
PRIMARY KEY(id_usuario, telefono);

-- Constraints tabla material
ALTER TABLE material
ADD CONSTRAINT material_pkey
PRIMARY KEY(id);

-- Constraints tabla materia
ALTER TABLE materia
ADD CONSTRAINT materia_pkey
PRIMARY KEY(id_materia);

-- Constraints tabla préstamo
ALTER TABLE prestamo
ADD CONSTRAINT id_persona_fkey
FOREIGN KEY(id_persona) REFERENCES usuario(id)
-- ON DELETE SET NULL 
ON UPDATE CASCADE;

ALTER TABLE prestamo
ADD CONSTRAINT id_material_fkey
FOREIGN KEY(id_material) REFERENCES material(id)
-- ON DELETE SET NULL 
ON UPDATE CASCADE;

ALTER TABLE prestamo
ADD CONSTRAINT prestamo_pkey
PRIMARY KEY(id_prestamo, id_persona, id_material);



-- Constraints tabla docente_imparte_materia
ALTER TABLE docente_imparte_materia
ADD CONSTRAINT id_docente_fkey
FOREIGN KEY(id_docente) REFERENCES usuario(id);

ALTER TABLE docente_imparte_materia
ADD CONSTRAINT id_materia_fkey
FOREIGN KEY(id_materia) REFERENCES materia(id_materia);

ALTER TABLE docente_imparte_materia
ADD CONSTRAINT docente_imparte_materia_pkey
PRIMARY KEY(id_docente, id_materia);



