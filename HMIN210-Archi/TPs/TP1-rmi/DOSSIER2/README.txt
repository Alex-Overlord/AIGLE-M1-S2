1) Avoir 4 terminaux positionné sur :

- [...]/DOSSIER2/server
- [...]/DOSSIER2/partage
- [...]/DOSSIER2/client
- [...]/DOSSIER2/client

2) Compilation :

- Compiler le server : javac -classpath .:/[...]/DOSSIER2/partage/:. *.java
- Compiler le partage : javac -classpath .:/[...]/DOSSIER2/partage/:. *.java
- Compiler le client : javac -classpath .:/[...]/DOSSIER2/partage/:. *.java

3) Execution :

- Lancer le server : java -classpath .:/[...]/DOSSIER2/partage/:. Server
- Lancer le client : java -classpath .:/[...]/DOSSIER2/partage/:. Client
- Entrez le nombre de patients (d'animaux) que vous voulez ajouter au CabinetVeterinaire.
- Une alerte sera envoyé à tout les clients (à 100, 500 et 1000 patients).
