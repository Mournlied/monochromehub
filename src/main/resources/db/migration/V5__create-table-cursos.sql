CREATE TABLE cursos (
     curso_id SERIAL NOT NULL PRIMARY KEY,
     nombre VARCHAR (100) UNIQUE NOT NULL,
     categoria VARCHAR (100) UNIQUE NOT NULL
);