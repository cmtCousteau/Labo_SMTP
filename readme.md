RES - Labo SMTP
===================

Description
-------------
The purpose of this project is to create a small SMTP client with java to learn the basics of the this protocol.
The project is programmed with NetBeans 8.1.


Use
-------------
Once you have downloaded the project it must be really simple to use it.
You have 3 files of config wich you can edit.

The first one (config.properties) contain the port of the SMPT server you want to use,
the hostname of the server and finaly the numbers of groups you want.

![alt text](/images/config.png "File 1")

The second file(victims.txt) contain the list of the victims mail adresses. You need to put one adress by line.

And the last file(messages.txt) contain the message to send. A message always begin with a subjet, an empty line and the content
of the message. The message is ended by ":::".

Mock server
-------------
To test the application it could be usefull to have a STMP server of test.
I used this one : https://github.com/tweakers-dev/MockMock
To install it and if you are familiar with maven you can clone the repo and build it.
Or you can download the .jar file here : https://github.com/tweakers-dev/MockMock/blob/master/release/MockMock.jar?raw=true

Once you have download it, use it is very simple. To start the server you shoud use the command : ```java -jar MockMock.jar```
By default the server listen on the port 25, and the hosthame is obviously *localhost*.
The HTML server from where you can see your mail is running by default on the port 8282. To acced it use this URL : *http://localhost:8282/*

If you want to change the default port you can use this command to start the mock server : ```java -jar MockMock.jar -p 25000 -h 8080```.
*-p* define the SMTP server port and *-h* define the HTML server port.