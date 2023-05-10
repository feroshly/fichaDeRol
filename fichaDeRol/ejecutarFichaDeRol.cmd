@CHCP 65001 > NUL
@ECHO OFF

REM Rev. 20221220000

SET srcdir=%~dp0
SET nombrejar=ejecutarFichaDeRol
SET args=

SET oldpath=%PATH%
SET PATH=c:\java\jdk17\bin;%PATH%
SET CLASSPATH=bin
SET JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

ECHO %nombrejar%
ECHO ---
ECHO.

java -jar "%srcdir%%nombrejar%.jar" %args%

:Fin
ECHO.
SET PATH=%oldpath%
PAUSE
