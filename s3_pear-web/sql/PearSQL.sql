delete from CalificacionEntity;
delete from QuejasyReclamosEntity;
delete from CasoExitoEntity;
delete from PersonaEntity;
delete from DietaTipoEntity;
delete from CocinaEntity;


insert into DietaTipoEntity ( id, objetivo, descripcion ) values ( 1, 'un objetivo inicial', 'una descripcion inicial' );
insert into DietaTipoEntity ( id, objetivo, descripcion ) values ( 2, 'otro objetivo segundo', 'otra descripcion segunda' );
insert into DietaTipoEntity ( id, objetivo, descripcion ) values ( 4, 'Mandatory exuding archive', 'Fundamental exuding database' );
insert into DietaTipoEntity ( id, objetivo, descripcion ) values ( 5, 'Versatile tangible task-force', 'Enterprise-wide coherent access' );
insert into DietaTipoEntity ( id, objetivo, descripcion ) values ( 6, 'Ergonomic solution-oriented support', 'Vision-oriented intermediate matrix' );
insert into DietaTipoEntity ( id, objetivo, descripcion ) values ( 7, 'Balanced tertiary strategy', 'Operative motivating strategy' );
insert into DietaTipoEntity ( id, objetivo, descripcion ) values ( 8, 'Enterprise-wide global architecture', 'Digitized real-time implementation' );
insert into DietaTipoEntity ( id, objetivo, descripcion ) values ( 9, 'Multi-tiered cohesive contingency', 'De-engineered multi-state info-mediaries' );
insert into DietaTipoEntity ( id, objetivo, descripcion ) values ( 10, 'Multi-layered explicit circu', 'ntegrated multimedia initiative' );




insert into CalificacionEntity (id, puntuacion) values (1, 7);
insert into CalificacionEntity (id, puntuacion) values (2, 1);
insert into CalificacionEntity (id, puntuacion) values (3, 1);
insert into CalificacionEntity (id, puntuacion) values (4, 1);
insert into CalificacionEntity (id, puntuacion) values (5, 7);
insert into CalificacionEntity (id, puntuacion) values (6, 8);
insert into CalificacionEntity (id, puntuacion) values (7, 8);



insert into QuejasyReclamosEntity (id, asunto, comentario) values (1,'queja', 'La comida llego fria');
insert into QuejasyReclamosEntity (id, asunto, comentario) values (2,'recomendacion', 'Llamar al cliente cuando el envio este cerca');
insert into QuejasyReclamosEntity (id, asunto, comentario) values (3,'recomendacion', 'Contratar domiciliarios más amables');
insert into QuejasyReclamosEntity (id, asunto, comentario) values (4,'queja', 'el domiciliario fue grosero');



insert into CasoExitoEntity (id, comentario, testimonio) values (1, 'Comentario 1', 'Testimonio 1');
insert into CasoExitoEntity (id, comentario, testimonio) values (2, 'Comentario 2', 'Testimonio 2');
insert into CasoExitoEntity (id, comentario, testimonio) values (3, 'Comentario 3', 'Testimonio 3');
insert into CasoExitoEntity (id, comentario, testimonio) values (4, 'Comentario 4', 'Testimonio 4');
insert into CasoExitoEntity (id, comentario, testimonio) values (5, 'Comentario 5', 'Testimonio 5');
insert into CasoExitoEntity (id, comentario, testimonio) values (6, 'Comentario 6', 'Testimonio 6');
insert into CasoExitoEntity (id, comentario, testimonio) values (7, 'Comentario 7', 'Testimonio 7');
insert into CasoExitoEntity (id, comentario, testimonio) values (8, 'Comentario 8', 'Testimonio 8');
insert into CasoExitoEntity (id, comentario, testimonio) values (9, 'Comentario 9', 'Testimonio 9');
insert into CasoExitoEntity (id, comentario, testimonio) values (10, 'Comentario 10', 'Testimonio 10');

insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (1, 'n1', 'a1', 1, 'd1', 'c1', 0, 'i1');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (2, 'n2', 'a2', 2, 'd2', 'c2', 0, 'i2');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (3, 'n3', 'a3', 3, 'd3', 'c3', 0, 'i3');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (4, 'n4', 'a4', 4, 'd4', 'c4', 0, 'i4');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (5, 'n5', 'a5', 5, 'd5', 'c5', 0, 'i5');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (6, 'n6', 'a6', 6, 'd6', 'c6', 0, 'i6');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (7, 'n7', 'a7', 7, 'd7', 'c7', 0, 'i7');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (8, 'n8', 'a8', 8, 'd8', 'c8', 0, 'i8');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (9, 'n9', 'a9', 9, 'd9', 'c9', 0, 'i9');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (10, 'n10', 'a10', 10, 'd10', 'c10', 0, 'i10');