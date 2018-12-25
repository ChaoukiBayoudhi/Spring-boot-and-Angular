# Spring-boot-and-Angular
Spring-boot back and Angular 7 Material front
you need jdk 1.8 or higher
you need to install npm, nodejs and Angular 7
install and add these libraries to the Client project (the angular)
@angular/Material, @angular/animations and @angular/cdk
on your terminal execute this line :
npm install --save @angular/material@7.0.2 @angular/cdk@7.0.2 @angular/animations
then you need to install MySql
create the user "user12" identified by "s$cret" password
grant all priviliges to this user by running (after connecting as root $mysql -u root)
mysql> GRANT ALL PRIVILEGES ON database_name.* TO 'username'@'localhost';
connect as user12 ($mysql -u user12 -p s$cret) and execute the file MysqlToyDB.sql by executing the command
mysql> source /path/to/the/file/MysqlToyDB
run the server project by executing on your terminal the command 
$mvn spring-boot:run
To run the angular project just execute "ng serve -o" on the folder "ToyManagementClient"
Enjoy!
