INSERT INTO estudiante (estu_id,
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

INSERT INTO estudiante (estu_id,
                        estu_apellido,
                        estu_nombre,
                        estu_genero,
                        estu_fecha_nacimiento,
                        estu_cedula)
VALUES (nextval('seq_estudiante'),
        'Perez',
        'Juan',
        'M',
        '2000-01-01',
        '0987654321');

INSERT INTO estudiante (estu_id,
                        estu_apellido,
                        estu_nombre,
                        estu_genero,
                        estu_fecha_nacimiento,
                        estu_cedula)
VALUES (nextval('seq_estudiante'),
        'Intriago',
        'Alison',
        'F',
        '2002-06-06',
        '0123456789');

INSERT INTO profesor (prof_id,
                        prof_nombre,
                        prof_apellido,
                        prof_fecha_nacimiento,
                        prof_cedula,
                        prof_genero,
                        prof_facultad,
                        prof_especialidad)
VALUES (nextval('seq_profesor'),
        'Edison',
        'Cayambe',
        '1980-01-01',
        '1122334455',
        'M',
        'FING',
        'Programacion avanzada II');

INSERT INTO profesor (prof_id,
                        prof_nombre,
                        prof_apellido,
                        prof_fecha_nacimiento,
                        prof_cedula,
                        prof_genero,
                        prof_facultad,
                        prof_especialidad)
VALUES (nextval('seq_profesor'),
        'Byron',
        'Torres',
        '1985-06-06',
        '5544332211',
        'M',
        'FING',
        'Base de datos II');
