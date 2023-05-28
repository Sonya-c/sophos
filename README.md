# sophos

1. Setup MySql 

Enter to mysql
~~~
sudo mysql -u root -p < 
~~~
In my sql, create the database and fill the data using
~~~
source create.sql
~~~

2. Run
~~~
mvn clean package
java -jar target/sophos-0.0.1-SNAPSHOT.jar
~~~
If you are in windows, tou can also run compile.bat and run.bat

3. Use

  * /clients: see all clients and create new clients
  * /clients/edit/id: edit a client 
  * /clients/loans/id: see the loans of a client
  * /videogames: see all videogames and create a new viodegame
  * /videogames/edit/id: edit videogame and add unit to that videogame
  * /loans: see all loans an create new ones
  * /: dashboard, see most frequent user, most frequent videogame and today loans


