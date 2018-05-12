UPDATE CUENTACOBROENTITY SET DIETA_ID = NULL;
UPDATE FACTURAENTITY SET PERSONA_ID = NULL;
UPDATE PERSONAENTITY SET CUENTA_ID = NULL; 

/*delete from CocinaEntity_DietaTipoEntity;*/
delete from DietaTipoEntity_PersonaEntity;
delete from PersonaEntity_DietaTipoEntity;
delete from DietaTipoEntity_SemanaEntity;
delete from SemanaEntity_DietaTipoEntity;

delete from CuentaCobroEntity;
delete from DietaTipoEntity;
delete from CocinaEntity;

delete from ComidaEntity;
delete from EnvioEntity;
delete from DiaEntity;
delete from SemanaEntity;

delete from MedioPagoEntity; 
delete from PagoEntity; 
 
delete from PersonaEntity_QuejasyReclamosEntity;

delete from PersonaEntity;
delete from FacturaEntity;


delete from CalificacionEntity;
delete from QuejasyReclamosEntity;
delete from CasoExitoEntity;


/*Persona con la factura 45*/
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (100, 'Pablo', 'Suarez', 20, 'Cll. 127D #19-93', 'pa.suarezm@uniandes.edu.co', 0, '201632293');


insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(4500, 3, 200418,100);

/*Dieta de la cuenta*/
INSERT INTO DIETATIPOENTITY (NUMSEMANAS, PRECIO , DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID, ID) 
	VALUES (2,100, 'Enterprise-wide coherent access', 'https://images.pexels.com/photos/248444/pexels-photo-248444.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Dieta Japonesa', 'Versatile tangible task-force', 1, NULL, 100);
/*cuenta de la persona id 1*/ 

insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (200, 'Camilo', 'Bedoya', 20, 'Cll. 151 #9-26', 'jc.bedoya@uniandes.edu.co', 0, '201631591');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (300, 'Carol', 'Trujillo', 19, 'Cra. 53 #127-43', 'cv.trujillo@uniandes.edu.co', 0, '201618005');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (400, 'Mariana', 'Moreno', 20, 'Cll. 76 #7-83', 'mi.morenoa@uniandes.edu.co', 0, '201698416');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (500, 'Juan', 'Suarez', 23, 'Cll. 127D #19-93', 'jm.suarezm@uniandes.edu.co', 0, '201632294');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (600, 'Elsa', 'Murillo', 54, 'Cll. 127D #19-93', 'ev.murilloa@uniandes.edu.co', 0, '201632295');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (700, 'Antonio', 'Suarez', 55, 'Cll. 127D #19-93', 'aj.suarezb@uniandes.edu.co', 0, '201632296');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (800, 'Gustavo', 'Quijano', 63, 'Cra. 7 #116-56', 'g.quijano@uniandes.edu.co', 0, '201632297');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (900, 'Ana', 'Suarez', 65, 'Cll. 151 #9-66', 'ae.suarezb@uniamdes.edu.co', 0, '201632298');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (1000, 'Luisa', 'Estrada', 20, 'Cll. 131 #19-86', 'l.estradap@uniandes.edu.co', 0, '201712345');

insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(4600, 7, 300418,200);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(4700, 8, 400418,300);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(4800, 2, 100518,400);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(4900, 1, 200518,500);

insert into CuentaCobroEntity(id, valorAPagar, cantidadProductos, numeroFacturaDeVenta) values (100, 20.000, 7, 200218);
insert into PagoEntity(id, montoInicial, montoFinal) values (200, 10, 10);
/*relacion cuenta a dieta*/
update personaEntity set cuenta_id = 100 where id = 100;

INSERT INTO COCINAENTITY (ID,CAPACIDAD, IMAGEN, "NAME", UBICACION) 
	VALUES (100,'2008', 'https://images.pexels.com/photos/264636/pexels-photo-264636.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'La Gran Cocina', '8871 Merry Point');
INSERT INTO COCINAENTITY (ID,CAPACIDAD, IMAGEN, "NAME", UBICACION) 
	VALUES (200,'232', 'https://images.pexels.com/photos/159991/pexels-photo-159991.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Cocina de las Aguas', '7303 Troy Placet');
INSERT INTO COCINAENTITY (ID,CAPACIDAD, IMAGEN, "NAME", UBICACION) 
	VALUES (300,'2308', 'https://images.pexels.com/photos/225448/pexels-photo-225448.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Central del Norte', '652 Lukken Junction');
INSERT INTO COCINAENTITY (ID,CAPACIDAD, IMAGEN, "NAME", UBICACION) 
	VALUES (400,'208', 'https://images.pexels.com/photos/2755/restaurant.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Cocina Bogota', '15 Hoepker Plaza');



INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO,DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (200,4,50,'Operative motivating strategy', 'https://images.pexels.com/photos/660282/pexels-photo-660282.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Anti Dieta', 'Balanced tertiary strategy', 5, NULL);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO,DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (300,2,150,'Digitized real-time implementation', 'https://images.pexels.com/photos/628776/pexels-photo-628776.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Dieta Oriental', 'Enterprise-wide global architecture', 4, NULL);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO,DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (400,5,200,'De-engineered multi-state info-mediaries', 'https://images.pexels.com/photos/546945/pexels-photo-546945.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Dieta Italiana', 'Multi-tiered cohesive contingency', 4, NULL);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO,DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (500,4,150,'ntegrated multimedia initiative', 'https://images.pexels.com/photos/629093/pexels-photo-629093.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta de Crudos', 'Multi-layered explicit circu', 3, NULL);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO,DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (600,4,150,'dieta basada en ensaladas o algo asi', 'https://images.pexels.com/photos/5938/food-salad-healthy-lunch.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta Nutricional', 'el objetivo de la dieta es desintoxicarse', 3, NULL);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO,DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (700,4,150,'una dieta basada en proteinas', 'https://images.pexels.com/photos/76093/pexels-photo-76093.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta Deportiva', 'el objetivo de la dieta es obtener masa muscular', 5, NULL);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO,DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID ) 
	VALUES (800,5,200,'dieta basada en alimentos del mar', 'https://images.pexels.com/photos/36768/food-salmon-teriyaki-cooking.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta Pacifica', 'el objetivo de la dieta es alejarse de las carnes rojas', 4, NULL);

