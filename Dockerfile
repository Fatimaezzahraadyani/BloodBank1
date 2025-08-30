# l'image de base OpenJDK 21
FROM openjdk:21-jdk-slim

# Ajoute un volume pour la sortie de la compilation (les fichiers temporaires)
VOLUME /tmp

# Copie le fichier JAR compilé (généré par 'mvn package') dans le conteneur
# le fichier JAR
ARG JAR_FILE=target/backend-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# le port par défaut de l'application
EXPOSE 8082

# Lance l'application quand le conteneur démarre
ENTRYPOINT ["java","-jar","/app.jar"]