A spring boot app for learning purposes which exposes an API to fetch details of Banks in India.

# Usage

`./gradlew dbUp` - start a local Postgres database using docker.

`./gradlew dbDown` - stop the local Postgres database.

`./gradlew quickStart` - start the database and application. Apllication will be exposed at port `8181`.

# APIs

**GET** http://localhost:8181/heroku/banks?bankName=ABHYUDAYA COOPERATIVE BANK LIMITED&city=mumbai

**GET** http://localhost:8181/heroku/banks/{ifscCode}
 
