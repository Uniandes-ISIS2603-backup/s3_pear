delete from CalificacionEntity;
delete from QuejasyReclamosEntity;

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
