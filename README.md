**Vous devez également inclure une section détaillée sur vos réflexions concernant la conception et la réflexion sur le projet. Cette section est à votre responsabilité pour assurer la clarté de votre approche et la qualité de votre réflexion.**

Le projet est structuré en trois classes principales :

ControlleurJeu: Cette classe gère l'interface utilisateur Swing et orchestre le déroulement du jeu.
MotsReader: Cette classe lit les mots à partir d'un fichier texte et fournit une méthode pour choisir un mot aléatoire.
Partie: Cette classe représente une partie du jeu de pendu. Elle gère le mot à deviner, le mot actuel (avec les lettres devinées) et fournit des méthodes pour deviner une lettre et vérifier si le mot a été deviné.

## Patrons
Modèle-Vue-Contrôleur (MVC) :
        Le code est structuré selon le modèle MVC. La classe ControlleurJeu agit comme le contrôleur qui gère les interactions utilisateur et met à jour la vue en conséquence. La classe Partie représente le modèle qui contient les données et la logique métier, tandis que l'interface utilisateur est représentée par les composants Swing.

Singleton :
        Le singleton n'est pas explicitement utilisé dans ce code, mais il y a une seule instance de Partie créée dans ControlleurJeu, ce qui garantit qu'il n'y a qu'une seule instance de la partie en cours.

Observateur :
        Dans le modèle MVC, Swing utilise le modèle observateur pour détecter et réagir aux changements d'état des composants, tels que les champs de texte et les étiquettes. Par exemple, lorsque l'utilisateur entre une lettre, l'action de l'utilisateur est détectée par l'observateur (ActionListener) attaché au champ de texte.

Fabrique (Factory) :
        Bien qu'il ne soit pas directement utilisé dans le code fourni, l'idée de la création d'une instance de ControlleurJeu pourrait être considérée comme une forme simple de fabrique. L'utilisation de SwingUtilities.invokeLater() peut également être considérée comme une utilisation de fabrique pour créer une interface utilisateur Swing dans un thread d'événement dédié.

Stratégie :
        Bien que ce ne soit pas explicitement implémenté comme un patron de conception, le code implémente une stratégie pour la gestion des erreurs et des réponses correctes de l'utilisateur lors de la devinette des lettres. Selon la réponse de l'utilisateur, différentes stratégies sont utilisées pour mettre à jour l'interface utilisateur et la partie en cours.

## type utilisés
List (ArrayList) :
    Une implémentation de List, en l'occurrence ArrayList, est utilisée pour stocker les mots lus à partir du fichier de mots. Cela permet un accès facile et efficace aux mots disponibles pour le jeu.
    
## Fonctionnalités attendues

1. Lecture aléatoire d'un mot à deviner à partir d'un fichier texte donné à la racine du projet. *fait*
2. Affichage graphique de l'interface du jeu à l'aide de Swing. *fait*
3. Affichage graphique du pendu qui évolue en fonction des erreurs du joueur. *moitié fait*
4. Affichage graphique des lettres déjà proposées par le joueur. *manquant (mais géré)*
5. Affichage (ou non) de la définition (niveau de difficulté). *manquant*
6. Utilisation (ou non) d'un timer (niveau de difficulté). *manquant*
7. Gestion des entrées utilisateur pour proposer des lettres. *fait*
8. Vérification de la validité des entrées utilisateur (lettre de l'alphabet uniquement). *manquant*
9. Gestion du décompte des tentatives restantes. *moitié fait*
10. Gestion de la victoire ou de la défaite du joueur. *fait*
11. Possibilité de rejouer une partie après la fin d'une partie. *manquant*

