<html lang="fr-ca">

<h1>Cadriciel pour un jeu de dés</h1>

<H2>But du laboratoire</H2>
<P>Ce laboratoire vous permettra  :</P>
<UL>
  <li>de comprendre l'utilité des patrons GoF "Méthode template", "Stratégie" et "Itérateur" et de les appliquer correctement;</li>
  <li>d'apprendre à utiliser l'interface Comparable de l'API Java;</li>
  <li>de comprendre l'utilité des tests unitaires et de savoir les utiliser avec JUnit.</li>
</UL>

<H2>Description du laboratoire</H2>

<p>Dans la conception logicielle, parfois on cherche à favoriser l'extensibilité et la réutilisation. C'est le cas lorsqu'on développe un cadre d'application aussi appelé cadriciel (framework).
Un cadriciel est une application générique qui implémente un noyau commun à des applications d'un domaine particulier.
Un cadriciel est donc une librairie de classes réutilisables facilitant l'implémentation d'applications dans un domaine spécifique.
L'API de Java offre plusieurs librairies de ce genre. Un simple exemple est l'API des applets.</p>

<p>
Ainsi, ce laboratoire vise donc la conception et l'implémentation d'un cadriciel pour un jeu de dés.
Ce logiciel serait utilisé éventuellement par plusieurs applications de jeu de dés dont il existe plusieurs variantes.
Plusieurs éléments peuvent changer d'une variante à l'autre, par exemple le nombre de faces qu'a un dé, le nombre de dés par joueur, le nombre de joueurs, le nombre de tours dans un jeu
et aussi les règles de calcul des scores des joueurs. Autrement dit, on veut donc concevoir un ensemble de classes logicielles fournissant le squelette d'un jeu de dés, et cela indépendamment
des variantes. Ces classes peuvent être étendues facilement pour personnaliser le logiciel pour une variante particulière du jeu de dés ou pour ajouter de nouvelles fonctionnalités au jeu.</p>

<p>Au moins trois patrons vous seront utiles pour réaliser cette tâche :</p>
<UL>
    <li>le patron GoF "Itérateur" pour manipuler les dés d'un joueur sans se soucier du nombre de dés utilisés dans le jeu et manipuler les joueurs sans se soucier de leur nombre;</li>
    <li>le patron GoF "Méthode template" pour définir le squelette d'une méthode qui initialise ou crée le jeu tout en fournissant des points possibles d'extension ou de variation; et</li>
    <li>le patron GoF "Stratégie" pour supporter la variation des règles de calcul des scores.</li>
</UL>
<p>Vous utiliserez aussi l'outil JUnit pour faire des tests unitaires des classes que vous allez concevoir dans ce laboratoire.</p>


<H2>Travail &agrave; effectuer</H2>

<p>Vous devez concevoir et implémenter une librairie de classes pour le jeu de dés. Votre travail consiste à
<ul>
    <li>concevoir et implémenter des classes pour initialiser le jeu de dés, de jouer une partie, de calculer le score d'une lancée de dés selon des règles, de calculer le score total d'un joueur, et de comparer les scores
    des joueurs pour trouver le vainqueur.</li>
    <li>étendre les classes de votre cadriciel pour implémenter une variante simplifiée de jeu de dés. Cette variante est décrite dans <a href="#buncoPlus">la section suivante</a>.
    Cette variante s'appelle Bunco+ et elle est une version simple basée sur les règles décrites dans <a href="http://www.worldbunco.com/rules.html" target="_blank">worldbunco</a>.</li>
    <li>concevoir des classes jumelles de test unitaire pour les classes les plus importantes de votre conception et cela pour démontrer que ces classes fonctionnent.
    Pour les stratégies de test unitaire, <a href="http://library.books24x7.com/book/id_7068/viewer.asp?bookid=7068&chunkid=0998565033" target="_blank">ce chapitre d'un livre sur JUnit</a> peut vous être utile. </li>
</ul>


<H2><a name="buncoPlus"></a>Description de Bunco+</H2>

<H3>Description sommaire</H3>

<p>Dans ce jeu, on utilise 3 dés. Chaque dé a 6 faces avec un chiffre (entre 1 et 6) sur chaque face : </p>
<p><img src="description1.PNG" border="0"><img src="description1.PNG" border="0"><img src="description1.PNG" border="0"></p>

