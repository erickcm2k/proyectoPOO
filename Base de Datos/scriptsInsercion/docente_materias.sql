select p.id, p.nombre, p.apellido_paterno, p.apellido_materno, p.fecha_nacimiento, p.domicilio, p.clave, p.nombre_usuario, p.numero_empleado, 
       dim.id_docente, dim.id_materia, 
       mat.id, mat.nombre 
from persona as p
join docente_imparte_materia as dim
on p.id = dim.id_docente
join materia as mat
on dim.id_materia = mat.id
order by p.id;


insert into docente_imparte_materia (id_docente, id_materia) values (2, 5);
insert into docente_imparte_materia (id_docente, id_materia) values (3, 1);
insert into docente_imparte_materia (id_docente, id_materia) values (4, 4);
insert into docente_imparte_materia (id_docente, id_materia) values (5, 4);
insert into docente_imparte_materia (id_docente, id_materia) values (6, 1);
insert into docente_imparte_materia (id_docente, id_materia) values (7, 2);
insert into docente_imparte_materia (id_docente, id_materia) values (8, 4);
insert into docente_imparte_materia (id_docente, id_materia) values (9, 1);
insert into docente_imparte_materia (id_docente, id_materia) values (1, 3);
insert into docente_imparte_materia (id_docente, id_materia) values (8, 1);
insert into docente_imparte_materia (id_docente, id_materia) values (8, 2);
insert into docente_imparte_materia (id_docente, id_materia) values (4, 5);
insert into docente_imparte_materia (id_docente, id_materia) values (10, 3);
insert into docente_imparte_materia (id_docente, id_materia) values (2, 4);
insert into docente_imparte_materia (id_docente, id_materia) values (1, 5);
insert into docente_imparte_materia (id_docente, id_materia) values (1, 1);
insert into docente_imparte_materia (id_docente, id_materia) values (6, 5);
insert into docente_imparte_materia (id_docente, id_materia) values (9, 3);
insert into docente_imparte_materia (id_docente, id_materia) values (5, 6);
insert into docente_imparte_materia (id_docente, id_materia) values (10, 6);
insert into docente_imparte_materia (id_docente, id_materia) values (6, 3);
insert into docente_imparte_materia (id_docente, id_materia) values (7, 3);
insert into docente_imparte_materia (id_docente, id_materia) values (8, 3);
insert into docente_imparte_materia (id_docente, id_materia) values (9, 2);
insert into docente_imparte_materia (id_docente, id_materia) values (3, 4);