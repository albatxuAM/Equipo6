/*******CREACION DE VISTAS********/

CREATE OR REPLACE VIEW VISTA_JUGADOR AS
(
    SELECT J.COD_JUGADOR, P.NICKNAME, J.ROL, JP.COD_EQUIPO,
    P.NOMBRE, P.APELLIDO, P.FECHA_NACIMIENTO, P.NACIONALIDAD, 
    P.SUELDO 
    FROM JUGADORES J, PERSONAS P, JUGAR_PARA JP
    WHERE J.COD_JUGADOR = P.COD_PERSONA
    AND J.COD_JUGADOR = JP.COD_JUGADOR
)WITH READ ONLY;

CREATE OR REPLACE VIEW VISTA_ENTRENADOR AS
(
    SELECT E.COD_ENTRENADOR, P.NICKNAME, T.COD_EQUIPO, 
    P.NOMBRE, P.APELLIDO, P.FECHA_NACIMIENTO, P.NACIONALIDAD,
    P.SUELDO
    FROM ENTRENADORES E, PERSONAS P, ENTRENA T
    WHERE E.COD_ENTRENADOR = P.COD_PERSONA 
    AND E.COD_ENTRENADOR = T.COD_ENTRENADOR
)WITH READ ONLY;

CREATE OR REPLACE VIEW VISTA_ASISTENTE AS
(
    SELECT A.COD_ASISTENTE, P.NICKNAME, H.COD_EQUIPO,
    P.NOMBRE, P.APELLIDO, P.FECHA_NACIMIENTO, P.NACIONALIDAD,
    P.SUELDO
    FROM ASISTENTES A, PERSONAS P, ASISTE H
    WHERE A.COD_ASISTENTE = P.COD_PERSONA
    AND A.COD_ASISTENTE = H.COD_ASISTENTE
)WITH READ ONLY;

CREATE OR REPLACE VIEW VISTA_EQUIPO AS
(
    SELECT EQ.COD_EQUIPO, EQ.NOMBRE, E.COD_ENTRENADOR,
    H.COD_ASISTENTE, J.COD_JUGADOR ,EQ.FECHA_NACIMIENTO,  
    EQ.CIUDAD, EQ.ESPONSOR, EQ.NOMBRE_DUENIO
    FROM EQUIPOS EQ, ASISTE H, ENTRENA E, JUGAR_PARA J
    WHERE EQ.COD_EQUIPO = H.COD_EQUIPO
    AND EQ.COD_EQUIPO = E.COD_EQUIPO
    AND EQ.COD_EQUIPO = J.COD_EQUIPO
)WITH READ ONLY;

CREATE OR REPLACE VIEW VISTA_PARTIDO AS
(
    SELECT E.COD_EQUIPO, E.NOMBRE ,P.HORA_PARTIDO, P.COD_JORNADA, 
    P.RESULTADO
    FROM PARTIDOS P, EQUIPOS E, PARTICIPA PE
    WHERE PE.COD_PARTIDO = P.COD_PARTIDO
        AND E.COD_EQUIPO IN (PE.COD_EQUIPO1, PE.COD_EQUIPO2)
)WITH READ ONLY;

CREATE OR REPLACE VIEW VISTA_JORNADA AS
(
    SELECT J.COD_JORNADA, J.FECHA_JORNADA, P.COD_PARTIDO, 
    P.RESULTADO
    FROM JORNADAS J, PARTIDOS P 
    WHERE J.COD_JORNADA = P.COD_JORNADA
)WITH READ ONLY;

CREATE OR REPLACE VIEW VISTA_USUARIOS AS
(
    SELECT U.COD_USUARIO, U.NOMBRE, U.FECHA_NACIMIENTO, 
    U.PASSWORD_, U.EMAIL, R.COD_ROL, R.NOM_ROL
    FROM USUARIOS U, ROL R
    WHERE U.COD_ROL = R.COD_ROL
)WITH READ ONLY;

CREATE OR REPLACE VIEW VISTA_CLASIFICACION AS

(SELECT    DISTINCT T.COD_TEMPORADA, E.COD_EQUIPO, E.NOMBRE,J.ROL, PE.NICKNAME
 FROM     EQUIPOS E, JUGADORES J, PERSONAS PE, JUGAR_PARA JP,PARTICIPA PA,
           PARTIDOS PS, JORNADAS JO, TEMPORADAS T
 WHERE    E.COD_EQUIPO IN JP.COD_EQUIPO 
           AND E.COD_EQUIPO IN (PA.COD_EQUIPO1,PA.COD_EQUIPO2)
           AND PA.COD_PARTIDO=PS.COD_PARTIDO
           AND JO.COD_JORNADA IN PS.COD_JORNADA
           AND T.COD_TEMPORADA IN JO.COD_TEMPORADA
           AND JP.COD_JUGADOR=J.COD_JUGADOR 
           AND J.COD_JUGADOR=PE.COD_PERSONA 
<<<<<<< HEAD
)WITH READ ONLY;

=======
);
>>>>>>> CambioVista












