# Backend
cd backend
env $(cat .env | xargs) ./gradlew bootRun
cd ..