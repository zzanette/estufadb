CREATE SEQUENCE especie_planta_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE TABLE IF NOT EXISTS especie_planta (
    id INTEGER DEFAULT nextval('especie_planta_id_seq'),
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
