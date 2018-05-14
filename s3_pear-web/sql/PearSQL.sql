UPDATE CUENTACOBROENTITY SET DIETA_ID = NULL;
UPDATE FACTURAENTITY SET PERSONA_ID = NULL;
UPDATE PERSONAENTITY SET CUENTA_ID = NULL; 

delete from DietaTipoEntity_PersonaEntity;
delete from PersonaEntity_DietaTipoEntity;
delete from SemanaEntity_DietaTipoEntity;
delete from Semanas_Dietas;
delete from CuentaCobroEntity;
delete from DietaTipoEntity;
delete from CocinaEntity;

delete from ComidaEntity;
delete from EnvioEntity;

delete from Dias_Semanas;
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


INSERT INTO DIETATIPOENTITY (NUMSEMANAS, PRECIO , DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID, ID) 
	VALUES (2,100, 'Enterprise-wide coherent access', 'https://images.pexels.com/photos/248444/pexels-photo-248444.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Dieta Japonesa', 'Versatile tangible task-force', 1, NULL, 100); 

insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (100, 'Pablo', 'Suarez', 20, 'Cll. 127D #19-93', 'pa.suarezm@uniandes.edu.co', 0, '201632293');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (200, 'Camilo', 'Bedoya', 20, 'Cll. 151 #9-26', 'jc.bedoya@uniandes.edu.co', 0, '201631591');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (300, 'Carol', 'Trujillo', 19, 'Cra. 53 #127-43', 'cv.trujillo@uniandes.edu.co', 0, '201618005');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (400, 'Mariana', 'Moreno', 20, 'Cll. 76 #7-83', 'mi.morenoa@uniandes.edu.co', 0, '201698416');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (500, 'Juan', 'Suarez', 23, 'Cll. 127D #19-93', 'jm.suarezm@uniandes.edu.co', 0, '201632294');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (600, 'Elsa', 'Murillo', 54, 'Cll. 127D #19-93', 'ev.murilloa@uniandes.edu.co', 0, '201632295');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (700, 'Antonio', 'Suarez', 55, 'Cll. 127D #19-93', 'aj.suarezb@uniandes.edu.co', 0, '201632296');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (800, 'Gustavo', 'Quijano', 63, 'Cra. 7 #116-56', 'g.quijano@uniandes.edu.co', 0, '201632297');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (900, 'Ana', 'Suarez', 65, 'Cll. 151 #9-66', 'ae.suarezb@uniamdes.edu.co', 0, '201632298');
insert into PersonaEntity (id, nombre, apellido, edad, direccion, correo, subscrito, identificacion) values (1000, 'Luisa', 'Estrada', 20, 'Cll. 131 #19-86', 'l.estradap@uniandes.edu.co', 0, '201712345');

insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(4500, 3, 200418,100);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(4600, 7, 210418,200);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(4700, 8, 220418,300);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(4800, 2, 230418,400);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(4900, 1, 240418,500);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(5000, 7, 250418,600);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(5100, 8, 260418,700);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(5200, 2, 270418,800);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(5300, 1, 280418,900);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(5400, 1, 290418,1000);

insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(5500, 7, 300418,200);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(5600, 2, 310418,400);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(5700, 7, 320418,600);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(5800, 2, 330418,800);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(5900, 1, 340418,1000);

insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(6000, 7, 350418,200);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(6100, 8, 360418,300);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(6200, 2, 370418,400);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(6300, 1, 380418,500);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(6400, 7, 390418,600);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(6500, 8, 400418,700);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(6600, 2, 410418,800);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(6700, 1, 420418,900);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(6800, 1, 430418,1000);
insert into FacturaEntity(id, cantidadProductos, numeroFacturaDeVenta, persona_id) values(6900, 7, 440418,100);


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
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO,DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
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
	VALUES (1400,3, 400,  'dieta basada en ensaladas o algo asi', 'https://images.pexels.com/photos/5938/food-salad-healthy-lunch.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta Nutricional', 'el objetivo de la dieta es desintoxicarse', 3, NULL);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO, DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (1500,3, 110, 'una dieta basada en proteinas', 'https://images.pexels.com/photos/76093/pexels-photo-76093.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta Deportiva', 'el objetivo de la dieta es obtener masa muscular', 5, NULL);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO, DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID ) 
	VALUES (1600,6, 800, 'dieta basada en alimentos del mar', 'https://images.pexels.com/photos/36768/food-salmon-teriyaki-cooking.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta Pacifica', 'el objetivo de la dieta es alejarse de las carnes rojas', 4, NULL);



