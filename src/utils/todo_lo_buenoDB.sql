drop schema if exists todo_lo_bueno;
create schema todo_lo_bueno;
use todo_lo_bueno;


-- TABLA BODEGA -----------------------------------------------------------------------
drop table if exists bodega;
create table bodega(
	idBodega int primary key not null auto_increment,
	nombre varchar(45) not null,
	direccion varchar(45) not null
);
insert into bodega (nombre,direccion) values ("la amistad","Cra 78 # 85 -45");
insert into bodega (nombre,direccion) values ("santa isabel","Calle 34 # 45 -85");
insert into bodega (nombre,direccion) values ("santa cecilia","Cra 89 # 54 – 39");


-- TABLA PRODUCTO -----------------------------------------------------------------------
drop table if exists producto;
create table producto(
	idproducto int primary key not null auto_increment,
    nombre varchar(45) not null,
    precio decimal(8,2) not null
);
insert into producto(nombre,precio) values ("tornillo el general",93277.00);
insert into producto(nombre,precio) values ("champagne",15728.00);
insert into producto(nombre,precio) values ("mora",63781.00);
insert into producto(nombre,precio) values ("cereal",33796.00);
insert into producto(nombre,precio) values ("garbanzo",86495.00);
insert into producto(nombre,precio) values ("vino espumoso",47392.00);
insert into producto(nombre,precio) values ("arroz",67370.00);
insert into producto(nombre,precio) values ("aguardiente",69188.00);
insert into producto(nombre,precio) values ("condimentos mixtos",3025.00);
insert into producto(nombre,precio) values ("cerezas dulces",96453.00);
insert into producto(nombre,precio) values ("aguardiente",46004.00);


-- TABLA EMPLEADOS -----------------------------------------------------------------------
drop table if exists empleado;
create table empleado(
	idempleado int auto_increment primary key,
	idBodega int not null references bodega(idBodega),
    nombre varchar(45) not null,
    edad int not null
);
insert into empleado(idBodega,nombre,edad) values (1,"Sylvester Leonard",24);
insert into empleado(idBodega,nombre,edad) values (1,"Ferdinand Dixon",23);
insert into empleado(idBodega,nombre,edad) values (1,"Amanda Ayala",18);
insert into empleado(idBodega,nombre,edad) values (1,"Stephen I. Caldwell",18);
insert into empleado(idBodega,nombre,edad) values (1,"Abraham Shepherd",19);
insert into empleado(idBodega,nombre,edad) values (2,"Libby J. Hendricks",51);
insert into empleado(idBodega,nombre,edad) values (2,"Sebastian C. Fleming",50);
insert into empleado(idBodega,nombre,edad) values (3,"Taylor Z. Oliver",37);
insert into empleado(idBodega,nombre,edad) values (3,"Nora D. Erickson",32);
insert into empleado(idBodega,nombre,edad) values (3,"Leila Huffman",34);
insert into empleado(idBodega,nombre,edad) values (3,"Colby M. Stephenson",31);


-- TABLA ALMACENA -----------------------------------------------------------------------
drop table if exists almacena;
create table almacena(
	idBodega int not null references bodega(idBodega),
    idproducto int not null references producto(idproducto),
    cantidad int not null
);
insert into almacena(idBodega,idproducto,cantidad) values (1,1,65);
insert into almacena(idBodega,idproducto,cantidad) values (1,4,11);
insert into almacena(idBodega,idproducto,cantidad) values (1,10,48);
insert into almacena(idBodega,idproducto,cantidad) values (2,2,63);
insert into almacena(idBodega,idproducto,cantidad) values (2,3,35);
insert into almacena(idBodega,idproducto,cantidad) values (2,6,85);
insert into almacena(idBodega,idproducto,cantidad) values (3,2,11);
insert into almacena(idBodega,idproducto,cantidad) values (3,3,13);
insert into almacena(idBodega,idproducto,cantidad) values (3,7,19);
insert into almacena(idBodega,idproducto,cantidad) values (3,8,24);
