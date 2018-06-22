#Author: judherna@bancolombia.com.co
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.

@Regression
Feature: Agendar citas en la app de Heroku

  @TestCase1
  Scenario Outline: Agendar citas a traves de la app 
    Given Juan navega a la app de Heroku
    |<ID>|<ORIENTACION>|<TIPOERROR>|<DOCTOR>|<PACIENTE>|<FECHACITA>|<OBSERVACIONES>|<MENSAJEESPERADO>|
    When Juan adiciona un doctor en el app
    And Juan adiciona un paciente
    And Juan adiciona una cita
    Then Juan valida la informacion relacionada de la cita
    
    Examples:
    |ID|ORIENTACION|TIPOERROR|DOCTOR|PACIENTE|FECHACITA|OBSERVACIONES|MENSAJEESPERADO|
    ##@externaldata@./src/test/resources/datadrivens/DDReto.xlsx@Principal
      |1|Acierto|NA|jmurillo|ckariues|15/10/2018|Cita para la prostata.|Datos guardados correctamente.|
 

	  @TestCase2
  Scenario Outline: Agendar citas a traves de la app 
    Given Juan navega a la app de Heroku
    	|<ID>|<ORIENTACION>|<TIPOERROR>|<DOCTOR>|<PACIENTE>|<FECHACITA>|<OBSERVACIONES>|<MENSAJEESPERADO>|
    When Juan adiciona una cita con un doctor que no existe
    Then Juan valida la informacion el mensaje esperado
    
    Examples:
    |ID|ORIENTACION|TIPOERROR|DOCTOR|PACIENTE|FECHACITA|OBSERVACIONES|MENSAJEESPERADO|
    ##@externaldata@./src/test/resources/datadrivens/DDReto.xlsx@Principal
      |2|Error|TipoDoctor|asanchez|juribe|20/06/2018|Cita Error|Error:|
          
    

    
