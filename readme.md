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