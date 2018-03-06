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


insert into CocinaEntity ( id, ubicacion, capacidad ) values ( 20,'8871 Merry Point','2008');
insert into CocinaEntity ( id, ubicacion, capacidad ) values ( 21,'7303 Troy Placet','2048');
insert into CocinaEntity ( id, ubicacion, capacidad ) values ( 38,'652 Lukken Junction','2308');
insert into CocinaEntity ( id, ubicacion, capacidad ) values ( 40,'15 Hoepker Plaza','208');
insert into CocinaEntity ( id, ubicacion, capacidad ) values ( 50,'8871 Merry Point','28');
insert into CocinaEntity ( id, ubicacion, capacidad ) values ( 16,'29 Larry Parkway','2028');
insert into CocinaEntity ( id, ubicacion, capacidad ) values ( 17,'5073 Lakeland Lane','38');
insert into CocinaEntity ( id, ubicacion, capacidad ) values ( 18,'3 Meadow Ridge Plaza','4008');




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


insert into ComidaEntity (id,cantidad,alimentos,TIPO) values (01,400,'ejemplo 1', 'almuerzo');
insert into ComidaEntity (id,cantidad,alimentos,TIPO) values (02,100,'ejemplo 2', 'desayuno');
insert into ComidaEntity (id,cantidad,alimentos,TIPO) values (03,800,'ejemplo 3', 'cena');
insert into ComidaEntity (id,cantidad,alimentos,TIPO) values (04,700,'ejemplo 4', 'adicional');
insert into ComidaEntity (id,cantidad,alimentos,TIPO) values (05,600,'ejemplo 5', 'almuerzo');
insert into ComidaEntity (id,cantidad,alimentos,TIPO) values (06,400,'ejemplo 6', 'cena');
insert into ComidaEntity (id,cantidad,alimentos,TIPO) values (07,300,'ejemplo 8', 'desayuno');
insert into ComidaEntity (id,cantidad,alimentos,TIPO) values (08,1200,'ejemplo7', 'cena');

insert into EnvioEntity (id,duracion,direccion,recibido) values (01,10,'ejemplo 1', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (02,20,'ejemplo 2', 0);
insert into EnvioEntity (id,duracion,direccion,recibido) values (03,30,'ejemplo 3', 0);
insert into EnvioEntity (id,duracion,direccion,recibido) values (04,40,'ejemplo 4', 0);
insert into EnvioEntity (id,duracion,direccion,recibido) values (05,50,'ejemplo 5', 1);
insert into EnvioEntity (id,duracion,direccion,recibido)) values (06,60,'ejemplo 6', 0);
insert into EnvioEntity (id,duracion,direccion,recibido) values (07,70,'ejemplo 8', 0);
insert into EnvioEntity (id,duracion,direccion,recibido) values (08,80,'ejemplo7', 1);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (22, 'no sal', '20/01/2018', true);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (23, 'no sal', '20/02/2018', false);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (24, 'no sal', '10/02/2018', true);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (25, 'no sal', '05/02/2018', true);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (26, 'no sal', '03/02/2018', false);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (27, 'no sal', '27/02/2018', true);

insert into SemanaEntity(id, fechaLunes) values (33,'05/02/2018');
insert into SemanaEntity(id, fechaLunes) values (34,'22/01/2018');
insert into SemanaEntity(id, fechaLunes) values (35,'05/02/2018');
insert into SemanaEntity(id, fechaLunes) values (36,'29/01/2018');
insert into SemanaEntity(id, fechaLunes) values (37,'01/01/2018');

insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta) values(44, 5, 1); 
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta) values(45, 3, 2);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta) values(46, 7, 3);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta) values(47, 8, 4);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta) values(48, 2, 5);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta) values(49, 1, 6);

