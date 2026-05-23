INSERT INTO estudiante(estu_id,
                        estu_apellido,
                        estu_nombre,
                        estu_genero,
                        estu_fecha_nacimiento,
                        estu_cedula)
VALUES (nextval('seq_estudiante'),
        'Salazar',
        'David',
        'M',
        '1998-01-03',
        '1234567890');