call runcrud.bat
if "%ERRORLEVEL%" == "0" goto runbrowser
echo.
echo RUNCRUD has errors - breaking work


:runbrowser
start Chrome http://localhost:8080/crud/v1/task/getTasks

