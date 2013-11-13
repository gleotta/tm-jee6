-- USUARIOS
INSERT INTO `usuario` (`id`,`apellido`,`contrasenia`,`email`,`fechaNacimiento`,`nombre`) VALUES  (1,'Argento','pepe','pepe@argentina.com','1971-12-28 00:00:00','Pepe');
INSERT INTO `usuario` (`id`,`apellido`,`contrasenia`,`email`,`fechaNacimiento`,`nombre`) VALUES  (2,'Argento','moni','moni@argentina.com','1973-05-11 00:00:00','Moni');

-- CATEGORIAS
INSERT INTO `categoria` (`DTYPE`,`id`,`descripcion`,`nombre`) VALUES  ('Genero',1,'De Terror','terror');
INSERT INTO `categoria` (`DTYPE`,`id`,`descripcion`,`nombre`) VALUES  ('Genero',2,'Ciencia Ficcion','ficcion');
INSERT INTO `categoria` (`DTYPE`,`id`,`descripcion`,`nombre`) VALUES  ('CategoriaDisco',3,'Rock Nacional','rock');
INSERT INTO `categoria` (`DTYPE`,`id`,`descripcion`,`nombre`) VALUES  ('CategoriaSoftware',4,'Comunicacion','comunicacion');

-- PRODUCTOS
INSERT INTO `producto` (`id`,`codigo`,`descripcion`,`imagen`,`precio`,`titulo`) VALUES  (1,'SALMON','El Salmon',NULL,'54.35','El Salmon');
INSERT INTO `producto` (`id`,`codigo`,`descripcion`,`imagen`,`precio`,`titulo`) VALUES  (2,'VOLVERFUTURO','Volever al Futuro',NULL,'35.87','Back to the Future');
INSERT INTO `producto` (`id`,`codigo`,`descripcion`,`imagen`,`precio`,`titulo`) VALUES  (3,'GTALK','Google Talk (Hangout sucks!)',NULL,'0.01','Google Talk');
INSERT INTO `disco` (`artista`,`cantidadTrack`,`id`,`categoria_id`) VALUES  ('Andres Calamaro',101,1,3);
INSERT INTO `pelicula` (`director`,`duracion`,`id`,`genero_id`) VALUES  ('Steven Spielberg',95,2,2);
INSERT INTO `software` (`autor`,`licencia`,`tamanio`,`id`,`categoria_id`) VALUES  ('Google Inc','Google','78.00',3,4);

-- COMPRA
INSERT INTO `compra` (`id`,`fecha`,`monto`,`producto_id`,`usuario_id`) VALUES  (1,'2013-11-12 21:18:06','66.00',1,1);
  
