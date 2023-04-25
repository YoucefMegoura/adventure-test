## Enssemble des changements

### Controller
- RestController
- Dans une architecture MVC le controlleur (qui s'occupe de g�rer les requette HTTP afin de repondre a ces dernieres) appelle le service (qui s'occupe de la logique metier) que lui meme appelle l'interface repository qui s'occupe de g�rer l'acc�s donn�es
  - pour cela on doit implementer les methodes manquante dans le service
- (Avant la suppression) la m�thode findAll() utilise une boucle for pour it�rer sur les r�sultats du productRepository.findAll(). on peut retourner directement le r�sultat de cette m�thode directement.
- Dans la methode `find` Retourner une reponse http avec le status 404 au lieu de retourner une exception customis�e
- Dans la methode `delete` nous devons faire un test si le produit exists et renvoyer une reponse l'existance

### Service
- implementer les methodes CRUD manquantes dans le service

### Repository
- utiliser JPARepository qui permet implemente plus d'operations que CrudRepository

### Model
- name a la place de nom pour la coherence du code