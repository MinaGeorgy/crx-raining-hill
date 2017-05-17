###############  RUNTIME ENVIRONMENT REQUIREMENTS & USED TECHNOLOGIES ############################################
- Red Hat JBoss Enterprise Application Platform - Version 7.0.0.GA
- JDK 1.8
- EJB 3.2
- JSF 2.2
- JUNIT 4.11
- Java EE 7

###############  Class Path ####################################

The Java classes are in `src/main/java/` 

The Resource Bundle is Found under 'src/main/resources/' 

The Test Classes are Found under 'src/test/java/' 

############### PACKAGES ####################################

-ejbbeans : package for business component EJB Session BEANS (Service layer Package).

-exception : All Exception classes defined in this spackage.

-faces/beans :Jsf Managed Beans are defined under this package (Controller Package).

-model : All Data Objects defined under this package.

-service : all the business logic are found under this package. 



###############  PREREQUISITES TO INSTALL APP  ######################


- RUN maven command 
   
   * mvn clean install 

- The Generated App Will be found in {APP_PATH}/Target/crx-raining-hill-1.0.war 

- Deploy the war file on one of application server that support EJB Container like Jboss ,wildfly

- The Context Of app http://localhost:8080/CRX/

- if the application server is JBOSS WildFly or JBOSS EAP use deploy maven command to deploy or undeploy
- the app after running {JBOSS_EAP}/bin/standalone.bat

		**** mvn clean install wildfly:deploy
		**** mvn wildfly:undeploy
   

