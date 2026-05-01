INSERT INTO exercise (exercise_id, name, muscle_group, description)
VALUES
    ('edc24847-c54c-4f96-82a7-108387f79894', 'Sentadilla', 'Piernas', 'Ejercicio compuesto para cuádriceps, glúteos e isquiotibiales.'),
    ('129d00a4-4730-43b4-967d-ec9431321554', 'Press banca', 'Pecho', 'Ejercicio compuesto para pecho, tríceps y deltoides anteriores.'),
    ('12e55427-dc02-4d3b-a42d-8421583e8f48', 'Peso muerto', 'Espalda', 'Movimiento de fuerza para cadena posterior, espalda baja y glúteos.'),
    ('1da053cb-5e18-41f9-8fe9-15c60feb1042', 'Press militar', 'Hombros', 'Press vertical para deltoides, tríceps y estabilidad del core.'),
    ('032c6bb9-96f8-42d7-bb95-f960e53acf49', 'Dominadas', 'Espalda', 'Ejercicio de tracción vertical para dorsales y bíceps.'),
    ('3890fb49-23a1-4dc6-b828-3e8ab8597886', 'Remo con barra', 'Espalda', 'Ejercicio de tracción horizontal para dorsales, romboides y trapecios.'),
    ('34fcf9c6-3f94-4832-9a49-a532d8be4091', 'Curl bíceps', 'Brazos', 'Ejercicio de aislamiento para bíceps.'),
    ('23eb12d2-cb7c-4989-8b1c-557ba579ecfe', 'Extensión tríceps', 'Brazos', 'Ejercicio de aislamiento para tríceps.'),
    ('f5a18d83-d2a1-4df7-8fd5-d9c1abeb4337', 'Zancadas', 'Piernas', 'Ejercicio unilateral para cuádriceps, glúteos y estabilidad.'),
    ('29bd461b-2486-49e7-9266-c4bb782286fa', 'Prensa de piernas', 'Piernas', 'Ejercicio guiado para desarrollar fuerza e hipertrofia en piernas.'),
    ('fb701208-877e-474e-aba2-e269e1940d0b', 'Elevación de talones', 'Pantorrillas', 'Ejercicio de aislamiento para gastrocnemios y sóleo.'),
    ('089fd91c-71ac-4b4f-bae1-3e078d7b55b5', 'Fondos en paralelas', 'Pecho', 'Ejercicio de empuje para pecho, tríceps y hombros.'),
    ('4eaff5f5-4836-4d78-85b1-9911b8bcbd47', 'Aperturas con mancuernas', 'Pecho', 'Ejercicio de aislamiento para pectorales.'),
    ('eecfd281-c757-4959-9aa1-d1c7b74bf0d7', 'Jalón al pecho', 'Espalda', 'Tracción vertical para dorsales y control escapular.'),
    ('62f9debb-243c-4342-ab1b-a215a082149c', 'Face pull', 'Hombros', 'Ejercicio correctivo para deltoides posteriores y manguito rotador.'),
    ('c564bf2f-6a97-40ab-8014-8c63df329a7e', 'Elevaciones laterales', 'Hombros', 'Ejercicio de aislamiento para deltoides medios.'),
    ('dd3ec28d-55ca-451f-b5de-9846e908fbd8', 'Hip thrust', 'Glúteos', 'Ejercicio dominante de cadera para glúteos e isquiotibiales.'),
    ('7d9a2208-9497-4545-88fa-5c84ef0779d1', 'Plancha abdominal', 'Core', 'Ejercicio isométrico para estabilidad del core.'),
    ('310a5063-270e-4678-8030-0a730b7f75e7', 'Crunch abdominal', 'Core', 'Ejercicio de flexión de tronco para abdominales.'),
    ('b4ba5964-2894-4c94-913c-febe943dadbf', 'Burpees', 'Cardio', 'Ejercicio metabólico de cuerpo completo.');

INSERT INTO routine (routine_id, user_id, name, description)
VALUES
    ('ae4d8f58-460a-4903-b71d-5f4a0dc92cdd', '19a38146-a241-4f90-8380-1acef1e818b6', 'Fuerza tren inferior', 'Rutina enfocada en sentadilla y peso muerto.'),
    ('9c609455-915c-4b46-bd3c-3a46e2fba51b', '4436eb0d-f3b4-4327-8b1f-c8b4716db3f4', 'Powerlifting básico', 'Rutina de fuerza para los levantamientos principales.'),
    ('0fc6c6bd-0ea7-46e9-bd00-74346ada0406', 'e4675d09-e2b2-49ac-aae9-3e00fdb06abd', 'Full body funcional', 'Entrenamiento general de fuerza y acondicionamiento.'),
    ('29392722-2141-4863-b1cb-432ad4d1b68d', 'e0ff2a02-3364-434b-a368-44cf8cf13168', 'Push day', 'Rutina de empuje para pecho, hombros y tríceps.'),
    ('8a8bcde1-a87f-4286-8338-afc6205e6a4d', '0a1444be-4672-439f-b31c-52fe37bd47f9', 'Pull day', 'Rutina de tracción para espalda y bíceps.'),
    ('4917b176-51b6-4b20-bd89-2c9f76c7c609', 'c14528de-487c-4da9-9138-4b220ccaf429', 'Hipertrofia superior', 'Rutina de volumen para torso y brazos.');

