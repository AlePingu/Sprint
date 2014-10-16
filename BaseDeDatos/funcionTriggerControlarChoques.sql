CREATE OR REPLACE FUNCTION controlarChoques()
RETURNS trigger AS
$BODY$
DECLARE
aula int;
expositor int;
BEGIN
SELECT COUNT(*) FROM clase WHERE clase.ambiente_idambiente = NEW.ambiente_idambiente and clase.periodo_idperiodo = NEW.periodo_idperiodo and clase.dia = NEW.dia INTO aula;
SELECT COUNT(*) FROM clase WHERE clase.disertante_iddisertante = NEW.disertante_iddisertante and clase.periodo_idperiodo = NEW.periodo_idperiodo and clase.dia = NEW.dia INTO expositor;
IF(aula = 0 and expositor = 0)
THEN
RETURN NEW;
ELSE
RETURN NULL;
END IF;
END;
$BODY$
LANGUAGE plpgsql;

CREATE TRIGGER controlarChoque BEFORE INSERT OR UPDATE
ON clase
FOR EACH ROW
EXECUTE PROCEDURE controlarChoques();