## Enssemble des changements

### Controller
- RestController
- Dans une architecture MVC le controlleur (qui s'occupe de gérer les requette HTTP afin de repondre a ces dernieres) appelle le service (qui s'occupe de la logique metier) que lui meme appelle l'interface repository qui s'occupe de gérer l'accès données
  - pour cela on doit implementer les methodes manquante dans le service
- (Avant la suppression) la méthode findAll() utilise une boucle for pour itérer sur les résultats du productRepository.findAll(). on peut retourner directement le résultat de cette méthode directement.
- Dans la methode `find` Retourner une reponse http avec le status 404 au lieu de retourner une exception customisée
- Dans la methode `delete` nous devons faire un test si le produit exists et renvoyer une reponse l'existance

### Service
- implementer les methodes CRUD manquantes dans le service

### Repository
- utiliser JPARepository qui permet implemente plus d'operations que CrudRepository

### Model
- name a la place de nom pour la coherence du code