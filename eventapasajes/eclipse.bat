@ECHO OFF
@set MAVEN_HOME=C:\tools\maven 3.0.2
set PATH=%MAVEN_HOME%\bin;%PATH%
call mvn eclipse:eclipse -DdownloadSource=true -DdownloadJavadocs=true -Dtci.context=/ventapasaje
pause
