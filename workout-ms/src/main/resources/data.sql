INSERT INTO exercise (exercise_id, name, muscle_group, description)
VALUES
    ('10000000-0000-0000-0000-000000000001', 'Sentadilla', 'Piernas', 'Ejercicio compuesto para cuádriceps, glúteos e isquiotibiales.'),
    ('10000000-0000-0000-0000-000000000002', 'Press banca', 'Pecho', 'Ejercicio compuesto para pecho, tríceps y deltoides anteriores.'),
    ('10000000-0000-0000-0000-000000000003', 'Peso muerto', 'Espalda', 'Movimiento de fuerza para cadena posterior, espalda baja y glúteos.'),
    ('10000000-0000-0000-0000-000000000004', 'Press militar', 'Hombros', 'Press vertical para deltoides, tríceps y estabilidad del core.'),
    ('10000000-0000-0000-0000-000000000005', 'Dominadas', 'Espalda', 'Ejercicio de tracción vertical para dorsales y bíceps.'),
    ('10000000-0000-0000-0000-000000000006', 'Remo con barra', 'Espalda', 'Ejercicio de tracción horizontal para dorsales, romboides y trapecios.'),
    ('10000000-0000-0000-0000-000000000007', 'Curl bíceps', 'Brazos', 'Ejercicio de aislamiento para bíceps.'),
    ('10000000-0000-0000-0000-000000000008', 'Extensión tríceps', 'Brazos', 'Ejercicio de aislamiento para tríceps.'),
    ('10000000-0000-0000-0000-000000000009', 'Zancadas', 'Piernas', 'Ejercicio unilateral para cuádriceps, glúteos y estabilidad.'),
    ('10000000-0000-0000-0000-000000000010', 'Prensa de piernas', 'Piernas', 'Ejercicio guiado para desarrollar fuerza e hipertrofia en piernas.'),
    ('10000000-0000-0000-0000-000000000011', 'Elevación de talones', 'Pantorrillas', 'Ejercicio de aislamiento para gastrocnemios y sóleo.'),
    ('10000000-0000-0000-0000-000000000012', 'Fondos en paralelas', 'Pecho', 'Ejercicio de empuje para pecho, tríceps y hombros.'),
    ('10000000-0000-0000-0000-000000000013', 'Aperturas con mancuernas', 'Pecho', 'Ejercicio de aislamiento para pectorales.'),
    ('10000000-0000-0000-0000-000000000014', 'Jalón al pecho', 'Espalda', 'Tracción vertical para dorsales y control escapular.'),
    ('10000000-0000-0000-0000-000000000015', 'Face pull', 'Hombros', 'Ejercicio correctivo para deltoides posteriores y manguito rotador.'),
    ('10000000-0000-0000-0000-000000000016', 'Elevaciones laterales', 'Hombros', 'Ejercicio de aislamiento para deltoides medios.'),
    ('10000000-0000-0000-0000-000000000017', 'Hip thrust', 'Glúteos', 'Ejercicio dominante de cadera para glúteos e isquiotibiales.'),
    ('10000000-0000-0000-0000-000000000018', 'Plancha abdominal', 'Core', 'Ejercicio isométrico para estabilidad del core.'),
    ('10000000-0000-0000-0000-000000000019', 'Crunch abdominal', 'Core', 'Ejercicio de flexión de tronco para abdominales.'),
    ('10000000-0000-0000-0000-000000000020', 'Burpees', 'Cardio', 'Ejercicio metabólico de cuerpo completo.');

INSERT INTO routine (routine_id, user_id, name, description)
VALUES
    ('20000000-0000-0000-0000-000000000001', '19a38146-a241-4f90-8380-1acef1e818b6', 'Fuerza tren inferior', 'Rutina enfocada en sentadilla y peso muerto.'),
    ('20000000-0000-0000-0000-000000000002', '4436eb0d-f3b4-4327-8b1f-c8b4716db3f4', 'Powerlifting básico', 'Rutina de fuerza para los levantamientos principales.'),
    ('20000000-0000-0000-0000-000000000003', 'e4675d09-e2b2-49ac-aae9-3e00fdb06abd', 'Full body funcional', 'Entrenamiento general de fuerza y acondicionamiento.'),
    ('20000000-0000-0000-0000-000000000004', 'e0ff2a02-3364-434b-a368-44cf8cf13168', 'Push day', 'Rutina de empuje para pecho, hombros y tríceps.'),
    ('20000000-0000-0000-0000-000000000005', '0a1444be-4672-439f-b31c-52fe37bd47f9', 'Pull day', 'Rutina de tracción para espalda y bíceps.'),
    ('20000000-0000-0000-0000-000000000006', 'c14528de-487c-4da9-9138-4b220ccaf429', 'Hipertrofia superior', 'Rutina de volumen para torso y brazos.');

