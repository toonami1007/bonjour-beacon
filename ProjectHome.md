## Introduction ##

When starting to use Airfoil (a tool to stream music to different computers in the network, see http://rogueamoeba.com/airfoil/), the limitations of the Bonjour protocol (formerly known as Rendezvous) become very annoying. The Bonjour protocol is designed to only recognize network entities within the own subnet. Hence, when your computer is behind a router within a bigger network, it is not easily possible to access other computers outside your own subnet.

For this problem Bonjour Beacon offers a simple solution: it makes network entities outside the own subnet accessible for bonjour applications using the command line tool dns-sd. As the batch command for dns-sd is very long and complicated, Bonjour Beacon supports the user with an intuitive graphical user interface.

<img src='http://bonjour-beacon.googlecode.com/svn/trunk/BonjourBeacon/doc/bonjour-beacon-screen.png' title='Screenshot of Bonjour Beacon' />

Have a look at the documentation and try it out.