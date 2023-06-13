-- DROP SCHEMA comercios;

CREATE SCHEMA comercios AUTHORIZATION postgres;
-- comercios.comercios definition

-- Drop table

-- DROP TABLE comercios.comercios;

CREATE TABLE comercios.comercios (
	id_comercio int4 NOT NULL,
	nombre varchar NOT NULL,
	descripcion varchar NULL,
	logo varchar NULL,
	activo int4 NULL DEFAULT 1,
	created date NULL,
	CONSTRAINT comercios_pk PRIMARY KEY (id_comercio)
);


-- comercios.ventas_estado definition

-- Drop table

-- DROP TABLE comercios.ventas_estado;

CREATE TABLE comercios.ventas_estado (
	id_venta_estado int4 NOT NULL,
	nombre varchar NULL,
	CONSTRAINT ventas_estado_pk PRIMARY KEY (id_venta_estado)
);


-- comercios.catalogos definition

-- Drop table

-- DROP TABLE comercios.catalogos;

CREATE TABLE comercios.catalogos (
	id_catalogo int4 NOT NULL,
	nombre varchar NULL, -- nombres del producto o servicio
	descripcion varchar NULL,
	precio numeric NULL,
	imagen varchar NULL,
	id_comercio int4 NULL,
	activo int4 NULL DEFAULT 1,
	created date NULL,
	CONSTRAINT catalogos_pk PRIMARY KEY (id_catalogo),
	CONSTRAINT catalogos_fk_1 FOREIGN KEY (id_comercio) REFERENCES comercios.comercios(id_comercio) ON DELETE CASCADE
);

-- Column comments

COMMENT ON COLUMN comercios.catalogos.nombre IS 'nombres del producto o servicio';


-- comercios.usuarios definition

-- Drop table

-- DROP TABLE comercios.usuarios;

CREATE TABLE comercios.usuarios (
	id_usuario int4 NOT NULL,
	correo varchar NOT NULL,
	nombres varchar NULL,
	apellidos varchar NULL,
	contacto varchar NULL, -- numero de telefono usuario
	direccion varchar NULL,
	"password" varchar NULL,
	activo int4 NULL DEFAULT 1,
	rol varchar NULL,
	created date NULL,
	id_comercio int4 NULL,
	CONSTRAINT newtable_pk PRIMARY KEY (id_usuario),
	CONSTRAINT usuarios_fk FOREIGN KEY (id_comercio) REFERENCES comercios.comercios(id_comercio)
);

-- Column comments

COMMENT ON COLUMN comercios.usuarios.contacto IS 'numero de telefono usuario';


-- comercios.ventas definition

-- Drop table

-- DROP TABLE comercios.ventas;

CREATE TABLE comercios.ventas (
	id_venta int4 NOT NULL,
	id_usuario int4 NULL,
	fecha_anula date NULL,
	fecha_pago date NULL,
	observaciones varchar NULL,
	created date NULL,
	id_comercio int4 NULL,
	id_venta_estado int4 NULL,
	CONSTRAINT ventas_pk PRIMARY KEY (id_venta),
	CONSTRAINT ventas_estado_fk FOREIGN KEY (id_venta_estado) REFERENCES comercios.ventas_estado(id_venta_estado),
	CONSTRAINT ventas_fk FOREIGN KEY (id_usuario) REFERENCES comercios.usuarios(id_usuario) ON DELETE CASCADE,
	CONSTRAINT ventas_fk_1 FOREIGN KEY (id_comercio) REFERENCES comercios.comercios(id_comercio) ON DELETE CASCADE
);


-- comercios.ventas_detalle definition

-- Drop table

-- DROP TABLE comercios.ventas_detalle;

CREATE TABLE comercios.ventas_detalle (
	id_venta_detalle int4 NOT NULL,
	id_venta int4 NULL,
	id_catalogo int4 NULL,
	cantidad int4 NULL,
	total numeric NULL,
	created date NULL,
	precio numeric NULL,
	CONSTRAINT ventas_detalle_pk PRIMARY KEY (id_venta_detalle),
	CONSTRAINT ventas_detalle_fk FOREIGN KEY (id_catalogo) REFERENCES comercios.catalogos(id_catalogo) ON DELETE CASCADE,
	CONSTRAINT ventas_detalle_fk_1 FOREIGN KEY (id_venta) REFERENCES comercios.ventas(id_venta) ON DELETE CASCADE
);

-- Funcion para encriptar a usuarios
CREATE OR REPLACE FUNCTION encriptar_md5()
    RETURNS trigger AS
$BODY$
BEGIN
    NEW."password" := md5(NEW."password");
    RETURN NEW;
END;
$BODY$
    LANGUAGE plpgsql;

create or replace TRIGGER trigger_encriptar_md5
    BEFORE INSERT ON comercios.usuarios
    FOR EACH ROW
EXECUTE FUNCTION encriptar_md5();