INSERT INTO workout_session (session_id, user_id, routine_id, started_at, finished_at, notes)
VALUES
    ('30000000-0000-0000-0000-000000000001', '19a38146-a241-4f90-8380-1acef1e818b6', '20000000-0000-0000-0000-000000000001', '2026-04-20 07:30:00', '2026-04-20 08:45:00', 'Buena sesión de piernas, sentadilla sólida.'),
    ('30000000-0000-0000-0000-000000000002', '4436eb0d-f3b4-4327-8b1f-c8b4716db3f4', '20000000-0000-0000-0000-000000000002', '2026-04-21 18:00:00', '2026-04-21 19:20:00', 'Día pesado de press banca y peso muerto.'),
    ('30000000-0000-0000-0000-000000000003', 'e4675d09-e2b2-49ac-aae9-3e00fdb06abd', '20000000-0000-0000-0000-000000000003', '2026-04-22 06:45:00', '2026-04-22 07:50:00', 'Sesión full body con buen ritmo.'),
    ('30000000-0000-0000-0000-000000000004', 'e0ff2a02-3364-434b-a368-44cf8cf13168', '20000000-0000-0000-0000-000000000004', '2026-04-23 17:30:00', '2026-04-23 18:35:00', 'Mejor técnica en press militar.'),
    ('30000000-0000-0000-0000-000000000005', '0a1444be-4672-439f-b31c-52fe37bd47f9', '20000000-0000-0000-0000-000000000005', '2026-04-24 19:00:00', '2026-04-24 20:10:00', 'Dominadas y remo con buena intensidad.'),
    ('30000000-0000-0000-0000-000000000006', 'c14528de-487c-4da9-9138-4b220ccaf429', '20000000-0000-0000-0000-000000000006', '2026-04-25 09:15:00', '2026-04-25 10:30:00', 'Volumen alto para torso.');

INSERT INTO personal_record (record_id, user_id, exercise_id, session_id, weight_kg, reps, achieved_at)
VALUES
    ('40000000-0000-0000-0000-000000000001', '19a38146-a241-4f90-8380-1acef1e818b6', '10000000-0000-0000-0000-000000000001', '30000000-0000-0000-0000-000000000001', 140.00, 5, '2026-04-20 08:10:00'),
    ('40000000-0000-0000-0000-000000000002', '19a38146-a241-4f90-8380-1acef1e818b6', '10000000-0000-0000-0000-000000000003', '30000000-0000-0000-0000-000000000001', 180.00, 3, '2026-04-20 08:35:00'),
    ('40000000-0000-0000-0000-000000000003', '4436eb0d-f3b4-4327-8b1f-c8b4716db3f4', '10000000-0000-0000-0000-000000000002', '30000000-0000-0000-0000-000000000002', 95.00, 4, '2026-04-21 18:40:00'),
    ('40000000-0000-0000-0000-000000000004', '4436eb0d-f3b4-4327-8b1f-c8b4716db3f4', '10000000-0000-0000-0000-000000000003', '30000000-0000-0000-0000-000000000002', 160.00, 2, '2026-04-21 19:05:00'),
    ('40000000-0000-0000-0000-000000000005', 'e4675d09-e2b2-49ac-aae9-3e00fdb06abd', '10000000-0000-0000-0000-000000000005', '30000000-0000-0000-0000-000000000003', 0.00, 12, '2026-04-22 07:20:00'),
    ('40000000-0000-0000-0000-000000000006', 'e0ff2a02-3364-434b-a368-44cf8cf13168', '10000000-0000-0000-0000-000000000004', '30000000-0000-0000-0000-000000000004', 45.00, 6, '2026-04-23 18:05:00'),
    ('40000000-0000-0000-0000-000000000007', '0a1444be-4672-439f-b31c-52fe37bd47f9', '10000000-0000-0000-0000-000000000006', '30000000-0000-0000-0000-000000000005', 100.00, 8, '2026-04-24 19:45:00'),
    ('40000000-0000-0000-0000-000000000008', 'c14528de-487c-4da9-9138-4b220ccaf429', '10000000-0000-0000-0000-000000000007', '30000000-0000-0000-0000-000000000006', 35.00, 10, '2026-04-25 10:05:00');
