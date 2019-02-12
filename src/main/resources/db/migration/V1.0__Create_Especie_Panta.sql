CREATE SEQUENCE IF NOT EXISTS especie_planta_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE TABLE IF NOT EXISTS especie_planta (
    id INT8 DEFAULT nextval('especie_planta_id_seq'),
    nome VARCHAR(100) NOT NULL ,
    umidade_minima FLOAT NOT NULL ,
    umidade_maxima FLOAT NOT NULL ,
    url_imagem VARCHAR(255),

    CONSTRAINT especie_planta_id_pk PRIMARY KEY (id)
);

INSERT INTO especie_planta
VALUES (nextval('especie_planta_id_seq'), 'Morango',  60.00, 80.00, 'https://www.zigg.com.br/static/img/no-imagem.png'),
       (nextval('especie_planta_id_seq'), 'Cactus',   20.00, 50.00, 'https://www.zigg.com.br/static/img/no-imagem.png'),
       (nextval('especie_planta_id_seq'), 'Cogumelo', 80.00, 90.00, 'https://www.zigg.com.br/static/img/no-imagem.png'),
       (nextval('especie_planta_id_seq'), 'Violeta',  40.00, 80.00, 'https://www.zigg.com.br/static/img/no-imagem.png'),
       (nextval('especie_planta_id_seq'), 'Lavanda',  20.00, 30.00, 'https://www.zigg.com.br/static/img/no-imagem.png');


CREATE SEQUENCE IF NOT EXISTS planta_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE TABLE IF NOT EXISTS planta (
                                    id INT8 DEFAULT nextval('planta_id_seq'),
                                    codigo_sensor VARCHAR(100) NOT NULL ,
                                    especie_planta_id INT8 NOT NULL,

                                    CONSTRAINT planta_id_pk PRIMARY KEY (id),
                                    CONSTRAINT especie_planta_id_fk FOREIGN KEY (especie_planta_id) REFERENCES especie_planta(id)
);

CREATE SEQUENCE IF NOT EXISTS historico_umidade_planta_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE TABLE IF NOT EXISTS historico_umidade_planta (
                                                      id INT8 DEFAULT nextval('historico_umidade_planta_id_seq'),
                                                      planta_id INT8 NOT NULL,
                                                      data DATE,

                                                      CONSTRAINT historico_umidade_planta_id_pk PRIMARY KEY (id),
                                                      CONSTRAINT planta_id_fk FOREIGN KEY (planta_id) REFERENCES planta(id)
);