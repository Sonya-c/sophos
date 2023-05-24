# sophos

1. Setup MySql 

~~~
sudo mysql -u root -p < ./setup_database.sql
~~~

2. Run
~~~
mvn clean package
java -jar target/sophos-0.0.1-SNAPSHOT.jar
~~~