# bcrw.host
## Bexar County Road Watch
### A Codeup and CivTech production

### Developers ( Diemos Cohort ):
* Amber Jones, In/amberlovescats14, GitHub: /amberlovescats14
* Christopher Aguirre, In/christopher-aguirre210, GitHub: /christopheraguirre210 
* Melinda Greene, In/melindagreene, GitHub: /MelindaGreene
* River Robins, In/riverrobins, GitHub: /RiverRobins

Built in Java on the Spring framework, this application utilizes the MVC design pattern and is a collaborative
effort. We integrated official high water crossing data from the Data.SanAntonio.org's
GeoJson file and displayed them on MapBox according to the level of severity for the rainfall. Unifying MySQL
with Hybernate, we enable a database with a OneToOne, OneToMany, and ManyToMany relationship. Hashed
passwords are enforced using Spring Security and Geocoding is dispatched with a Java api service.