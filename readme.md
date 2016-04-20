RES - Labo SMTP
===================

Description
-------------
The purpose of this project is to create a small SMTP client with java to learn the basics of the this protocol.
The project is programmed with NetBeans 8.1.
The application should be able to send prank message to a list of victims divided by groups and from some other victims.

How to use
-------------
Once you have downloaded the project it must be really simple to use it.
You have 3 files of config wich you can edit.

The first one (config.properties) contain the port of the SMTP server you want to use,
the hostname of the server and finaly the numbers of groups you want. Dont forget that the minimum size of group
is 3 (2 victims 1 sender), so when you set the number of groups be sure it's match with the number of mails, otherwise
the program will not work. 

![config.png](/figures/config.png "File 1")

The second file(victims.txt) contain the list of the victims mail adresses. You need to put one adress by line.

![victims.png](/figures/victims.png "File 2")

And the last file(messages.txt) contain the message to send. A message always begin with a subjet, an empty line and the content
of the message. The message is ended by ":::".

![messages.png](/figures/messages.png "File 3")

And now you can just run the program and it will send the mails.

How it's work
-------------

The application contain 9 classes including the main class.
Each class has a specific function. I will make a little description of each.

**Group.java:**
This class is responsible of making a group of victims and to choose randomly a sender from the victims.

**Mail.java:**
This class contain all the information about the mail that we will send.

**Message.java:**
This class contain the infos about the content of the mail. the subject and the content.

**ReadMails.java:**
This static class read the mail adresses of the victims from the file *victims.txt* and return a list of all the mail.

**ReadMessage.java:**
This static class read the prank message from the file *messages.txt* and return a list of *Message*

**Main.java:**
It's the main class and use all the other classes to send the prank mails.

**ReadProperties:**
This class read the config informations from the file *conf.properties*, like the server hostname and the port.

**SmtpServer.java:**
This class is responsible of the connexion to the SMTP server and to send *Mail*.

**Utils.java:**
This class contain some utilities functions, like opening a socket of sending/reading a message to/from a socket.

**Here it is the UML diagramme :**
![uml_diagram.png](/figures/uml_diagram.png "File 4")

At first we get a *Properties* object to read the server hostname and port further. Next we create a list of *String* and get the
list of all the victims adresses.

After that we create a list of *Group* and split the mails list into it if it's possible(the number of group
shoud match with the number of mails to have at minimum groups of 3 people).

After that we get the list of *Message* and open the connexion to the SMTP server (TCP and telnet).
And finaly for each group we create a *Mail*, choose a random prank message and send it to the victims of the *Group* from the sender of the *Group*.
For finish we close the connexion(Telnet and TCP).

**Ilustration how the application dialogue with the SMTP server:**
![dialogue.png](/figures/dialogue.png "File 3")

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