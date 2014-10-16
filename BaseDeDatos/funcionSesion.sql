CREATE OR REPLACE FUNCTION iniciarSesion(VARCHAR, VARCHAR)
RETURNS boolean AS
$BODY$
DECLARE
nombre ALIAS FOR $1,
pass ALIAS FOR $2, 
correcto boolean;
encontrado integer;
BEGIN
SELECT COUNT(*) FROM usuario WHERE usuario.login = nombre and usuario.password = pass INTO encontrado;
correcto := encontrado = 1;
IF(correcto)
THEN
INSERT INTO sesion(USUARIO_login, pid, activo)
VALUES(nombre, pg_backend_pid(), true);
END IF;
RETURN correcto;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION cerrarSesion()
RETURNS boolean AS
$BODY$
DECLARE
BEGIN
UPDATE SESION SET activo = false WHERE pid = pg_backend_pid();
RETURN true;
END;
$BODY$
LANGUAGE plpgsql;