@CHCP 65001 > NUL
@ECHO OFF

REM Rev. 20221220000

SET nombre=ControlBuclePrincipal

SET oldpath=%PATH%
SET PATH=c:\java\doxygen;c:\java\graphviz;%PATH%
SET CLASSPATH=bin
SET JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

ECHO %nombre%
ECHO ---
ECHO.

ECHO ¡ATENCIÓN! Los directorios y paquetes del proyecto
ECHO NO pueden contener caracteres especiales.
ECHO.
PAUSE

doxygen Doxyfile 2> doxumentar.log

ECHO.
DIR dox

ECHO.
ECHO No documentados: Revisar el archivo «doxumentar.log»…
findstr /r /c:"not.*documented" < doxumentar.log | find /c "warning"

:FIN
ECHO.
SET PATH=%oldpath%
PAUSE
