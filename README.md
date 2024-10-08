[![Java CI with Maven](https://github.com/programmer-kazarin/appointment-service/actions/workflows/maven.yml/badge.svg)](https://github.com/programmer-kazarin/appointment-service/actions/workflows/maven.yml)
# appointment-service - Backend для сервиса записи на прием
# Перед запуском локально
1. Создать БД appointment_db схему appointment и прописать креды в application.yml
```shell
# Развернуть постгрес в докере
docker run --name appointment-postgres -p 5432:5432 -e POSTGRES_DB=appointment_db -e POSTGRES_USER=appointment_admin -e POSTGRES_PASSWORD=12345 -d postgres
```
```sql
create schema appointment;
```
# Run checkstyle
```bash
 mvn checkstyle:check
```