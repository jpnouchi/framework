@ECHO OFF
@set MAVEN_HOME=C:\tools\maven 3.0.2
set PATH=%MAVEN_HOME%\bin;%PATH%
call mvn -Dmaven.test.skip clean install -DtciDev -Dtci.earname=tci-ventapasaje -Dtci.context=/ventapasaje -DskipTests
pause
