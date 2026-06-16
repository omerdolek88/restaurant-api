# Restaurant API (Spring Boot)

Eine REST-API in Java mit Spring Boot, die Restaurant-Bestelldaten aus einer MySQL-Datenbank über HTTP-Endpunkte als JSON bereitstellt. Aufbauend auf dem Projekt "Restaurant Orders".

## Endpunkte

- `GET /menu` — gibt die Speisekarte zurück
- `GET /reports/daily-revenue` — Tagesumsatz
- `GET /reports/top-items` — meistverkaufte Gerichte
- `GET /reports/orders-per-customer` — Bestellungen pro Kunde

## Technologien

- Java, Spring Boot (Spring Web, Spring JDBC)
- MySQL über JdbcTemplate
- Maven

## Voraussetzungen

- Java 17+
- MySQL mit der Datenbank `restaurant_db` (Schema und Beispieldaten siehe Projekt "Restaurant Orders": `schema.sql` und `sample_data.sql`)

## Einrichtung & Start

1. In `src/main/resources/application.properties` die Zugangsdaten der eigenen MySQL-Installation eintragen (Benutzername und Passwort).
2. Anwendung starten:
   ```
   ./mvnw spring-boot:run
   ```
3. Endpunkte im Browser aufrufen, z. B. `http://localhost:8080/menu`.

## Hinweis

Das Passwort in `application.properties` ist ein Platzhalter und muss durch die eigenen Zugangsdaten ersetzt werden.

## Motivation & Lernziel

Dieses Projekt entstand, um den Übergang von einer Konsolenanwendung zu einer REST-API praktisch nachzuvollziehen — mit Spring Boot, Dependency Injection und der Bereitstellung von Datenbankabfragen über HTTP-Endpunkte.
