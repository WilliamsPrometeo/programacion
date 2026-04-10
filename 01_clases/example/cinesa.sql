CREATE TABLE usuarios(
	id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	dni VARCHAR(9) UNIQUE NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	email VARCHAR(150) UNIQUE NOT NULL,
	password VARCHAR(55) NOT NULL
);

CREATE TABLE peliculas (
	id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	titulo VARCHAR(200) NOT NULL,
	director VARCHAR(150),
	duracion INT CHECK (duracion > 0),
	fecha_publicacion DATE
);

CREATE TABLE visualizaciones (
	id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	id_usuario INT NOT NULL,
	id_pelicula INT NOT NULL,
	fecha_visualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

	CONSTRAINT fk_visualizaciones_usuario
		FOREIGN KEY (id_usuario)
		REFERENCES usuarios(id)
		ON DELETE CASCADE,

	CONSTRAINT fk_visualizaciones_pelicula
		FOREIGN KEY (id_pelicula)
		REFERENCES peliculas(id)
		ON DELETE CASCADE
);