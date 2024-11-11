
Guillen Johan

il faut pour le projet verifier qu'iul y a bien les depence de la bdd utiliser et hibernate
et faire sont fichier de persistence avec comme nom de l'unite de persistence "shop" l'option de transaction type
set a cette valeur <persistence-unit name="shop" transaction-type="RESOURCE_LOCAL">

j'ai activer les propriete :
    -hibernate.format.show_sql a true
    -jakarta.persistence.schema-generation.database.action a "drop-and-create"
    -hibernate.hbm2ddl.auto a "update"
