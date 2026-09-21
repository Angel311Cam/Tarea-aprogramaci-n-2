CREATE TABLE vehiculo (
                          id SERIAL PRIMARY KEY,
                          placa VARCHAR(20) NOT NULL UNIQUE,
                          propietario VARCHAR(100) NOT NULL,
                          tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('Automovil', 'Motocicleta')),
                          hora_ingreso TIME NOT NULL,
                          horas_utilizadas INTEGER NOT NULL CHECK (horas_utilizadas > 0),
                          costo NUMERIC(10,2) NOT NULL CHECK (costo >= 0),
                          activo BOOLEAN NOT NULL DEFAULT TRUE
);

INSERT INTO vehiculo
(placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo, activo)
VALUES
    ('P123ABC', 'Angel Campos', 'Automovil', '08:00:00', 4, 40.00, TRUE),
    ('M456DEF', 'Carlos Lopez', 'Motocicleta', '09:00:00', 3, 18.00, TRUE),
    ('P789GHI', 'Maria Garcia', 'Automovil', '07:30:00', 6, 54.00, TRUE),
    ('M321JKL', 'Juan Perez', 'Motocicleta', '10:00:00', 7, 37.80, TRUE),
    ('P654MNO', 'Ana Martinez', 'Automovil', '06:45:00', 8, 72.00, TRUE);

SELECT id, placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo, activo
FROM vehiculo;

SELECT id, placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo, activo
FROM vehiculo
WHERE tipo = 'Automovil';

SELECT id, placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo, activo
FROM vehiculo
WHERE costo > 50;

SELECT id, placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo, activo
FROM vehiculo
ORDER BY costo DESC;

UPDATE vehiculo
SET propietario = 'Angel Estuardo Campos Santay'
WHERE placa = 'P123ABC';

UPDATE vehiculo
SET activo = FALSE
WHERE placa = 'M456DEF';

DELETE FROM vehiculo
WHERE placa = 'P654MNO';

SELECT id, placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo, activo
FROM vehiculo
ORDER BY id;

-- PRUEBA DE PLACA DUPLICADA
INSERT INTO vehiculo
(placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo, activo)
VALUES
    ('P123ABC', 'Propietario Duplicado', 'Automovil', '11:00:00', 2, 20.00, TRUE);

-- PRUEBA DE HORAS INVALIDAS
INSERT INTO vehiculo
(placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo, activo)
VALUES
    ('X999XXX', 'Prueba Invalida', 'Automovil', '12:00:00', 0, 0.00, TRUE);