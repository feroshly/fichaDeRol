@CHCP 65001 > NUL
@ECHO OFF

REM Rev. 20221220000

SET nombre=ControlBuclePrincipal
SET nombrepaquete=jcolonia.daw2022.fichaDeRol
SET rutapaquete=jcolonia\daw2022\fichaDeRol
SET nombrejar=ejecutarFichaDeRol
SET junit5lib=junit-platform-console-standalone-1.9.*.jar

SET oldpath=%PATH%
SET PATH=c:\java\jdk17\bin;%PATH%
SET CLASSPATH=bin
SET JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

ECHO %nombrepaquete%.%nombre%
ECHO ---
ECHO.

IF EXIST dist RMDIR /S /Q dist
MKDIR dist
jar --create --verbose ^
	--file=dist\%nombrejar%.jar ^
	--main-class=%nombrepaquete%.%nombre% ^
	-C bin .
ECHO.

ECHO Copiando %nombrejar%.cmd a «dist»...
COPY %nombrejar%.cmd dist
rem ECHO Copiando %nombrejar%.sh a «dist»...
rem COPY %nombrejar%.sh dist
ECHO.
PAUSE
