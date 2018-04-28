
UPDATE DIETATIPOENTITY SET CUENTACOBRO_ID = NULL, COCINA_ID = NULL;

UPDATE CUENTACOBROENTITY SET DIETA_ID = NULL;
UPDATE FACTURAENTITY SET PERSONA_ID = NULL;

delete from CuentaCobroEntity;
delete from DietaTipoEntity;


delete from CocinaEntity;

delete from ComidaEntity;
delete from EnvioEntity;
delete from DiaEntity;
delete from SemanaEntity;

delete from MedioPagoEntity; 
delete from PagoEntity; 
 

delete from PersonaEntity;
delete from FacturaEntity;


delete from CalificacionEntity;
delete from QuejasyReclamosEntity;
delete from CasoExitoEntity;






insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (1, 'Pablo', 'Suarez', 20, 'Cll. 127D #19-93', 'pa.suarezm@uniandes.edu.co', 0, '201632293');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (2, 'Camilo', 'Bedoya', 20, 'Cll. 151 #9-26', 'jc.bedoya@uniandes.edu.co', 0, '201631591');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (3, 'Carol', 'Trujillo', 19, 'Cra. 53 #127-43', 'cv.trujillo@uniandes.edu.co', 0, '201618005');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (4, 'Mariana', 'Moreno', 20, 'Cll. 76 #7-83', 'mi.morenoa@uniandes.edu.co', 0, '201698416');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (5, 'Juan', 'Suarez', 23, 'Cll. 127D #19-93', 'jm.suarezm@uniandes.edu.co', 0, '201632294');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (6, 'Elsa', 'Murillo', 54, 'Cll. 127D #19-93', 'ev.murilloa@uniandes.edu.co', 0, '201632295');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (7, 'Antonio', 'Suarez', 55, 'Cll. 127D #19-93', 'aj.suarezb@uniandes.edu.co', 0, '201632296');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (8, 'Gustavo', 'Quijano', 63, 'Cra. 7 #116-56', 'g.quijano@uniandes.edu.co', 0, '201632297');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (9, 'Ana', 'Suarez', 65, 'Cll. 151 #9-66', 'ae.suarezb@uniamdes.edu.co', 0, '201632298');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (10, 'Luisa', 'Estrada', 20, 'Cll. 131 #19-86', 'l.estradap@uniandes.edu.co', 0, '201712345');



insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(45, 3, 200418,1);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(46, 7, 300418,2);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(47, 8, 400418,3);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(48, 2, 100518,4);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(49, 1, 200518,5);


insert into PagoEntity(id, montoInicial, montoFinal) values (2, 10, 10);

