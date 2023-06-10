# TwittrFX

Project submission by Livio Brunner

## Getting started

### Client (TwittrFX)

```bash
# Build the project
mvn install
mvn package

# Run the project and use local server
java -jar target/twittrfx-0.0.0-DEVELOPMENT-jar-with-dependencies.jar

# Run the project and use hosted remote server
API_BASE_URL=https://5af4-2a04-ee41-6-b101-919a-d136-7dde-342f.ngrok-free.app java -jar target/twittrfx-0.0.0-DEVELOPMENT-jar-with-dependencies.jar
```


### Server (PHP Symfony)

1. Local

```bash
cd src/server
composer install
symfony server:start
```

2. Docker

```bash
docker run -p "8000:8000" ghcr.io/brunnerlivio/twittrfx-server:latest
```


## Umgesetzte Zusatz-Features

Folgende Zusatzfeatures mit der angegebenen Bewertung wurden umgesetzt:

* Dark/Light Mode
* Client/Server kommunikation (Birds via PHP REST API)
* _CI/CD mit Github Actions. [Siehe mein öffentliches Repo für ein Live-Example](https://github.com/BrunnerLivio/fhnw-twittrfx)_

_Ich verstehe falls es keine Zusatzpunkte gibt für CI/CD da das nicht mehr viel mit Java zu tun hat 🤷‍♂️_

## CI/CD

CI/CD hab ich aufgesetzt da ich demnächst bei der Firma bei der ich arbeite eine Demo von
[semantic-release](https://github.com/semantic-release/semantic-release) mache und ich nehme TwittrFX als "Playground" dafür.

Die Pipeline ist ziemlich standart für Maven. Allerdings habe ich
noch hinzugefügt dass Semantic Release, die zu-releasende-Version herausfinden kann und diese temporär ins `pom.xml` schreibt.
Dann generiert es eine *.jar mit der korrekten Version.

Fürs "CD" nehme ich dann diese *.jar Datei und erstelle automatisch
ein Github release und attache diese Datei. Semantic Release generiert
automatisch die versions nummer sowie mein changelog.

[Die Releases findet man hier](https://github.com/BrunnerLivio/fhnw-twittrfx/releases)