INSERT INTO COCINAENTITY (CAPACIDAD, IMAGEN, "NAME", UBICACION) 
	VALUES ('2008', 'https://images.pexels.com/photos/264636/pexels-photo-264636.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'La Gran Cocina', '8871 Merry Point');
INSERT INTO COCINAENTITY (CAPACIDAD, IMAGEN, "NAME", UBICACION) 
	VALUES ('232', 'https://images.pexels.com/photos/159991/pexels-photo-159991.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Cocina de las Aguas', '7303 Troy Placet');
INSERT INTO COCINAENTITY (CAPACIDAD, IMAGEN, "NAME", UBICACION) 
	VALUES ('2308', 'https://images.pexels.com/photos/225448/pexels-photo-225448.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Central del Norte', '652 Lukken Junction');
INSERT INTO COCINAENTITY (CAPACIDAD, IMAGEN, "NAME", UBICACION) 
	VALUES ('208', 'https://images.pexels.com/photos/2755/restaurant.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Cocina Bogota', '15 Hoepker Plaza');


INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO, DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (900,3, 200, 'Vision-oriented intermediate matrix', 'https://images.pexels.com/photos/628777/pexels-photo-628777.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Dieta Verde', 'Ergonomic solution-oriented support', 2, NULL);

INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO, DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (1000,4, 350, 'Operative motivating strategy', 'https://images.pexels.com/photos/660282/pexels-photo-660282.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Anti Dieta', 'Balanced tertiary strategy', 5, NULL);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO, DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (1100,2, 100, 'Digitized real-time implementation', 'https://images.pexels.com/photos/628776/pexels-photo-628776.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Dieta Oriental', 'Enterprise-wide global architecture', 4, NULL);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO, DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (1200,1, 40, 'De-engineered multi-state info-mediaries', 'https://images.pexels.com/photos/546945/pexels-photo-546945.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Dieta Italiana', 'Multi-tiered cohesive contingency', 4, NULL);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO, DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (1300,5, 200, 'ntegrated multimedia initiative', 'https://images.pexels.com/photos/629093/pexels-photo-629093.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta de Crudos', 'Multi-layered explicit circu', 3, NULL);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO, DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (1400,10, 400,  'dieta basada en ensaladas o algo asi', 'https://images.pexels.com/photos/5938/food-salad-healthy-lunch.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta Nutricional', 'el objetivo de la dieta es desintoxicarse', 3, NULL);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO, DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (1500,3, 110, 'una dieta basada en proteinas', 'https://images.pexels.com/photos/76093/pexels-photo-76093.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta Deportiva', 'el objetivo de la dieta es obtener masa muscular', 5, NULL);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO, DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID ) 
	VALUES (1600,8, 800, 'dieta basada en alimentos del mar', 'https://images.pexels.com/photos/36768/food-salmon-teriyaki-cooking.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta Pacifica', 'el objetivo de la dieta es alejarse de las carnes rojas', 4, NULL);




UPDATE CUENTACOBROENTITY SET DIETA_ID = 100;



insert into MedioPagoEntity(id, medioPagoActual) values (100, 'Baloto');
insert into MedioPagoEntity(id, medioPagoActual) values (200, 'Efectivo');
insert into MedioPagoEntity(id, medioPagoActual) values (300, 'Credito');

insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (100, 7, 100);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (200, 4,100);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (300, 8,100);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (400, 6,200);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (500, 10,200);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (600, 2,300);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (700, 0,300);


insert into QuejasyReclamosEntity (id, asunto, comentario, DIETA_ID) values (100,'queja', 'La comida llego fria',400);
insert into QuejasyReclamosEntity (id, asunto, comentario, DIETA_ID) values (200,'recomendacion', 'Llamar al cliente cuando el envio este cerca',500);
insert into QuejasyReclamosEntity (id, asunto, comentario, DIETA_ID) values (300,'recomendacion', 'Contratar domiciliarios más amables',600);
insert into QuejasyReclamosEntity (id, asunto, comentario, DIETA_ID) values (400,'queja', 'el domiciliario fue grosero',700);


