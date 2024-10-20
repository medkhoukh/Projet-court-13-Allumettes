#Jeu des 13 Allumettes
Le jeu des 13 allumettes se joue à deux joueurs qui, à tour de rôle, prennent 1, 2 ou 3 allumettes
d’un tas qui en contient initialement 13. Le joueur qui prend la dernière allumette perd.
L’application à développer doit permettre à deux joueurs de s’affronter. C’est l’ordinateur qui
est l’arbitre de la partie. Il affiche le nombre d’allumettes restant en jeu, donne la main à tour de
rôle à chaque joueur et vérifie que les joueurs respectent les règles du jeu. Ainsi, si un joueur
veut prendre trop ou trop peu d’allumettes, le coup est refusé et le joueur doit rejouer. Un joueur
doit retirer entre 1 et 3 allumettes. En fin de partie, l’arbitre affiche le résultat.
Chaque joueur choisit le nombre d’allumettes à prendre en fonction d’une stratégie. Une
stratégie humain consiste à demander à l’utilisateur ce nombre. Ceci permet d’avoir un joueur
humain. Les autres stratégies consistent à faire jouer l’ordinateur et définissent son niveau de jeu.
Une liste non exhaustive des niveaux de jeu, et donc des stratégies correspondantes, inclut :

— niveau rapide : l’ordinateur prend le maximum d’allumettes possible (de manière à ce que
la partie se termine le plus rapidement possible),

— niveau naïf : l’ordinateur choisit aléatoirement un nombre entre 1 et 3,

— niveau expert : l’ordinateur joue du mieux qu’il peut (s’il peut gagner, il gagnera).
