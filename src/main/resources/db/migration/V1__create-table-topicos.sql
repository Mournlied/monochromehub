CREATE TABLE topicos (
     topic_id SERIAL NOT NULL PRIMARY KEY,
     titulo VARCHAR (255) UNIQUE NOT NULL,
     mensaje TEXT UNIQUE NOT NULL,
     fecha_creacion TIMESTAMPTZ NOT NULL,
     status SMALLINT NOT NULL,
     autor VARCHAR (100) NOT NULL,
     curso VARCHAR (100) NOT NULL
);
