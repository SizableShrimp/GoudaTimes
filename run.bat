@ECHO off

setlocal
FOR /F "tokens=*" %%i in ('type .env') do SET %%i

@REM Backend
cd backend
./gradlew.bat bootRun
cd ..

endlocal