-- GESTIONAR_EQUIPOS_TEST
/* 
 Fecha: 03/05/2022
 Descripcion:  Testeo paquete gestion de EQUIPOS

 */
 
SET SERVEROUTPUT ON;

-- **************************************************************
/*
    Procedimiento INSERT_EQUIPO: 
*/
DECLARE
    P_NOMBRE VARCHAR2(30) := 'Gasteiz-Goya';
    P_FECHA_FUNDACION DATE := TO_DATE('23/01/2021','DD/MM/YYYY');
    P_CIUDAD VARCHAR2(30) := 'Vitoria';
    P_ESPONSOR VARCHAR2(20) := 'Goya';
    P_NOMBRE_DUENIO VARCHAR2(20) := 'Eneko Alonso';
BEGIN
    GEST_EQUIPO.INSERT_EQUIPO(P_NOMBRE, P_FECHA_FUNDACION, P_CIUDAD, P_ESPONSOR, 
            P_NOMBRE_DUENIO); 
END;

 -- genera error de nombre de equipo duplicado
 DECLARE
    P_NOMBRE VARCHAR2(30) := 'Gasteiz-Goya';
    P_FECHA_FUNDACION DATE := TO_DATE('23/01/2021','DD/MM/YYYY');
    P_CIUDAD VARCHAR2(30) := 'Vitoria';
    P_ESPONSOR VARCHAR2(20) := 'Goya';
    P_NOMBRE_DUENIO VARCHAR2(20) := 'Eneko Alonso';
BEGIN
    GEST_EQUIPO.INSERT_EQUIPO(P_NOMBRE, P_FECHA_FUNDACION, P_CIUDAD, P_ESPONSOR, 
            P_NOMBRE_DUENIO); 
END;

SELECT * FROM EQUIPOS;

-- **************************************************************
/*
    Procedimiento CONTRATO_JUGADOR: 
*/
DECLARE
    P_COD_JUGADOR NUMBER(2) := 06;
    P_COD_EQUIPO NUMBER(2) := 01;
    P_FECHA_FIN DATE := TO_DATE('30/06/2023','DD/MM/YYYY');
    P_FECHA_INICIO DATE := TO_DATE('04/07/2021','DD/MM/YYYY');
BEGIN
    GEST_EQUIPO.CONTRATO_JUGADOR(P_COD_JUGADOR, P_COD_EQUIPO, P_FECHA_FIN, P_FECHA_INICIO); 
END;

SELECT * FROM jugar_para;

-- **************************************************************
/*
    Procedimiento CONTRATO_ENTRENADOR: 
*/
DECLARE
    COD_ENTRENADOR NUMBER(2) := 12;
    P_COD_EQUIPO NUMBER(2) := 03;
    P_FECHA_FIN DATE := TO_DATE('30/06/2023','DD/MM/YYYY');
    P_FECHA_INICIO DATE := TO_DATE('04/07/2021','DD/MM/YYYY');
BEGIN
    GEST_EQUIPO.CONTRATO_ENTRENADOR(COD_ENTRENADOR, P_COD_EQUIPO, P_FECHA_FIN, P_FECHA_INICIO); 
END;

SELECT * FROM ENTRENA;


-- **************************************************************
/*
    Procedimiento CONTRATO_ENTRENADOR: 
*/
DECLARE
    COD_ASISTENTE NUMBER(2) := 10;
    P_COD_EQUIPO NUMBER(2) := 03;
    P_FECHA_FIN DATE := TO_DATE('30/06/2023','DD/MM/YYYY');
    P_FECHA_INICIO DATE := TO_DATE('04/07/2021','DD/MM/YYYY');
BEGIN
    GEST_EQUIPO.CONTRATO_ASISTENTE(COD_ASISTENTE, P_COD_EQUIPO, P_FECHA_FIN, P_FECHA_INICIO); 
END;

SELECT * FROM ASISTE;

--ROLLBACK;