insert into PagoEntity(id, montoInicial, montoFinal) values (200, 10, 10);
insert into CuentaCobroEntity(id, valorAPagar, cantidadProductos, numeroFacturaDeVenta,pago_id,dieta_id) values (100, 20.000, 7, 350418, 200, 100);


insert into PagoEntity(id, montoInicial, montoFinal) values (300, 15, 15);
insert into CuentaCobroEntity(id, valorAPagar, cantidadProductos, numeroFacturaDeVenta,pago_id,dieta_id) values (200, 30.000, 8, 360418, 300, 200);


insert into PagoEntity(id, montoInicial, montoFinal) values (400, 10, 10);
insert into CuentaCobroEntity(id, valorAPagar, cantidadProductos, numeroFacturaDeVenta,pago_id,dieta_id) values (300, 20.000, 2, 370418, 400, 300);


insert into PagoEntity(id, montoInicial, montoFinal) values (500, 5, 5);
insert into CuentaCobroEntity(id, valorAPagar, cantidadProductos, numeroFacturaDeVenta,pago_id,dieta_id) values (400, 10.000, 1, 380418, 500, 400);


insert into PagoEntity(id, montoInicial, montoFinal) values (600, 15, 15);
insert into CuentaCobroEntity(id, valorAPagar, cantidadProductos, numeroFacturaDeVenta,pago_id,dieta_id) values (500, 30.000, 7, 390418, 600, 500);


insert into PagoEntity(id, montoInicial, montoFinal) values (700, 20, 20);
insert into CuentaCobroEntity(id, valorAPagar, cantidadProductos, numeroFacturaDeVenta,pago_id,dieta_id) values (600, 40.000, 8, 400418, 700, 600);


insert into PagoEntity(id, montoInicial, montoFinal) values (800, 5, 5);
insert into CuentaCobroEntity(id, valorAPagar, cantidadProductos, numeroFacturaDeVenta,pago_id,dieta_id) values (700, 10.000, 2, 410418, 800, 700);


insert into PagoEntity(id, montoInicial, montoFinal) values (900, 5, 5);
insert into CuentaCobroEntity(id, valorAPagar, cantidadProductos, numeroFacturaDeVenta,pago_id,dieta_id) values (800, 10.000, 1, 420418, 900, 800);


insert into PagoEntity(id, montoInicial, montoFinal) values (1000, 10, 10);
insert into CuentaCobroEntity(id, valorAPagar, cantidadProductos, numeroFacturaDeVenta,pago_id,dieta_id) values (900, 20.000, 1, 430418, 1000, 900);


insert into PagoEntity(id, montoInicial, montoFinal) values (1100, 25, 25);
insert into CuentaCobroEntity(id, valorAPagar, cantidadProductos, numeroFacturaDeVenta,pago_id,dieta_id) values (1000, 50.000, 7, 440418, 1100, 1000);


/*relacion persona - cuenta*/
update personaEntity set cuenta_id = 100 where id = 100;
update personaEntity set cuenta_id = 200 where id = 200;
update personaEntity set cuenta_id = 300 where id = 300;
update personaEntity set cuenta_id = 400 where id = 400;
update personaEntity set cuenta_id = 500 where id = 500;
update personaEntity set cuenta_id = 600 where id = 600;
update personaEntity set cuenta_id = 700 where id = 700;
update personaEntity set cuenta_id = 800 where id = 800;
update personaEntity set cuenta_id = 900 where id = 900;
update personaEntity set cuenta_id = 1000 where id = 1000;


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


