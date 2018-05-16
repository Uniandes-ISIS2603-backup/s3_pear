UPDATE CUENTACOBROENTITY SET DIETA_ID = NULL;
UPDATE FACTURAENTITY SET PERSONA_ID = NULL;
UPDATE PERSONAENTITY SET CUENTA_ID = NULL; 

delete from DietaTipoEntity_PersonaEntity;
delete from PersonaEntity_DietaTipoEntity;
delete from Semanas_Dietas;
delete from Envios_Dias;
delete from Dias_Comidas;
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
INSERT INTO COCINAENTITY (ID,CAPACIDAD, IMAGEN, "NAME", UBICACION) 
	VALUES (500,'2008','https://images.pexels.com/photos/264636/pexels-photo-264636.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'La Gran Cocina', '8871 Merry Point');
INSERT INTO COCINAENTITY (ID,CAPACIDAD, IMAGEN, "NAME", UBICACION) 
	VALUES (600,'232', 'https://images.pexels.com/photos/159991/pexels-photo-159991.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Cocina de las Aguas', '7303 Troy Placet');


INSERT INTO DIETATIPOENTITY (NUMSEMANAS, PRECIO , DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID, ID) 
	VALUES (2,100, 'Enterprise-wide coherent access', 'https://images.pexels.com/photos/248444/pexels-photo-248444.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Dieta Japonesa', 'Versatile tangible task-force', 1, 100, 100); 
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO,DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (200,4,50,'Operative motivating strategy', 'https://images.pexels.com/photos/660282/pexels-photo-660282.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Anti Dieta', 'Balanced tertiary strategy', 5, 200);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO,DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (300,2,150,'Digitized real-time implementation', 'https://images.pexels.com/photos/628776/pexels-photo-628776.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Dieta Oriental', 'Enterprise-wide global architecture', 4,300);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO,DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (400,4,200,'De-engineered multi-state info-mediaries', 'https://images.pexels.com/photos/546945/pexels-photo-546945.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Dieta Italiana', 'Multi-tiered cohesive contingency', 4, 200);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO,DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (500,3,150,'ntegrated multimedia initiative', 'https://images.pexels.com/photos/629093/pexels-photo-629093.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta de Crudos', 'Multi-layered explicit circu', 3, 400);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO,DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (600,4,150,'dieta basada en ensaladas o algo asi', 'https://images.pexels.com/photos/5938/food-salad-healthy-lunch.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta Nutricional', 'el objetivo de la dieta es desintoxicarse', 3, 100);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO,DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (700,3,150,'una dieta basada en proteinas', 'https://images.pexels.com/photos/76093/pexels-photo-76093.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta Deportiva', 'el objetivo de la dieta es obtener masa muscular', 5,500);
INSERT INTO DIETATIPOENTITY (ID,NUMSEMANAS, PRECIO,DESCRIPCION, IMAGEN, "NAME", OBJETIVO, STARS, COCINA_ID) 
	VALUES (800,5,200,'dieta basada en alimentos del mar', 'https://images.pexels.com/photos/36768/food-salmon-teriyaki-cooking.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', 'Dieta Pacifica', 'el objetivo de la dieta es alejarse de las carnes rojas', 4, 600);


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

insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (100, 7,100);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (200, 4,100);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (300, 8,100);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (400, 6,200);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (500, 10,200);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (600, 2,300);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (700, 8,300);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (800, 7,400);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (900, 5,400);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (1000, 10,400);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (1100, 6,500);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (1200, 9,500);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (1300, 8,600);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (1400, 10,600);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (1500, 7,700);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (1600, 8,700);
insert into CalificacionEntity (id, puntuacion, DIETA_ID) values (1700, 6,800);

insert into QuejasyReclamosEntity (id, asunto, comentario, DIETA_ID) values (100,'queja', 'La comida llego fria',400);
insert into QuejasyReclamosEntity (id, asunto, comentario, DIETA_ID) values (200,'recomendacion', 'Llamar al cliente cuando el envio este cerca',500);
insert into QuejasyReclamosEntity (id, asunto, comentario, DIETA_ID) values (300,'recomendacion', 'Contratar domiciliarios más amables',600);
insert into QuejasyReclamosEntity (id, asunto, comentario, DIETA_ID) values (400,'queja', 'el domiciliario fue grosero',800);
insert into QuejasyReclamosEntity (id, asunto, comentario, DIETA_ID) values (500,'queja', 'el domiciliario fue grosero',100);
insert into QuejasyReclamosEntity (id, asunto, comentario, DIETA_ID) values (600,'queja', 'el domiciliario fue grosero',200);
insert into QuejasyReclamosEntity (id, asunto, comentario, DIETA_ID) values (700,'queja', 'el domiciliario fue grosero',300);
insert into QuejasyReclamosEntity (id, asunto, comentario, DIETA_ID) values (800,'queja', 'el domiciliario fue grosero',400);
insert into QuejasyReclamosEntity (id, asunto, comentario, DIETA_ID) values (900,'queja', 'el domiciliario fue grosero',500);
insert into QuejasyReclamosEntity (id, asunto, comentario, DIETA_ID) values (1000,'queja', 'el domiciliario fue grosero',600);
insert into QuejasyReclamosEntity (id, asunto, comentario, DIETA_ID) values (1100,'queja', 'el domiciliario fue grosero',700);

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

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (100, '', '26/03/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (100,10,'Calle 5', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (200,10,'Carrera 6', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (300,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(100,100);
insert into envios_dias(envioid, diaid) values(200,100);
insert into envios_dias(envioid, diaid) values(300,100);

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (200, '','27/03/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (300,10,'Calle 4', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (400,10,'Carrera 5', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (500,10,'Calle 2', 1);
insert into envios_dias(envioid, diaid) values(300,200);
insert into envios_dias(envioid, diaid) values(400,200);
insert into envios_dias(envioid, diaid) values(500,200);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (300, '', '28/03/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (600,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (700,10,'Carrera 1', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (800,10,'Calle 9', 1);
insert into envios_dias(envioid, diaid) values(600,300);
insert into envios_dias(envioid, diaid) values(700,300);
insert into envios_dias(envioid, diaid) values(800,300);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (400, 'No consumir azucar refinada','29/03/2018', 0);

insert into EnvioEntity (id,duracion,direccion,recibido) values (900,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (1000,10,'Carrera 1', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (1100,10,'Calle 9', 1);
insert into envios_dias(envioid, diaid) values(900,400);
insert into envios_dias(envioid, diaid) values(1000,400);
insert into envios_dias(envioid, diaid) values(1100,400);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (500, 'Una harina diaria','30/03/2018', 0);

insert into EnvioEntity (id,duracion,direccion,recibido) values (1200,10,'Calle 13', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (1300,10,'Carrera 4', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (1400,10,'Calle 90', 1);
insert into envios_dias(envioid, diaid) values(1200,500);
insert into envios_dias(envioid, diaid) values(1300,500);
insert into envios_dias(envioid, diaid) values(1400,500);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (600, 'Tomar 2 litros de agua','31/03/2018', 0);

insert into EnvioEntity (id,duracion,direccion,recibido) values (1500,10,'Calle 4', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (1600,10,'Carrera 4', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (1700,10,'Calle 4', 1);
insert into envios_dias(envioid, diaid) values(1500,600);
insert into envios_dias(envioid, diaid) values(1600,600);
insert into envios_dias(envioid, diaid) values(1700,600);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (700, '','01/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (1800,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (1900,10,'Carrera 49', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (2000,10,'Calle 69', 1);
insert into envios_dias(envioid, diaid) values(1800,700);
insert into envios_dias(envioid, diaid) values(1900,700);
insert into envios_dias(envioid, diaid) values(2000,700);



insert into DIAS_SEMANAS(DIAID, SEMANAID) values (100,221);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (200,221);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (300,221);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (400,221);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (500,221);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (600,221);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (700,221);


insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (100,10,'Huevo y Jamón','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (200,187,'Esparragos y Pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (300,93,'Carne','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (400,87,'Leche y fresas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (500,98,'Pescado','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (600,200,'Queso Cottage','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (700,10,'Huevo y Jamón','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (800,187,'Esparragos y Pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (900,93,'Carne','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (1000,87,'Leche y fresas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (1100,98,'Pescado','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (1200,200,'Queso Cottage','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (1300,10,'Huevo y Jamón','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (1400,187,'Esparragos y Pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (1500,93,'Carne','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (1600,87,'Leche y fresas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (1700,98,'Pescado','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (1800,200,'Queso Cottage','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (1900,10,'Huevo y Jamón','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (2000,187,'Esparragos y Pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (2100,93,'Carne','Cena');

insert into DIAS_COMIDAS(DIAID, COMIDAID)values(100,100);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(100,200);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(100,300);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(200,400);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(200,500);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(200,600);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(300,700);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(300,800);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(300,900);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(400,1000);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(400,1100);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(400,1200);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(500,1300);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(500,1400);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(500,1500);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(600,1600);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(600,1700);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(600,1800);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(700,1900);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(700,2000);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(700,2100);

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (800, 'Una harina diaria', '02/04/2018', 0);

insert into EnvioEntity (id,duracion,direccion,recibido) values (2100,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (2200,10,'Carrera 49', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (2300,10,'Calle 69', 1);
insert into envios_dias(envioid, diaid) values(2100,800);
insert into envios_dias(envioid, diaid) values(2200,800);
insert into envios_dias(envioid, diaid) values(2300,800);

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (900, 'Consumir arroz integral', '03/04/2018', 0);

insert into EnvioEntity (id,duracion,direccion,recibido) values (2400,10,'Calle 21', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (2500,10,'Carrera 15', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (2600,10,'Calle 77', 1);
insert into envios_dias(envioid, diaid) values(2400,900);
insert into envios_dias(envioid, diaid) values(2500,900);
insert into envios_dias(envioid, diaid) values(2600,900);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (1000,'Consumir 5 porciones de vegetales', '04/04/2018', 0);

insert into EnvioEntity (id,duracion,direccion,recibido) values (2700,10,'Calle 11', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (2800,10,'Carrera 5', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (2900,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(2700,1000);
insert into envios_dias(envioid, diaid) values(2800,1000);
insert into envios_dias(envioid, diaid) values(2900,1000);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (1100, '','05/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (3000,10,'Calle 10', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (3100,10,'Carrera 50', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (3200,10,'Calle 18', 1);
insert into envios_dias(envioid, diaid) values(3000,1100);
insert into envios_dias(envioid, diaid) values(3100,1100);
insert into envios_dias(envioid, diaid) values(3200,1100);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (1200, '','06/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (3300,10,'Calle 1', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (3400,10,'Carrera 12', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (3500,10,'Calle 19', 1);
insert into envios_dias(envioid, diaid) values(3300,1200);
insert into envios_dias(envioid, diaid) values(3400,1200);
insert into envios_dias(envioid, diaid) values(3500,1200);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (1300, '','07/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (3600,10,'Calle 33', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (3700,10,'Carrera 44', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (3800,10,'Calle 55', 1);
insert into envios_dias(envioid, diaid) values(3600,1300);
insert into envios_dias(envioid, diaid) values(3700,1300);
insert into envios_dias(envioid, diaid) values(3800,1300);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (1400, 'Una harina diaria','08/04/2018', 0);

insert into EnvioEntity (id,duracion,direccion,recibido) values (3900,10,'Calle 31', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (4000,10,'Carrera 41', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (4100,10,'Calle 51', 1);
insert into envios_dias(envioid, diaid) values(3900,1400);
insert into envios_dias(envioid, diaid) values(4000,1400);
insert into envios_dias(envioid, diaid) values(4100,1400);

insert into DIAS_SEMANAS(DIAID, SEMANAID) values (800,222);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (900,222);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1000,222);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1100,222);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1200,222);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1300,222);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1400,222);

insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (2200,10,'Queso y Uvas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (2300,187,'Carne molida','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (2400,93,'Pescado','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (2500,87,'Cereal y Almendras','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (2600,98,'Pescado','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (2700,200,'Queso Cottage','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (2800,10,'Queso y Uvas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (2900,187,'Esparragos y Pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (3000,93,'Carne','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (3100,87,'Cereal y Almendras','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (3200,98,'Arroz con pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (3300,200,'Queso Cottage','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (3400,10,'Queso y Uvas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (3500,187,'Espinacas con frambuesas','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (3600,93,'Carne','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (3700,87,'Leche y fresas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (3800,98,'Pescado','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (3900,200,'Queso Cottage','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (4000,10,'Queso y Uvas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (4100,187,'Esparragos y Pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (4200,93,'Carne Asada','Cena');

insert into DIAS_COMIDAS(DIAID, COMIDAID)values(800,2200);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(800,2300);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(800,2400);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(900,2500);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(900,2600);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(900,2700);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1000,2800);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1000,2900);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1000,3000);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1100,3100);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1100,3200);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1100,3300);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1200,3400);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1200,3500);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1200,3600);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1300,3700);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1300,3800);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1300,3900);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1400,4000);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1400,4100);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1400,4200);

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (1500, '', '09/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (4200,10,'Calle 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (4300,10,'Carrera 4', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (4400,10,'Calle 5', 1);
insert into envios_dias(envioid, diaid) values(4200,1500);
insert into envios_dias(envioid, diaid) values(4300,1500);
insert into envios_dias(envioid, diaid) values(4400,1500);

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (1600, '', '10/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (4500,10,'Calle 12', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (4600,10,'Carrera 13', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (4700,10,'Calle 17', 1);
insert into envios_dias(envioid, diaid) values(4500,1600);
insert into envios_dias(envioid, diaid) values(4600,1600);
insert into envios_dias(envioid, diaid) values(4700,1600);


insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (1700, '', '11/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (4800,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (4900,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (5000,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(4800,1700);
insert into envios_dias(envioid, diaid) values(4900,1700);
insert into envios_dias(envioid, diaid) values(5000,1700);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (1800, 'Una harina diaria','12/04/2018', 0);

insert into EnvioEntity (id,duracion,direccion,recibido) values (5100,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (5200,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (5300,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(5100,1800);
insert into envios_dias(envioid, diaid) values(5200,1800);
insert into envios_dias(envioid, diaid) values(5300,1800);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (1900, 'Consumir arroz integral','13/04/2018', 0);

insert into EnvioEntity (id,duracion,direccion,recibido) values (5400,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (5500,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (5600,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(5400,1900);
insert into envios_dias(envioid, diaid) values(5500,1900);
insert into envios_dias(envioid, diaid) values(5600,1900);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (2000, 'Una harina diaria','14/04/2018', 0);

insert into EnvioEntity (id,duracion,direccion,recibido) values (5700,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (5800,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (5900,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(5700,2000);
insert into envios_dias(envioid, diaid) values(5800,2000);
insert into envios_dias(envioid, diaid) values(5900,2000);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (2100, 'Una harina diaria','15/04/2018', 0);

insert into EnvioEntity (id,duracion,direccion,recibido) values (6000,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (6100,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (6200,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(6000,2100);
insert into envios_dias(envioid, diaid) values(6100,2100);
insert into envios_dias(envioid, diaid) values(6200,2100);


/*HASTA AQUI VAN LOS ENVIOS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/


insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1500,223);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1600,223);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1700,223);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1800,223);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (1900,223);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2000,223);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2100,223);

insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (4300,10,'Huevo y Jamón','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (4400,187,'Esparragos y Pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (4500,93,'Carne','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (4600,87,'Leche y fresas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (4700,98,'Pescado','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (4800,200,'Queso Cottage','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (4900,10,'Huevo y Jamón','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (5000,187,'Esparragos y Pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (5100,93,'Carne','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (5200,87,'Leche y fresas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (5300,98,'Pescado','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (5400,200,'Queso Cottage','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (5500,10,'Huevo y Jamón','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (5600,187,'Esparragos y Pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (5700,93,'Carne','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (5800,87,'Leche y fresas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (5900,98,'Pescado','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (6000,200,'Queso Cottage','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (6100,10,'Huevo y Jamón','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (6200,187,'Esparragos y Pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (6300,93,'Carne','Cena');

insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1500,4300);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1500,4400);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1500,4500);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1600,4600);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1600,4700);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1600,4800);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1700,4900);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1700,5000);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1700,5100);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1800,5200);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1800,5300);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1800,5400);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1900,5500);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1900,5600);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(1900,5700);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2000,5800);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2000,5900);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2000,6000);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2100,6100);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2100,6200);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2100,6300);

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (2200, '', '16/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (6300,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (6400,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (6500,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(6300,2200);
insert into envios_dias(envioid, diaid) values(6400,2200);
insert into envios_dias(envioid, diaid) values(6500,2200);


insert into DiaEntity(id, recomendacion, fecha, seenvia) values (2300, '', '17/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (6600,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (6700,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (6800,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(6600,2300);
insert into envios_dias(envioid, diaid) values(6700,2300);
insert into envios_dias(envioid, diaid) values(6800,2300);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (2400, '', '18/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (6900,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (7000,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (71000,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(6900,2400);
insert into envios_dias(envioid, diaid) values(7000,2400);
insert into envios_dias(envioid, diaid) values(7100,2400);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (2500, 'Una harina diaria','19/04/2018', 0);

insert into EnvioEntity (id,duracion,direccion,recibido) values (7200,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (7300,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (74000,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(7200,2500);
insert into envios_dias(envioid, diaid) values(7300,2500);
insert into envios_dias(envioid, diaid) values(7400,2500);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (2600, '','20/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (7500,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (7600,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (77000,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(7500,2600);
insert into envios_dias(envioid, diaid) values(7600,2600);
insert into envios_dias(envioid, diaid) values(7700,2600);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (2700, 'No consumir azucar refinada','21/04/2018', 0);

insert into EnvioEntity (id,duracion,direccion,recibido) values (7800,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (7900,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (8000,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(7800,2700);
insert into envios_dias(envioid, diaid) values(7900,2700);
insert into envios_dias(envioid, diaid) values(8000,2700);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (2800, '','22/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (8100,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (8200,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (8300,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(8100,2800);
insert into envios_dias(envioid, diaid) values(8200,2800);
insert into envios_dias(envioid, diaid) values(8300,2800);

insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2200,224);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2300,224);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2400,224);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2500,224);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2600,224);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2700,224);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2800,224);

insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (6400,10,'Queso y Uvas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (6500,187,'Carne molida','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (6600,93,'Pescado','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (6700,87,'Cereal y Almendras','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (6800,98,'Pescado','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (6900,200,'Queso Cottage','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (7000,10,'Queso y Uvas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (7100,187,'Esparragos y Pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (7200,93,'Carne','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (7300,87,'Cereal y Almendras','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (7400,98,'Arroz con pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (7500,200,'Queso Cottage','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (7600,10,'Queso y Uvas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (7700,187,'Espinacas con frambuesas','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (7800,93,'Carne','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (7900,87,'Leche y fresas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (8000,98,'Pescado','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (8100,200,'Queso Cottage','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (8200,10,'Queso y Uvas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (8300,187,'Esparragos y Pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (8400,93,'Carne Asada','Cena');

insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2200,6400);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2200,6500);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2200,6600);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2300,6700);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2300,6800);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2300,6900);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2400,7000);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2400,7100);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2400,7200);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2500,7300);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2500,7400);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2500,7500);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2600,7600);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2600,7700);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2600,7800);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2700,7900);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2700,8000);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2700,8100);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2800,8200);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2800,8300);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2800,8400);

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (2900, '', '23/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (8400,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (8500,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (8600,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(8400,2900);
insert into envios_dias(envioid, diaid) values(8500,2900);
insert into envios_dias(envioid, diaid) values(8600,2900);

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (3000, '', '24/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (8700,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (8800,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (8900,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(8700,3000);
insert into envios_dias(envioid, diaid) values(8800,3000);
insert into envios_dias(envioid, diaid) values(8900,3000);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (3100, '', '25/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (9000,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (9100,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (9200,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(9000,3100);
insert into envios_dias(envioid, diaid) values(9100,3100);
insert into envios_dias(envioid, diaid) values(9200,3100);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (3200, '','26/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (9300,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (9400,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (9500,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(9300,3200);
insert into envios_dias(envioid, diaid) values(9400,3200);
insert into envios_dias(envioid, diaid) values(9500,3200);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (3300, '','27/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (9600,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (9700,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (9800,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(9600,3300);
insert into envios_dias(envioid, diaid) values(9700,3300);
insert into envios_dias(envioid, diaid) values(9800,3300);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (3400, '','28/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (9900,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (10000,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (10100,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(9900,3400);
insert into envios_dias(envioid, diaid) values(10000,3400);
insert into envios_dias(envioid, diaid) values(10100,3400);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (3500, '','29/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (10200,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (10300,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (10400,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(10200,3500);
insert into envios_dias(envioid, diaid) values(10300,3500);
insert into envios_dias(envioid, diaid) values(10400,3500);

insert into DIAS_SEMANAS(DIAID, SEMANAID) values (2900,225);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3000,225);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3100,225);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3200,225);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3300,225);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3400,225);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3500,225);

insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (8500,10,'Huevo y Jamón','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (8600,187,'Esparragos y Pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (8700,93,'Carne','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (8800,87,'Leche y fresas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (8900,98,'Pescado','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (9000,200,'Queso Cottage','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (9100,10,'Huevo y Jamón','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (9200,187,'Esparragos y Pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (9300,93,'Carne','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (94000,87,'Leche y fresas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (9500,98,'Pescado','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (9600,200,'Queso Cottage','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (9700,10,'Huevo y Jamón','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (9800,187,'Esparragos y Pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (9900,93,'Carne','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (10000,87,'Leche y fresas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (10100,98,'Pescado','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (10200,200,'Queso Cottage','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (10300,10,'Huevo y Jamón','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (10400,187,'Esparragos y Pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (10500,93,'Carne','Cena');

insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2900,8500);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2900,8600);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(2900,8700);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3000,8800);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3000,8900);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3000,9000);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3100,9100);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3100,9200);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3100,9300);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3200,9400);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3200,9500);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3200,9600);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3300,9700);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3300,9800);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3300,9900);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3400,10000);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3400,10100);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3400,10200);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3500,10300);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3500,10400);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3500,10500);

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (3600, '', '30/04/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (10500,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (10600,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (10700,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(10500,3600);
insert into envios_dias(envioid, diaid) values(10600,3600);
insert into envios_dias(envioid, diaid) values(10700,3600);

insert into DiaEntity(id, recomendacion, fecha, seenvia) values (3700, '', '01/05/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (10800,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (10900,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (11000,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(10800,3700);
insert into envios_dias(envioid, diaid) values(10900,3700);
insert into envios_dias(envioid, diaid) values(11000,3700);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (3800, '', '02/05/2018', 1);

insert into EnvioEntity (id,duracion,direccion,recibido) values (11100,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (11200,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (11300,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(11100,3800);
insert into envios_dias(envioid, diaid) values(11200,3800);
insert into envios_dias(envioid, diaid) values(11300,3800);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (3900, 'Una harina diaria','03/05/2018', 0);

insert into EnvioEntity (id,duracion,direccion,recibido) values (11400,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (11500,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (11600,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(11400,3900);
insert into envios_dias(envioid, diaid) values(11500,3900);
insert into envios_dias(envioid, diaid) values(11600,3900);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (4000, 'Consumir arroz integral','04/05/2018', 0);

insert into EnvioEntity (id,duracion,direccion,recibido) values (11700,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (11800,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (11900,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(11700,4000);
insert into envios_dias(envioid, diaid) values(11800,4000);
insert into envios_dias(envioid, diaid) values(11900,4000);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (4100, 'Una harina diaria','05/05/2018', 0);

insert into EnvioEntity (id,duracion,direccion,recibido) values (12000,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (12100,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (12200,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(12000,4100);
insert into envios_dias(envioid, diaid) values(12100,4100);
insert into envios_dias(envioid, diaid) values(12200,4100);

insert into DiaEntity(id, recomendacion, fecha, seEnvia) values (4200, 'Una harina diaria','06/05/2018', 0);

insert into EnvioEntity (id,duracion,direccion,recibido) values (12300,10,'Calle 2', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (12400,10,'Carrera 3', 1);
insert into EnvioEntity (id,duracion,direccion,recibido) values (12500,10,'Calle 7', 1);
insert into envios_dias(envioid, diaid) values(12300,4200);
insert into envios_dias(envioid, diaid) values(12400,4200);
insert into envios_dias(envioid, diaid) values(12500,4200);

insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3600,226);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3700,226);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3800,226);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (3900,226);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (4000,226);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (4100,226);
insert into DIAS_SEMANAS(DIAID, SEMANAID) values (4200,226);

insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (10600,10,'Queso y Uvas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (10700,187,'Carne molida','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (10800,93,'Pescado','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (10900,87,'Cereal y Almendras','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (11000,98,'Pescado','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (11100,200,'Queso Cottage','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (11200,10,'Queso y Uvas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (11300,187,'Esparragos y Pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (11400,93,'Carne','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (11500,87,'Cereal y Almendras','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (11600,98,'Arroz con pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (11700,200,'Queso Cottage','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (11800,10,'Queso y Uvas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (11900,187,'Espinacas con frambuesas','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (12000,93,'Carne','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (12100,87,'Leche y fresas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (12200,98,'Pescado','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (12300,200,'Queso Cottage','Cena');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (12400,10,'Queso y Uvas','Desayuno');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (12500,187,'Esparragos y Pollo','Almuerzo');
insert into ComidaEntity(id,cantidad,alimentos,TIPO) values (12600,93,'Carne Asada','Cena');

insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3600,10600);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3600,10700);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3600,10800);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3700,10900);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3700,11000);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3700,11100);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3800,11200);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3800,11300);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3800,11400);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3900,11500);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3900,11600);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(3900,11700);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(4000,11800);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(4000,11900);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(4000,12000);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(4100,12100);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(4100,12200);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(4100,12300);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(4200,12400);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(4200,12500);
insert into DIAS_COMIDAS(DIAID, COMIDAID)values(4200,12600);



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

insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (223,600);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (224,600);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (225,600);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (226,600);

insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (221,700);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (222,700);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (223,700);

insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (221,800);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (222,800);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (223,800);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (224,800);
insert into SEMANAS_DIETAS(SEMANAID, DIETAID) VALUES (225,800);

insert into envios_dias(envioid, diaid) values(100,2900);