<p>Une partie de jeu est jouée en 6 tours. À chaque tour, les joueurs roulent les trois dés. Un joueur essaie de faire rouler le même chiffre que
le numéro du tour, par exemple (<img src="des_identiques.PNG" border="0"> dans le troisième tour).
Lorsque les trois dés roulés affichent le même numéro et que ce numéro est le même que le numéro du tour, on dit que le joueur a un Bnco (21 points).
Sinon, un point est attribué pour chaque chiffre qui correspond au numéro du tour.</p>
<p>Durant un tour, un joueur passe la main au joueur suivant si le joueur obtient un résultat de 0 ou s'il obtient un Bunco.</p>


<H3>Règles du jeu et de calcul du score</H3>

<p>À chaque tour, les joueurs marquent des points lorsque le chiffre figurant sur les dés est le même numéro que le tour. Un point est attribué pour
chaque numéro correspondant.</p>

<p>Par exemple, dans le tour 1, l'objectif est de faire rouler <img src="bunco_tour1.PNG" border="0">;
si le joueur obtient <img src="points_tour1.PNG" border="0">, le joueur reçoit deux points et il roule à nouveau les dés.</p>

<p>Dans le tour 2, l'objectif est de faire rouler (<img src="bunco_tour2.PNG" border="0"> trois groupes de deux);
si le joueur obtient <img src="points_tour2.PNG" border="0">, le score du joueur augmente d'un point et il roule à nouveau les dés, et ainsi de suite.</p>

<p>Si un joueur obtient trois fois le même chiffre et ce chiffre est identique à celui du tour en cours (par exemple: <img src="bunco_tour4.PNG" border="0">
au quatrième tour), c'est un Bunco! Un Bunco vaut 21 points. Si par contre un joueur obtient trois chiffres identiques mais différents du numéro
du tour (par exemple: <img src="des_identiques_2.PNG" border="0"> au quatrième tour), le joueur reçoit 5 points.</p>

<p>Lorsque le joueur obtient un Bunco (21 points), il passe la main au suivant.</p>
<ul>
<li>Exemple 1 : Le joueur vient d'avoir la main pour jouer. Il roule les dés et il obtient un Bunco.
Le joueur gagne 21 points et il passe la main au prochain joueur.</li>
<li>Exemple 2 : Le joueur vient d'avoir la main pour jouer. Il roule les dés et il obtient 2 points. Il roule encore les dés et il obtient 5 points.
Il roule encore les dés et il obtient un Bunco (21 points). Le joueur accumule un score de 28 points et il passe la main au prochain joueur.</li>
</ul>


<H3>Exemple : premier tour joué par cinq joueurs</H3>

<p>Le joueur #1 roule les dés:

<TABLE>
  <TR>
    <td>Il obtient <img src="joueur1_lancer1.PNG" border="0"></td>
    <td>Il gagne 2 points et il continue de rouler les dés.</td>
  </tr>
  <TR>
    <td>Il obtient <img src="joueur1_lancer2.PNG" border="0"></td>
    <td>Il gagne un autre point et il continue de rouler les dés.</td>
  </tr>
    <TR>
    <td>Il obtient <img src="joueur1_lancer3.PNG" border="0"></td>
    <td>Aucun point n'est attribué au joueur et les dés sont passés au joueur suivant.</td>
  </tr>
</TABLE>
On marque un total de 3 points pour le joueur #1 dans ce tour.</p>

<p>Le joueur #2 roule les dés:
<TABLE>
  <TR>
    <td>Il obtient <img src="joueur2_lancer1.PNG" border="0"></td>
    <td>Il gagne un point et il continue de rouler les dés.</td>
  </tr>
  <TR>
    <td>Il obtient <img src="joueur2_lancer2.PNG" border="0"></td>
    <td>Il gagne un autre point et il continue de rouler les dés.</td>
  </tr>
    <TR>
    <td>Il obtient <img src="joueur2_lancer3.PNG" border="0"></td>
    <td>Aucun point n'est attribué au joueur et les dés sont passés au joueur suivant.</td>
  </tr>
