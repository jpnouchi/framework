@ECHO OFF
@set MAVEN_HOME=C:\tools\maven 3.0.2
set PATH=%MAVEN_HOME%\bin;%PATH%
call mvn package process-resources -DtciDev -Dtci.earname=tci-ventapasaje -Dtci.context=/ventapasajeDEV -DskipTests
pause
