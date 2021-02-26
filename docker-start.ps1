./gradlew build
docker cp ./build/libs/four-fit-life.jar 4fitlife-backend_web_1:/app/four-fit-life.jar
docker cp ./.env 4fitlife-backend_web_1:/app/.env
docker-compose up web