translator-adabas
=================

Adabas Translator for Teiid using CONNEX JDBC driver.

Installation Directions

- Clone or copy the zip file of this repository

```
cd translator-adabas
mvn clean install
unzip target/translator-adabas-1.0-SNAPSHOT-jboss-as7-dist.zip /path/to/${jboss-as}
```
 - Now edit the standalone-teiid.xml file, in the "teiid" subsystem, and add

<translator name="adabas" module="org.jboss.teiid.translator.adabas"/>

- Besure deploy the CONNEXT JDBC driver, and create a data source in standalone-teiid.xml. It is exactly same as any other JDBC data source. 
For example assume the JNDI name as "java://adabasDS"

Now use the "adabas" as translator name and "java://adabasDS" as connection-jndi-name.

ex:
```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<vdb name="AdabasVDB" version="1">
  <model name="adabas">
    <source name="conector" translator-name="adabas" connection-jndi-name="java:/adabasDS"/>
  </model>
</vdb>
```
