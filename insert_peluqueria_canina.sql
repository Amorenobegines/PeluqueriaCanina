--
-- Volcado de datos para la tabla `duenio`
--

INSERT INTO `duenio` (`ID_DUENIO`, `NOMBRE`, `TELEFONO`) VALUES
(1, 'Alicia', '660031111'),
(2, 'Jesus', '222222222'),
(3, 'Eyla', '111111111'),
(4, 'Arya', '111111111');

--
-- Volcado de datos para la tabla `mascotas`
--

INSERT INTO `mascotas` (`NUM_CLIENTE`, `ALERGICO`, `ATENCION_ESPECIAL`, `COLOR`, `NOMBREMAS`, `OBSERVACIONES`, `RAZA`, `UNDUENIO_ID_DUENIO`) VALUES
(1, 'No', 'Si', 'Marron', 'Anubis', 'Edad 13 Buena Baño', 'Malinois', 1),
(2, 'No', 'Si', 'Marron', 'Roma', 'Edad: 1 Baño', 'Golden', 2),
(3, 'No', 'Si', 'Canela', 'Kiara', 'Edad: 5 Baño', 'Labrador', 3),
(4, 'No', 'Si', 'Canela', 'Sara', 'Buena y cariñosa', 'Mastin', 4);

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`ID_SERVICIO`, `PRECIO`, `TIPOSERVICIOS`) VALUES
(1, 15, 'Baño'),
(2, 20, 'Corte de pelo'),
(3, 10, 'Corte de uñas');

--
-- Volcado de datos para la tabla `cita`
--

INSERT INTO `cita` (`id`, `fecha_hora`, `id_mascotas`) VALUES
(1, '2025-12-12 11:20:00', 4),
(2, '2025-12-05 12:45:00', 1),
(3, '2025-12-12 11:20:00', 1),
(4, '2026-01-02 13:30:00', 1);

--
-- Volcado de datos para la tabla `mascota_servicios`
--

INSERT INTO `mascota_servicios` (`id_mascota`, `id_servicio`) VALUES
(1, 1),
(2, 2),
(3, 3);

--
-- Volcado de datos para la tabla `cita_servicios`
--

INSERT INTO `cita_servicios` (`id_cita`, `id_servicio`) VALUES
(1, 1),
(2, 2),
(3, 3),
(5, 1);

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id_rol`, `nombre`) VALUES
(1, 'Administrador'),
(2, 'Recepcionista'),
(3, 'Trabajador');

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellido`, `email`, `clave`, `tipo_nivel`) VALUES
(15, 'Alicia', 'Moreno', 'alicia@gmail.com', '12345', 'Administrador'),
(10, 'MAria Trinidad', 'maria', 'maria@gmail.com', '12345', 'Recepcionista'),
(11, 'lucia', 'lucia', 'lucia@gmail.com', '12345', 'Trabajador'),
(12, 'Lola', 'lola', 'lola@gmail.com', '12345', 'Trabajador'),
(16, 'Jesus', 'jesus', 'jesus@gmail.com', '12345', 'Recepcionista');
COMMIT;