INSERT INTO DIETATIPOENTITY (DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES ('Enterprise-wide coherent access', 'https://images.pexels.com/photos/248444/pexels-photo-248444.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Dieta Japonesa', 'Versatile tangible task-force', 1, NULL);
insert into CuentaCobroEntity(id, valorAPagar, factura_id ) values (1, 20, 45);





INSERT INTO COCINAENTITY (CAPACIDAD, IMAGEN, "NAME", UBICACION) 
	VALUES ('2008', 'https://images.pexels.com/photos/264636/pexels-photo-264636.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'La Gran Cocina', '8871 Merry Point');
INSERT INTO COCINAENTITY (CAPACIDAD, IMAGEN, "NAME", UBICACION) 
	VALUES ('232', 'https://images.pexels.com/photos/159991/pexels-photo-159991.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Cocina de las Aguas', '7303 Troy Placet');
INSERT INTO COCINAENTITY (CAPACIDAD, IMAGEN, "NAME", UBICACION) 
	VALUES ('2308', 'https://images.pexels.com/photos/225448/pexels-photo-225448.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Central del Norte', '652 Lukken Junction');
INSERT INTO COCINAENTITY (CAPACIDAD, IMAGEN, "NAME", UBICACION) 
	VALUES ('208', 'https://images.pexels.com/photos/2755/restaurant.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Cocina Bogota', '15 Hoepker Plaza');


INSERT INTO DIETATIPOENTITY (DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES ('Vision-oriented intermediate matrix', 'https://images.pexels.com/photos/628777/pexels-photo-628777.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Dieta Verde', 'Ergonomic solution-oriented support', 2, NULL);
INSERT INTO DIETATIPOENTITY (DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES ('Enterprise-wide coherent access', 'https://images.pexels.com/photos/248444/pexels-photo-248444.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Dieta Japonesa', 'Versatile tangible task-force', 1, NULL);
INSERT INTO DIETATIPOENTITY (DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES ('Operative motivating strategy', 'https://images.pexels.com/photos/660282/pexels-photo-660282.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Anti Dieta', 'Balanced tertiary strategy', 5, NULL);
INSERT INTO DIETATIPOENTITY (DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES ('Digitized real-time implementation', 'https://images.pexels.com/photos/628776/pexels-photo-628776.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Dieta Oriental', 'Enterprise-wide global architecture', 4, NULL);
INSERT INTO DIETATIPOENTITY (DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES ('De-engineered multi-state info-mediaries', 'https://images.pexels.com/photos/546945/pexels-photo-546945.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Dieta Italiana', 'Multi-tiered cohesive contingency', 4, NULL);
INSERT INTO DIETATIPOENTITY (DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES ('ntegrated multimedia initiative', 'https://images.pexels.com/photos/629093/pexels-photo-629093.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta de Crudos', 'Multi-layered explicit circu', 3, NULL);
INSERT INTO DIETATIPOENTITY (DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES ('dieta basada en ensaladas o algo asi', 'https://images.pexels.com/photos/5938/food-salad-healthy-lunch.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta Nutricional', 'el objetivo de la dieta es desintoxicarse', 3, NULL);
INSERT INTO DIETATIPOENTITY (DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES ('una dieta basada en proteinas', 'https://images.pexels.com/photos/76093/pexels-photo-76093.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta Deportiva', 'el objetivo de la dieta es obtener masa muscular', 5, NULL);
INSERT INTO DIETATIPOENTITY (DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID, ID ) 
	VALUES ('dieta basada en alimentos del mar', 'https://images.pexels.com/photos/36768/food-salmon-teriyaki-cooking.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta Pacifica', 'el objetivo de la dieta es alejarse de las carnes rojas', 4, NULL, 1);



UPDATE CUENTACOBROENTITY SET DIETA_ID = 1;





insert into MedioPagoEntity(id, medioPagoActual) values (1, 'Baloto');
insert into MedioPagoEntity(id, medioPagoActual) values (2, 'Efectivo');
insert into MedioPagoEntity(id, medioPagoActual) values (3, 'Credito');






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





insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (01,10,'ejemplo1','desayuno'/**,'https://images.pexels.com/photos/70497/pexels-photo-70497.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260'*/);
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (02,187,'ejemplo2','almuerzo'/**,'https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260'*/);
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (03,93,'ejemplo3','adicional'/**,'https://images.pexels.com/photos/46239/salmon-dish-food-meal-46239.jpeg?cs=srgb&dl=close-up-cooking-dinner-46239.jpg&fm=jpg'*/);
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (04,87,'ejemplo4','almuerzo'/**,'https://images.pexels.com/photos/769289/pexels-photo-769289.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260'*/);
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (05,98,'ejemplo5','cena'/**,'https://images.pexels.com/photos/8500/food-dinner-pasta-spaghetti-8500.jpg?auto=compress&cs=tinysrgb&h=750&w=1260'*/);

insert into EnvioEntity (id,duracion,direccion,recibido) values (01,10,'ejemplo 1', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (02,20,'ejemplo 2', 0);
insert into EnvioEntity (id,duracion,direccion,recibido) values (03,30,'ejemplo 3', 0);
insert into EnvioEntity (id,duracion,direccion,recibido) values (04,40,'ejemplo 4', 0);
insert into EnvioEntity (id,duracion,direccion,recibido) values (05,50,'ejemplo 5', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (06,60,'ejemplo 6', 0);
insert into EnvioEntity (id,duracion,direccion,recibido) values (07,70,'ejemplo 8', 0);
insert into EnvioEntity (id,duracion,direccion,recibido) values (08,80,'ejemplo7', 1);

insert into SemanaEntity(id, fechaLunes) values (221,'26/03/2018');
insert into SemanaEntity(id, fechaLunes) values (222,'02/04/2018');
insert into SemanaEntity(id, fechaLunes) values (223,'09/04/2018');


insert into DiaEntity(id, recomendacion, fecha, seenvia, semana_id) values (1, '', '26/03/2018', 1,221);
insert into DiaEntity(id, recomendacion, fecha, seenvia, semana_id) values (2, '','27/03/2018', 1,221);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (3, '', '28/03/2018', 1,221);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (4, 'No consumir azucar refinada','29/03/2018', 0,221);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (5, 'Una harina diaria','30/03/2018', 0,221);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (6, 'Tomar 2 litros de agua','31/03/2018', 0,221);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (7, '','01/04/2018', 1,221);

insert into DiaEntity(id, recomendacion, fecha, seenvia, semana_id) values (8, 'Una harina diaria', '02/04/2018', 0,222);
insert into DiaEntity(id, recomendacion, fecha, seenvia, semana_id) values (9, 'Consumir arroz integral', '03/04/2018', 0,222);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (10,'Consumir 5 porciones de vegetales', '04/04/2018', 0,222);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (11, '','05/04/2018', 1, 222);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (12, '','06/04/2018', 1, 222);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (13, '','07/04/2018', 1, 222);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (14, 'Una harina diaria','08/04/2018', 0, 222);

insert into DiaEntity(id, recomendacion, fecha, seenvia, semana_id) values (15, '', '09/04/2018', 1,223);
insert into DiaEntity(id, recomendacion, fecha, seenvia, semana_id) values (16, '', '10/04/2018', 1,223);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (17, '', '11/04/2018', 1,223);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (18, 'Una harina diaria','12/04/2018', 0,223);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (19, 'Una harina diaria','13/04/2018', 0,223);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (20, 'Una harina diaria','14/04/2018', 0,223);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (21, 'Una harina diaria','15/04/2018', 0,223);

 