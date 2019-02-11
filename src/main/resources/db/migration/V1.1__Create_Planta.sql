CREATE SEQUENCE planta_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE TABLE IF NOT EXISTS planta (
    id INTEGER DEFAULT nextval('planta_id_seq'),
    codigo_sensor VARCHAR(100) NOT NULL ,
    especie_planta_id INTEGER NOT NULL,

    CONSTRAINT planta_id_pk PRIMARY KEY (id),
    CONSTRAINT especie_planta_id_fk FOREIGN KEY (especie_planta_id) REFERENCES especie_planta(id)
);
