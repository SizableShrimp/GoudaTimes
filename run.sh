# Set env vars
export $(grep -v '^#' .env | xargs)

# Backend
cd backend
env $(cat .env | xargs) ./gradlew bootRun
cd ..

# Unset env vars
unset $(grep -v '^#' .env | sed -E 's/(.*)=.*/\1/' | xargs)