insert into CasoExitoEntity (id, comentario, testimonio,fotoAntesyDespues) values (100, 'Comentario 1', 'Testimonio 1','https://rolloid.net/wp-content/uploads/2017/05/20-fotos-increibles-de-perdida-de-peso-antes-y-despues-de-las-cuales-no-creeras-que-sean-de-la-misma-persona-1494409922.jpg');
insert into CasoExitoEntity (id, comentario, testimonio,fotoAntesyDespues) values (200, 'Comentario 2', 'Testimonio 2','https://rolloid.net/wp-content/uploads/2017/05/20-fotos-increibles-de-perdida-de-peso-antes-y-despues-de-las-cuales-no-creeras-que-sean-de-la-misma-persona-1494410051.jpg');
insert into CasoExitoEntity (id, comentario, testimonio,fotoAntesyDespues) values (300, 'Comentario 3', 'Testimonio 3','https://rolloid.net/wp-content/uploads/2017/05/20-fotos-increibles-de-perdida-de-peso-antes-y-despues-de-las-cuales-no-creeras-que-sean-de-la-misma-persona-1494410226.jpg' );
insert into CasoExitoEntity (id, comentario, testimonio,fotoAntesyDespues) values (400, 'Comentario 4', 'Testimonio 4','https://rolloid.net/wp-content/uploads/2017/05/20-fotos-increibles-de-perdida-de-peso-antes-y-despues-de-las-cuales-no-creeras-que-sean-de-la-misma-persona-1494410282.jpg');
insert into CasoExitoEntity (id, comentario, testimonio,fotoAntesyDespues) values (500, 'Comentario 5', 'Testimonio 5','https://rolloid.net/wp-content/uploads/2017/05/20-fotos-increibles-de-perdida-de-peso-antes-y-despues-de-las-cuales-no-creeras-que-sean-de-la-misma-persona-1494410581.jpg');
insert into CasoExitoEntity (id, comentario, testimonio,fotoAntesyDespues) values (600, 'Comentario 6', 'Testimonio 6', 'https://rolloid.net/wp-content/uploads/2017/05/20-fotos-increibles-de-perdida-de-peso-antes-y-despues-de-las-cuales-no-creeras-que-sean-de-la-misma-persona-1494410714.jpg');
insert into CasoExitoEntity (id, comentario, testimonio,fotoAntesyDespues) values (700, 'Comentario 7', 'Testimonio 7', 'https://rolloid.net/wp-content/uploads/2017/05/20-fotos-increibles-de-perdida-de-peso-antes-y-despues-de-las-cuales-no-creeras-que-sean-de-la-misma-persona-1494410793.jpg');
insert into CasoExitoEntity (id, comentario, testimonio,fotoAntesyDespues) values (800, 'Comentario 8', 'Testimonio 8', 'https://rolloid.net/wp-content/uploads/2017/05/20-fotos-increibles-de-perdida-de-peso-antes-y-despues-de-las-cuales-no-creeras-que-sean-de-la-misma-persona-1494410793.jpg');
insert into CasoExitoEntity (id, comentario, testimonio,fotoAntesyDespues) values (900, 'Comentario 9', 'Testimonio 9','https://rolloid.net/wp-content/uploads/2017/05/20-fotos-increibles-de-perdida-de-peso-antes-y-despues-de-las-cuales-no-creeras-que-sean-de-la-misma-persona-1494409694.jpg');
insert into CasoExitoEntity (id, comentario, testimonio,fotoAntesyDespues) values (1000, 'Comentario 10', 'Testimonio 10','https://rolloid.net/wp-content/uploads/2017/05/20-fotos-increibles-de-perdida-de-peso-antes-y-despues-de-las-cuales-no-creeras-que-sean-de-la-misma-persona-1494409764.jpg');

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
insert into SemanaEntity(id, fechaLunes) values (224,'16/04/2018');
insert into SemanaEntity(id, fechaLunes) values (225,'23/04/2018');
insert into SemanaEntity(id, fechaLunes) values (226,'30/04/2018');
insert into SemanaEntity(id, fechaLunes) values (227,'07/05/2018');
insert into SemanaEntity(id, fechaLunes) values (228,'14/05/2018');
insert into SemanaEntity(id, fechaLunes) values (229,'21/05/2018');

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (100, '', '26/03/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seenvia) values (200, '','27/03/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (300, '', '28/03/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (400, 'No consumir azucar refinada','29/03/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (500, 'Una harina diaria','30/03/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (600, 'Tomar 2 litros de agua','31/03/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (700, '','01/04/2018', 1);

insert into DIAS_SEMANAS(DIAID, SEMANAID) values (100,221);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (200,221);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (300,221);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (400,221);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (500,221);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (600,221);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (700,221);

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (800, 'Una harina diaria', '02/04/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seenvia) values (900, 'Consumir arroz integral', '03/04/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (1000,'Consumir 5 porciones de vegetales', '04/04/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (1100, '','05/04/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (1200, '','06/04/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (1300, '','07/04/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (1400, 'Una harina diaria','08/04/2018', 0);

insert into DIAS_SEMANAS(DIAID, SEMANAID) values (800,222);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (900,222);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1000,222);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1100,222);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1200,222);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1300,222);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1400,222);

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (1500, '', '09/04/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seenvia) values (1600, '', '10/04/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (1700, '', '11/04/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (1800, 'Una harina diaria','12/04/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (1900, 'Consumir arroz integral','13/04/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (2000, 'Una harina diaria','14/04/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (2100, 'Una harina diaria','15/04/2018', 0);

insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1500,223);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1600,223);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1700,223);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1800,223);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1900,223);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2000,223);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2100,223);

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (2200, '', '16/04/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seenvia) values (2300, '', '17/04/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (2400, '', '18/04/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (2500, 'Una harina diaria','19/04/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (2600, '','20/04/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (2700, 'No consumir azucar refinada','21/04/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (2800, '','22/04/2018', 1);

insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2200,224);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2300,224);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2400,224);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2500,224);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2600,224);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2700,224);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2800,224);

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (2900, '', '23/04/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seenvia) values (3000, '', '24/04/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (3100, '', '25/04/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (3200, '','26/04/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (3300, '','27/04/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (3400, '','28/04/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (3500, '','29/04/2018', 1);

insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2900,225);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3000,225);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3100,225);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3200,225);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3300,225);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3400,225);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3500,225);