</TABLE>
On marque un total de 2 points pour le joueur #2 dans ce tour.</p>

<p>Le joueur #3 roule les dés:
<TABLE>
  <TR>
    <td>Il obtient <img src="joueur3_lancer1.PNG" border="0"></td>
    <td>Trois fois le même chiffre est obtenu (mais ce n'est pas un BUNCO). Le joueur obtient 5 points et il continue de rouler les dés.</td>
  </tr>
  <TR>
    <td>Il obtient <img src="joueur3_lancer2.PNG" border="0"></td>
    <td>Aucun point n'est attribué au joueur et les dés sont passés au joueur suivant.</td>
  </tr>
</TABLE>
On marque un total de 5 points pour le joueur #3 dans ce tour.</p>

<p>Le joueur #4 roule les dés:
<TABLE>
  <TR>
    <td>Il obtient <img src="joueur4_lancer1.PNG" border="0"></td>
    <td>C'est un Bunco! Le joueur obtient 21 points et les dés sont passés au joueur suivant.</td>
  </tr>
</TABLE>
On marque un total de 21 points pour le joueur #4 dans ce tour.</p>

<p>Le joueur #5 lance les dés:
<TABLE>
  <TR>
    <td>Il obtient <img src="joueur5_lancer1.PNG" border="0"></td>
    <td>Aucun point n'est attribué au joueur et les dés sont passés au joueur suivant.</td>
  </tr>
</TABLE>
On marque un total de 0 point pour le joueur #5 dans ce tour.</p>

<p>Ainsi, le joueur #4 gagne le premier tour.</p>

<H2>Contraintes de conception</H2>

<p>La conception doit être orientée objet et facile à étendre. Vos classes doivent être cohésives. Les classes De (pour le dé) et Joueur
doivent modéliser correctement les dés et les joueurs. Les classes De et Joueur doivent implémenter l'interface comparable de l'API Java. </p>
<p>Il doit y avoir une classe Jeu qui sera initialisée lorsqu'on commence une partie de jeu. Cette classe doit être indépendante de
toute variante de jeu de dés. Le diagramme de classes suivant peut vous servir comme point de départ :</p>

<p><img src="conception.PNG" border="0"></p>
De plus, votre conception doit respecter les contraintes suivantes :
<ul>
<!--<li>La classe qui s'occupe d'initialiser le jeu et de jouer une partie doit être différente de la classe Jeu.</li>-->
<li>Il doit obligatoirement y avoir une classe créatrice (Fabrique) qui s'occupe de créer des instances des dés, des joueurs et d'un jeu.</li>
<li>Votre conception doit être organisée en trois packages : un premier package contenant toutes les classes génériques du framework, un deuxième package contenant
les classes spécifiques à votre implémentation de Bunco+ et un troisième contenant les classes pour les tests unitaires.</li>
</ul>

<p><strong>Utilisation obligatoire du patron GoF "Méthode template"</strong> : La création d'une partie de jeu nécessite la création de
plusieurs éléments incluant les joueurs et les dés. La méthode de création doit être décomposée et implémentée selon le patron "méthode template"
de façon à permettre aux utilisateurs éventuels de votre framework de redéfinir certaines parties de cette méthode, par exemple, pour créer
leurs propres dés ou joueurs.</p>
<p><strong>Utilisation obligatoire du patron GoF "Stratégie"</strong> : Le calcul du score des joueurs peut varier d'une variante de jeu de dés à
une autre. Vous devez obligatoirement appliquer le patron Stratégie pour permettre aux utilisateurs de votre framework de définir leur propre
stratégie en cas de besoin.</p>
<p><strong>Utilisation obligatoire d'un "itérateur" de l'API Java (Collection)</strong> : Une collection de joueurs ainsi qu'une collection de dés
doivent être utilisées pour stocker les joueurs et les dés, respectivement. Aussi, vous devez utiliser des itérateurs pour parcourir
ces collections. Vous devez implémenter vos propres collections à partir de tableaux (Array). Les sous-classes de Collection de l'API Java ne sont pas autorisées. </p>
<p><strong>Utilisation obligatoire de l'outil JUnit</strong> : Vous devez écrire des classes jumelles de test unitaire pour au moins les classes
suivantes : Jeu, De, Joueur ainsi que la stratégie concrète implémentant les règles de Bunco+. À titre d'exemple, voilà une classe test pour
la classe De : <a href="DeTest.java">DeTest.java</a>.</p>
<p>De plus, assurez-vous d'implémenter les méthodes calculerScoreTour() et calculerLeVainqueur() de la classe Jeu et les méthodes
calculerScoreTour() et calculerLeVainqueur() de votre stratégie concrète, puisqu'elles seront contrôlées par le chargé de laboratoire avec des tests unitaires. <em>Remarque: </em>La méthode calculerScoreTour() cumule le score du joueur actuel après une lancée de dés (selon les règles du jeu) et décide s'il faut passer la main au prochain joueur ou non. La méthode calculerLeVainqueur() retourne les joueurs triés selon un ordre décroissant de scores. </p>
<p>En particulier, le chargé de laboratoire vérifiera que vos tests unitaires valident les cas suivants :
<ul>
<li>Dans le cas où un joueur obtient trois chiffres identiques et égaux au numéro du tour, le score calculé est 21 points et si le joueur passe la main au joueur suivant.</li>
<li>Dans le cas d'obtention de 3 chiffres identiques mais différents du numéro de tour si le score est de 5 points et le joueur garde la main.</li>
<li>Dans le cas d'obtention d'un seul chiffre correspondant au numéro de tour si le score est correct et si le joueur garde la main.</li>
<li>Dans le cas d'obtention de 0 point si le joueur passe la main au joueur suivant.</li>
<li>Le classement final des joueurs avec différents scores.</li>
</ul>
</p>

<H2>Rapport de laboratoire</H2>
<p>Le contenu est indiqué dans le gabarit sur le site internet du groupe </p>
<!--
<P>Voir <A href="../correction.shtml">Style de correction et Rapports de laboratoire</A> pour plus de d&eacute;tails. </P>
<P>Votre rapport doit comprendre:</P>
<ul>
  <li>des diagrammes de classe en UML qui repr&eacute;sentent votre conception, y compris les classes de test unitaires, </li>
  <li>un diagramme de séquence en UML illustrant la dynamique du patron GoF "Stratégie" dans le contexte de votre solution.</li>
</ul>
<p>Vous devez absolument expliquer dans le rapport comment l'application des patrons GoF facilite l'extensibilité de votre logiciel.
Par exemple, que faudrait-il changer pour supporter des dés avec des images au lieu des nombres sur les faces?</p> -->


<H2>Pond&eacute;ration</H2>
<P>Ce laboratoire compte pour 10%. Voilà comment les points sont alloués : </P>
<P>5 points = Fonctionnalit&eacute; et pr&eacute;sentation<BR>
  5 points = Rapport de laboratoire</P>


<H2>Date de remise et pr&eacute;sentation</H2>

<p>Voir le site de chaque groupe pour la date et la procédure de remise exigée.</p>


<h2>Trucs et astuces</h2>
<h3>Pour les tests unitaires</h3>
<p>Considérez les conseils suivants pour vos cas de tests unitaires :</p>
<ul>
<li>tester toutes les méthodes, y compris le constructeur, les getX()/setX(),etc.</li>
<li>pour chaque méthode, faire varier les paramètres de l'appel afin de</li>
<ul>
<li>tester les fonctionnalités de base (appel normal et typique de la méthode)</li>
<li>tester les cas limites (valeurs en dessous, au-dessus des limites)</li>
<li>tester avec des références " null "</li>
<li>tester des cas qui devraient générer les exceptions " checked " et les intercepter</li>
<li>ne pas tester les exceptions " unchecked " des méthodes</li>
</ul>
<li>ne pas tester la performance</li>
</ul>

<h3>Pour rouler les dés et attribuer un score</h3>
<p>Utiliser un générateur aléatoire de chiffres. Dans le cas de Bunco+, chaque fois qu'un joueur roule les dés, il obtient trois chiffres correspondant aux faces supérieures des 3 dés
utilisés dans le jeu. Ce sont ces chiffres-là qui sont utilisés pour calculer son score.</p>
<br>

</BODY>
</HTML>
