## Documentation ##

BonjourBeacon is a Java based tool that makes networks outside the own subnet accessible for bonjour application. It is designed to work with Airfoil (see http://rogueamoeba.com/airfoil/), but it should work with other applications as well.

Follow the instructions in the graphical user interface to establish a new configuration.

Parameters:

  * Profile Name: the name of the profile (used as identifier and filename, must be unique)
  * Host Name: the name of the host that shall be made accessible in your subnet
  * Host MAC: the MAC value of the host, without ':' (e.g. 000C76C03FA6)
  * Host IP: the IP address of the host
  * Password: true, if enabled, false otherwise
  * Local OS: select an existing item, or use custom to enter a custom value
  * Protocol/Port: the protocol and port, for airfoil `_airfoilspeaker._tcp./5000`

By default the autostart of the profile is disabled. Hence you must click the start button to register your profile. You can enable autostart in the context menu, which you reach by clicking the Config button next to your profile. The profiles are stored in the 'configurations' folder, the name of the file is %profileName% (note: space is replaced by '`_`'). The next time you start BonjourBeacon the tool looks in the configurations folder for existing configuration files.

For each profile a dns-sd instance is executed (when the profile is running). Dns-sd is a command line tool that enables exactly the features we need such that our bonjour application work. The dns-sd command looks as follows:

```
dns-sd -P %MAC%@%HOSTNAME% %PROTOCOL% "" %PORT% %HOSTNAME%.local %IP% tp=UDP txtvers=1
ss=16 rast=afs pw=%PASSWORD% raver=1.0.0.0 sr=44100 ch=2 ramach=%OS-VALUE%
```

for example:

```
dns-sd -P 000C76C03FA6@Bandersnatch _airfoilspeaker._tcp. "" 5000 bandersnatch.local 172.16.14.102 tp=UDP txtvers=1
ss=16 rast=afs pw=true raver=1.0.0.0 sr=44100 ch=2 ramach=Win32NT.5
```

The dns-sd process instance is maintained and when exiting BonjourBeacon the application takes care that the registered dns-sd instances are killed.

Note: To see some debug messages, run the jar file from commandline:

```
java -jar BonjourBeacon.jar
```

<p>
<h2>Release Notes</h2>

<ul><li>beta version still has bugs on MacOSx (not functional on mac)<br>
</li><li>changing items is not yet implemented<br>
</li><li>text field for password will be changed to checkbox, value must be 'true' or 'false'<br>
</li><li>mac value must be entered without ':'