INSERT INTO workout_session (session_id, user_id, routine_id, started_at, finished_at, notes)
VALUES
    ('eb7290e2-fd2e-4ea8-a0cd-6db866c43db9', '19a38146-a241-4f90-8380-1acef1e818b6', 'ae4d8f58-460a-4903-b71d-5f4a0dc92cdd', '2026-04-20 07:30:00', '2026-04-20 08:45:00', 'Buena sesión de piernas, sentadilla sólida.'),
    ('7132162f-048a-4005-9558-9d6777c7e2ac', '4436eb0d-f3b4-4327-8b1f-c8b4716db3f4', '9c609455-915c-4b46-bd3c-3a46e2fba51b', '2026-04-21 18:00:00', '2026-04-21 19:20:00', 'Día pesado de press banca y peso muerto.'),
    ('f00a71f8-11bb-4857-8a1a-d00a1cc92eb9', 'e4675d09-e2b2-49ac-aae9-3e00fdb06abd', '0fc6c6bd-0ea7-46e9-bd00-74346ada0406', '2026-04-22 06:45:00', '2026-04-22 07:50:00', 'Sesión full body con buen ritmo.'),
    ('0ada5e58-b707-466e-86fc-2d3c2a5757bc', 'e0ff2a02-3364-434b-a368-44cf8cf13168', '29392722-2141-4863-b1cb-432ad4d1b68d', '2026-04-23 17:30:00', '2026-04-23 18:35:00', 'Mejor técnica en press militar.'),
    ('2354c68b-db8c-497b-9dc3-49dd08a28138', '0a1444be-4672-439f-b31c-52fe37bd47f9', '8a8bcde1-a87f-4286-8338-afc6205e6a4d', '2026-04-24 19:00:00', '2026-04-24 20:10:00', 'Dominadas y remo con buena intensidad.'),
    ('cc543ab2-2ae3-4afa-a4da-78f5a64adb52', 'c14528de-487c-4da9-9138-4b220ccaf429', '4917b176-51b6-4b20-bd89-2c9f76c7c609', '2026-04-25 09:15:00', '2026-04-25 10:30:00', 'Volumen alto para torso.');

INSERT INTO personal_record (record_id, user_id, exercise_id, session_id, weight_kg, reps, achieved_at)
VALUES
    ('d910e7f6-d9a7-4b64-8003-82d0eb00fff6', '19a38146-a241-4f90-8380-1acef1e818b6', 'edc24847-c54c-4f96-82a7-108387f79894', 'eb7290e2-fd2e-4ea8-a0cd-6db866c43db9', 140.00, 5, '2026-04-20 08:10:00'),
    ('fdf1e70c-a89c-49ec-b896-f272f3e5daab', '19a38146-a241-4f90-8380-1acef1e818b6', '12e55427-dc02-4d3b-a42d-8421583e8f48', 'eb7290e2-fd2e-4ea8-a0cd-6db866c43db9', 180.00, 3, '2026-04-20 08:35:00'),
    ('c12125aa-eff0-492c-9255-098ecf53627c', '4436eb0d-f3b4-4327-8b1f-c8b4716db3f4', '129d00a4-4730-43b4-967d-ec9431321554', '7132162f-048a-4005-9558-9d6777c7e2ac', 95.00, 4, '2026-04-21 18:40:00'),
    ('97df48b6-a164-4612-b443-950290b45c10', '4436eb0d-f3b4-4327-8b1f-c8b4716db3f4', '12e55427-dc02-4d3b-a42d-8421583e8f48', '7132162f-048a-4005-9558-9d6777c7e2ac', 160.00, 2, '2026-04-21 19:05:00'),
    ('33d5eb59-6058-4915-8d64-db01baf5d1d9', 'e4675d09-e2b2-49ac-aae9-3e00fdb06abd', '032c6bb9-96f8-42d7-bb95-f960e53acf49', 'f00a71f8-11bb-4857-8a1a-d00a1cc92eb9', 0.00, 12, '2026-04-22 07:20:00'),
    ('0a28e033-834a-4920-8c6f-19a29b169224', 'e0ff2a02-3364-434b-a368-44cf8cf13168', '1da053cb-5e18-41f9-8fe9-15c60feb1042', '0ada5e58-b707-466e-86fc-2d3c2a5757bc', 45.00, 6, '2026-04-23 18:05:00'),
    ('a8ad85a7-33f2-4114-bc51-f739584d65d1', '0a1444be-4672-439f-b31c-52fe37bd47f9', '3890fb49-23a1-4dc6-b828-3e8ab8597886', '2354c68b-db8c-497b-9dc3-49dd08a28138', 100.00, 8, '2026-04-24 19:45:00'),
    ('0eff5c1c-16d3-47fa-b34d-0baf5b89a5d9', 'c14528de-487c-4da9-9138-4b220ccaf429', '34fcf9c6-3f94-4832-9a49-a532d8be4091', 'cc543ab2-2ae3-4afa-a4da-78f5a64adb52', 35.00, 10, '2026-04-25 10:05:00');
