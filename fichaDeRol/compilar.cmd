@CHCP 65001 > NUL
@ECHO OFF

REM Rev. 20221220000

SET nombre=ControlBuclePrincipal
SET nombrepaquete=jcolonia.daw2022.fichaDeRol
SET rutapaquete=jcolonia\daw2022\fichaDeRol
SET junit5lib=junit-platform-console-standalone-1.9.*.jar

SET oldpath=%PATH%
SET PATH=c:\java\jdk17\bin;%PATH%
SET CLASSPATH=bin
SET JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

ECHO %nombrepaquete%.%nombre%
ECHO ---
ECHO.

IF DEFINED junit5lib (
	REM Descargar de https://mvnrepository.com/artifact/org.junit.platform/junit-platform-console-standalone

	ECHO Verificando «lib\%junit5lib%» …
	IF NOT EXIST "lib\%junit5lib%" (
		ECHO ATENCIÓN: Falta «lib\%junit5lib%»
		GOTO FIN
	)
	ECHO.
)

REM javac -d bin -sourcepath src src\%rutapaquete%\%nombre%.java 
javac -d bin -sourcepath src -cp "lib/*" src\%rutapaquete%\*.java
ECHO.

DIR /s %CLASSPATH%\%rutapaquete%\*.class

:FIN
ECHO.
SET PATH=%oldpath%
PAUSE
