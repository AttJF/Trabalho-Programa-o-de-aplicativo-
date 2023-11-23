CREATE TABLE `clinica`.`consulta` (`IDconsulta` INT NOT NULL AUTO_INCREMENT , `IDmedico` INT NOT NULL , `dia` INT NOT NULL , `horario` INT NOT NULL , `IDpaciente` INT NOT NULL , `pago` BOOLEAN NOT NULL , PRIMARY KEY (`IDconsulta`)) ENGINE = InnoDB;

CREATE TABLE `clinica`.`paciente` (`IDpaciente` INT NOT NULL AUTO_INCREMENT , `nome` VARCHAR(50) NOT NULL , `datanascimento` VARCHAR(10) NOT NULL , `sexo` VARCHAR(50) NOT NULL , `telefone` VARCHAR(15) NOT NULL , `formapagamento` VARCHAR(50) NOT NULL , `IDendereco` INT NOT NULL , PRIMARY KEY (`IDpaciente`)) ENGINE = InnoDB;

CREATE TABLE `clinica`.`medico` (`IDmedico` INT NOT NULL AUTO_INCREMENT , `crm` INT NOT NULL , `nome` VARCHAR(50) NOT NULL , `telefone` VARCHAR(50) NOT NULL , `IDendereco` INT NOT NULL , `especialidade` VARCHAR(50) NOT NULL , PRIMARY KEY (`IDmedico`)) ENGINE = InnoDB;

CREATE TABLE `clinica`.`exame` (`IDexame` INT NOT NULL AUTO_INCREMENT , `nome` VARCHAR(50) NOT NULL , `custo` DOUBLE NOT NULL , `orientacao` VARCHAR(300) NOT NULL , PRIMARY KEY (`IDexame`)) ENGINE = InnoDB;

CREATE TABLE `clinica`.`endereco` (`IDendereco` INT NOT NULL AUTO_INCREMENT , `rua` VARCHAR(50) NOT NULL , `bairro` VARCHAR(50) NOT NULL , `cidade` VARCHAR(50) NOT NULL , `complemento` VARCHAR(100) NOT NULL , `numero` INT NOT NULL , `uniaofederativa` VARCHAR(2) NOT NULL , PRIMARY KEY (`IDendereco`)) ENGINE = InnoDB;