insert into CasoExitoEntity (id, comentario, testimonio) values (100, 'Comentario 1', 'Testimonio 1');
insert into CasoExitoEntity (id, comentario, testimonio) values (200, 'Comentario 2', 'Testimonio 2');
insert into CasoExitoEntity (id, comentario, testimonio) values (300, 'Comentario 3', 'Testimonio 3');
insert into CasoExitoEntity (id, comentario, testimonio) values (400, 'Comentario 4', 'Testimonio 4');
insert into CasoExitoEntity (id, comentario, testimonio) values (500, 'Comentario 5', 'Testimonio 5');
insert into CasoExitoEntity (id, comentario, testimonio) values (600, 'Comentario 6', 'Testimonio 6');
insert into CasoExitoEntity (id, comentario, testimonio) values (700, 'Comentario 7', 'Testimonio 7');
insert into CasoExitoEntity (id, comentario, testimonio) values (800, 'Comentario 8', 'Testimonio 8');
insert into CasoExitoEntity (id, comentario, testimonio) values (900, 'Comentario 9', 'Testimonio 9');
insert into CasoExitoEntity (id, comentario, testimonio) values (1000, 'Comentario 10', 'Testimonio 10');





insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (100,10,'ejemplo1','desayuno'/**,'https://images.pexels.com/photos/70497/pexels-photo-70497.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260'*/);
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (200,187,'ejemplo2','almuerzo'/**,'https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260'*/);
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (300,93,'ejemplo3','adicional'/**,'https://images.pexels.com/photos/46239/salmon-dish-food-meal-46239.jpeg?cs=srgb&dl=close-up-cooking-dinner-46239.jpg&fm=jpg'*/);
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (400,87,'ejemplo4','almuerzo'/**,'https://images.pexels.com/photos/769289/pexels-photo-769289.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260'*/);
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (500,98,'ejemplo5','cena'/**,'https://images.pexels.com/photos/8500/food-dinner-pasta-spaghetti-8500.jpg?auto=compress&cs=tinysrgb&h=750&w=1260'*/);

insert into EnvioEntity (id,duracion,direccion,recibido) values (100,10,'ejemplo 1', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (200,20,'ejemplo 2', 0);
insert into EnvioEntity (id,duracion,direccion,recibido) values (300,30,'ejemplo 3', 0);
insert into EnvioEntity (id,duracion,direccion,recibido) values (400,40,'ejemplo 4', 0);
insert into EnvioEntity (id,duracion,direccion,recibido) values (500,50,'ejemplo 5', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (600,60,'ejemplo 6', 0);
insert into EnvioEntity (id,duracion,direccion,recibido) values (700,70,'ejemplo 8', 0);
insert into EnvioEntity (id,duracion,direccion,recibido) values (800,80,'ejemplo7', 1);

insert into SemanaEntity(id, fechaLunes) values (221,'26/03/2018');
insert into SemanaEntity(id, fechaLunes) values (222,'02/04/2018');
insert into SemanaEntity(id, fechaLunes) values (223,'09/04/2018');


insert into DiaEntity(id, recomendacion, fecha, seenvia) values (100, '', '26/03/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seenvia) values (200, '','27/03/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (300, '', '28/03/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (400, 'No consumir azucar refinada','29/03/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (500, 'Una harina diaria','30/03/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (600, 'Tomar 2 litros de agua','31/03/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (700, '','01/04/2018', 1);


insert into DIAS_SEMANAS(DIAID, SEMANAID) values (100,221);

/* 
insert into DiaEntity(id, recomendacion, fecha, seenvia, semana_id) values (800, 'Una harina diaria', '02/04/2018', 0,222);
insert into DiaEntity(id, recomendacion, fecha, seenvia, semana_id) values (900, 'Consumir arroz integral', '03/04/2018', 0,222);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (1000,'Consumir 5 porciones de vegetales', '04/04/2018', 0,222);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (1100, '','05/04/2018', 1, 222);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (1200, '','06/04/2018', 1, 222);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (1300, '','07/04/2018', 1, 222);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (1400, 'Una harina diaria','08/04/2018', 0, 222);

insert into DiaEntity(id, recomendacion, fecha, seenvia, semana_id) values (1500, '', '09/04/2018', 1,223);
insert into DiaEntity(id, recomendacion, fecha, seenvia, semana_id) values (1600, '', '10/04/2018', 1,223);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (1700, '', '11/04/2018', 1,223);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (1800, 'Una harina diaria','12/04/2018', 0,223);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (1900, 'Consumir arroz integral','13/04/2018', 0,223);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (2000, 'Una harina diaria','14/04/2018', 0,223);
insert into DiaEntity(id, recomendacion, fecha, seEnvia, semana_id) values (2100, 'Una harina diaria','15/04/2018', 0, 223);
*/
