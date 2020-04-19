Membres:

Coté Android:
- Mohsine Bahhou 
- Yasmine Mekouar
- Fatima Zohra Sersouri
- Ahmed Bennani

Coté Service web:
- Mamadou Kanghe Balde
- Mamadou Hassimiou Diallo

Sujet:

L’université Gustave Eiffel désire offrir un service de partage interne de toutes sortes de produits (livres, vêtements, etc.), utilisable par ses enseignants et étudiants, et dont la gestion est effectuée avec une application Android, connecté avec un service web REST. Les produits peuvent être ajoutés à la base ou être empruntés par tous. Il est possible d’ajouter de notes et des commentaires sur le produit et son état lors de sa restitution. Lorsqu’une personne demande à emprunter un produit, et que celui-ci est déjà prêté à autrui, elle est inscrite sur liste d’attente ; dès que le produit demandé devient disponible, la personne est notifiée et l’emprunte. En présence de plusieurs personnes en attente, les enseignants sont servis en priorité. S’il y a deux étudiants ou deux enseignants en concurrence sur un produit, celui qui a le moins emprunté de produits est servi en priorité. Dans un deuxième temps, l’université Gustave Eiffel désire valoriser sa base de produits, enrichie par les notes et commentaires de ses enseignants et étudiants, et la rendre accessible à l’extérieur. Elle propose à la vente les produits qui ont été introduits dans sa base depuis au moins deux mois, et qui ont été empruntés au moins deux fois. Le service Web permet de consulter les prix des produits, de vérifier leur disponibilité, de les ajouter à un panier et de les acheter. Le panier d’un client peut à tout moment être modifié ou vidé. Pour effectuer un achat, l’application vérifie la disponibilité des fonds nécessaires à l'achat et effectue le paiement. Les prix des produits sont en Euros, mais l’université permet des ventes dans toutes les monnaies du monde, et doit fournir les prix dans la devise demandée par l'acheteur. Les taux de change utilisés doivent être trouvés en temps-réel. 

Détails techniques:

L’application Android est réalisée avec un SDK 28 voici les technologies que nous avons utilisé:
- HttpURLConnection : pour lancer des requêtes avec le service web
- ViewPager : utilisé dans les slides d’accueil 
- DialogFragment: pour afficher DatePickerDialog et TimePickerDialog
- RecyclerView : Pour afficher une liste d’éléments
- Picasso : pour charger les images depuis un url
- FingerprintManager : pour s’authentifier avec empreinte digitale
- SQLite Database : pour stocker les id des utilisateurs authentifiés par empreinte digitale
- BroadcastReceiver : pour recevoir les notifications

Le Service Web REST est codé en Java 11 avec : 
- Les frameworks Spring, Maven, Swagger (pour la documentation), la dépendance javax.mail pour l’envoie des mails. 
- L’api : http://data.fixer.io/api/ qui nous retourne un fichier JSON des taux de conversion de toute les monnaies du monde en temps réel.
- Une base de données MySql.
- Le service web ainsi que la base de données sont hébergées sur le serveur de heroku sur ce liens : https://uge-webservice.herokuapp.com/swagger-ui.html 

Liens Github:

- Android : https://github.com/mohsinebahhou/ProjetAndroid_androidApp
- Service web : https://github.com/Hasmiou/ProjetAndroidWebService

Liens de téléchargements:
- Projet Android : http://makcenter.ma/uge/projetAndroid/CodeSource/ProjetAndroid.zip
- Apk : http://makcenter.ma/uge/projetAndroid/CodeSource/app-debug.apk
- Service web : http://makcenter.ma/uge/projetAndroid/CodeSource/ProjetAndroidWebService-master.zip

Liens de vidéos de démonstrations : 

- Mohsine Bahhou : http://makcenter.ma/uge/projetAndroid/video/MohsineBahhou.mp4
- Mamadou Kanghe Balde : http://makcenter.ma/uge/projetAndroid/video/MamadouKangheBalde.mp4
- Fatima Zohra Sersouri : http://makcenter.ma/uge/projetAndroid/video/FatimaZohraSersouri.mp4
- Yasmine Mekouar : http://makcenter.ma/uge/projetAndroid/video/YasmineMekouar.mp4
- Mamadou Hassimiou Diallo : http://makcenter.ma/uge/projetAndroid/video/MamadouHassimiouDiallo.mp4
- Ahmed Bennani: http://makcenter.ma/uge/projetAndroid/video/AhmedBennani.mp4
