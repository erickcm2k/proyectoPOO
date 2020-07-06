-- Constraints tabla persona
ALTER TABLE persona
ADD CONSTRAINT persona_pkey
PRIMARY KEY(id);

-- Constraints tabla teléfono
ALTER TABLE telefono
ADD CONSTRAINT pid_persona_fkey
FOREIGN KEY(id_persona) REFERENCES persona(id)
-- ON DELETE SET NULL 
ON UPDATE CASCADE;

ALTER TABLE telefono
ADD CONSTRAINT telefono_pkey
PRIMARY KEY(id_persona, telefono);

-- Constraints tabla material
ALTER TABLE material
ADD CONSTRAINT material_pkey
PRIMARY KEY(id);

-- Constraints tabla materia
ALTER TABLE materia
ADD CONSTRAINT materia_pkey
PRIMARY KEY(id);

-- Constraints tabla préstamo
ALTER TABLE prestamo
ADD CONSTRAINT id_ppersona_fkey
FOREIGN KEY(id_persona) REFERENCES persona(id)
-- ON DELETE SET NULL 
ON UPDATE CASCADE;

ALTER TABLE prestamo
ADD CONSTRAINT prestamo_pkey
PRIMARY KEY(id, id_persona, id_material);



-- Constraints tabla docente_imparte_materia
ALTER TABLE docente_imparte_materia
ADD CONSTRAINT id_docente_fkey
FOREIGN KEY(id_docente) REFERENCES persona(id)
-- ON DELETE SET NULL 
ON UPDATE CASCADE;

ALTER TABLE docente_imparte_materia
ADD CONSTRAINT id_materia_fkey
FOREIGN KEY(id_materia) REFERENCES materia(id)
-- ON DELETE SET NULL 
ON UPDATE CASCADE;

ALTER TABLE docente_imparte_materia
ADD CONSTRAINT docente_imparte_materia_pkey
PRIMARY KEY(id_docente, id_materia);



-- Constraints tabla material_prestado
ALTER TABLE material_prestado
ADD CONSTRAINT mpid_material_fkey
FOREIGN KEY(id_material) REFERENCES material(id)
-- ON DELETE SET NULL 
ON UPDATE CASCADE;

ALTER TABLE material_prestado
ADD CONSTRAINT mpid_prestamo_fkey
FOREIGN KEY(id_prestamo) REFERENCES prestamo(id)
-- ON DELETE SET NULL 
ON UPDATE CASCADE;

ALTER TABLE material_prestado
ADD CONSTRAINT material_prestado_pkey
PRIMARY KEY(id_material, id_prestamo);

