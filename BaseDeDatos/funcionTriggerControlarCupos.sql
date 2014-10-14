CREATE OR REPLACE FUNCTION controlarCupo()
RETURNS TRIGGER AS
$BODY$
DECLARE
numeroInscripciones int;
cupoMaximo int;
BEGIN
SELECT COUNT(*) FROM inscripcion WHERE inscripcion.curso_idcurso = NEW.curso_idcurso INTO numeroInscripciones;
SELECT cupo FROM curso WHERE idcurso = NEW.curso_idcurso INTO cupoMaximo;
IF(numeroInscripciones < cupoMaximo)
THEN
RETURN NEW;
ELSE
RETURN NULL;
END IF;
END;
$BODY$
LANGUAGE plpgsql;

CREATE TRIGGER controlarCupo BEFORE INSERT
ON inscripcion
FOR EACH ROW
EXECUTE PROCEDURE controlarCupo();