insert into DiaEntity(id, recomendacion, fecha, seenvia) values (3600, '', '30/04/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seenvia) values (3700, '', '01/05/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (3800, '', '02/05/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (3900, 'Una harina diaria','03/05/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (4000, 'Consumir arroz integral','04/05/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (4100, 'Una harina diaria','05/05/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (4200, 'Una harina diaria','06/05/2018', 0);

insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3600,226);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3700,226);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3800,226);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3900,226);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (4000,226);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (4100,226);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (4200,226);

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (4300, '', '07/05/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seenvia) values (4400, '', '08/05/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (4500, '', '09/05/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (4600, 'Una harina diaria','10/05/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (4700, '','11/05/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (4800, 'No consumir azucar refinada','12/05/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (4900, '','13/05/2018', 1);

insert into DIAS_SEMANAS(DIAID, SEMANAID) values (4300,227);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (4400,227);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (4500,227);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (4600,227);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (4700,227);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (4800,227);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (4900,227);

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (5000, '', '14/05/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seenvia) values (5100, '', '15/05/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (5200, '', '16/05/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (5300, '', '17/05/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (5400, '', '18/05/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (5500, '', '19/05/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (5600, '', '20/05/2018', 1);

insert into DIAS_SEMANAS(DIAID, SEMANAID) values (5000,228);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (5100,228);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (5200,228);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (5300,228);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (5400,228);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (5500,228);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (5600,228);

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (5700, '', '21/05/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seenvia) values (5800, '','22/05/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (5900, '', '23/05/2018', 1);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (6000, 'No consumir azucar refinada','24/05/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (6100, 'Una harina diaria','25/05/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (6200, 'Tomar 2 litros de agua','26/05/2018', 0);
insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (6300, '','27/05/2018', 1);

insert into DIAS_SEMANAS(DIAID, SEMANAID) values (5700,229);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (5800,229);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (5900,229);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (6000,229);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (6100,229);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (6200,229);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (6300,229);


insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (221,100);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (222,100);

insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (223,200);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (224,200);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (225,200);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (226,200);

insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (225,300);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (226,300);


insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (221,400);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (222,400);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (223,400);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (224,400);

insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (224,500);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (225,500);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (226,500);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (227,500);

insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (223,600);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (224,600);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (225,600);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (226,600);

insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (226,700);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (227,700);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (228,700);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (229,700);

insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (221,800);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (222,800);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (223,800);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (224,800);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (225,800);

insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (226,900);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (227,900);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (228,900);

insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (222,1000);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (223,1000);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (224,1000);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (225,1000);


insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (223,1100);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (224,1100);

insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (229,1200);

insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (224,1300);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (225,1300);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (226,1300);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (227,1300);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (228,1300);

insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (227,1400);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (228,1400);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (229,1400);

insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (225,1500);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (226,1500);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (227,1500);

insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (222,1600);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (223,1600);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (224,1600);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (225,1600);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (226,1600);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (227,1600);