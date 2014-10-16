SELECT dia, horaini, horafin, nombreambiente, nombredisertante
FROM
	(SELECT disertante_iddisertante, periodo_idperiodo, ambiente_idambiente, dia
	FROM
		(SELECT idcurso FROM curso WHERE tema = 'sis2') AS uno, clase
	WHERE uno.idcurso = clase.curso_idcurso) AS dos, disertante, ambiente, periodo
WHERE dos.disertante_iddisertante = disertante.iddisertante and dos.periodo_idperiodo = periodo.idperiodo and dos.ambiente_idambiente = ambiente.idambiente
