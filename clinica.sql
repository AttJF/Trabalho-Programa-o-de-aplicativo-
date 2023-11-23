CREATE TABLE `clinica`.`consulta` (`IDconsulta` INT NOT NULL AUTO_INCREMENT , `IDmedico` INT NOT NULL , `dia` INT NOT NULL , `horario` INT NOT NULL , `IDpaciente` INT NOT NULL , `pago` BOOLEAN NOT NULL , PRIMARY KEY (`IDconsulta`)) ENGINE = InnoDB;

CREATE TABLE `clinica`.`paciente` (`IDpaciente` INT NOT NULL AUTO_INCREMENT , `nome` VARCHAR(50) NOT NULL , `datanascimento` VARCHAR(10) NOT NULL , `sexo` VARCHAR(50) NOT NULL , `telefone` VARCHAR(15) NOT NULL , `formapagamento` VARCHAR(50) NOT NULL , `IDendereco` INT NOT NULL , PRIMARY KEY (`IDpaciente`)) ENGINE = InnoDB;

