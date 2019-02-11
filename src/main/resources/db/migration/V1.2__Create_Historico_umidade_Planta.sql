CREATE SEQUENCE historico_umidade_planta_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE TABLE IF NOT EXISTS historico_umidade_planta (
    id INTEGER DEFAULT nextval('historico_umidade_planta_id_seq'),
    planta_id INTEGER NOT NULL,
    data DATE,

    CONSTRAINT historico_umidade_planta_id_pk PRIMARY KEY (id),
    CONSTRAINT planta_id_fk FOREIGN KEY (planta_id) REFERENCES planta(id)
);
