# FinalNovus
This automation project is final


Selenium Grid 
Selenium grid can be set up in two different ways; one through command line and the other through JSON config file.

Machine A (My machine IP Address  192.168.2.63 )
Machine B (Colleague Machine IP Address  192.168.2.86)

Current Version for Selenium is Download version 3.13.0

Step 1
Download the Selenium Server from here.

Step 2
You can place the Selenium Server .jar file anywhere in your HardDrive. But for the purpose of this tutorial, place it on the C drive of both Machine A and Machine B. After doing this, you are now done installing Selenium Grid. The following steps will launch the hub and the node


nitin@Clavax-PC-048:~$ cp -r Downloads/selenium-server-standalone-3.13.0.jar /
cp: cannot create regular file ‘/selenium-server-standalone-3.13.0.jar’: Permission denied
nitin@Clavax-PC-048:~$ sudo cp -r Downloads/selenium-server-standalone-3.13.0.jar /
[sudo] password for nitin:
nitin@Clavax-PC-048:~$ ^C
nitin@Clavax-PC-048:~$



Step 3
We are now going to launch a hub. Go to Machine A. Using the command prompt, navigate to the root of Machine A's - C drive, because that is the directory where we placed the Selenium Server.
On the command prompt, type java -jar selenium-server-standalone-3.13.0.jar -role hub
The hub should successfully be launched. Your command prompt should look similar to the image below
 


C:\Users\Vidushi Mishra> java -jar selenium-server-standalone-3.13.0.jar -role hub
08:58:51.911 INFO [GridLauncherV3.launch] - Selenium build info: version: '3.13.0', revision: '2f0d292'
08:58:51.929 INFO [GridLauncherV3$2.launch] - Launching Selenium Grid hub on port 4444
2018-07-31 08:58:52.691:INFO::main: Logging initialized @2747ms to org.seleniumhq.jetty9.util.log.StdErrLog
08:58:53.284 INFO [Hub.start] - Selenium Grid hub is up and running
08:58:53.286 INFO [Hub.start] - Nodes should register to http://192.168.2.63:4444/grid/register/
08:58:53.286 INFO [Hub.start] - Clients should connect to http://192.168.2.63:4444/wd/hub



Step 4
Another way to verify whether the hub is running is by using a browser. Selenium Grid, by default, uses Machine A's port 4444 for its web interface. Simply open up a browser and go to http://localhost:4444/grid/console








Also, you can check if Machine B can access the hub's web interface by launching a browser there and going to where "iporhostnameofmachineA" should be the IP address or the hostname of the machine where the hub is running. Since Machine A's IP address is 192.168.1.3, then on the browser on Machine B you should type http://192.168.1.3:4444/grid/console



Step 5
Now that the hub is already set up, we are going to launch a node. Go to Machine B and launch a command prompt there.
Navigate to the root of Drive C and type the code below. We used the IP address 192.168.2.63 because that is where the hub is running. We also used port 5566 though you may choose any free port number you desire.
NOTE: You now have to give path to the Gecko driver if using Firefox. Here is updated code that needs to be used



To connect on windows machine chrome driver on port 5566 from hub (windows)

java -Dwebdriver.crome.driver=”c:\chrome.exe” -jar c:\selenium-server-standalone-3.13.0.jar -port 5566 -role node - hub http://<ipaddressofhub>:4444/grid/register -browser “browserName=chrome,maxInstances=1”


	To connect on windows machine firefox driver  from hub (windows)

java -Dwebdriver.gecko.driver=”c:\geckodriver.exe” -jar c:\selenium-server-standalone-3.13.0.jar -port 5001 -role node - hub http://192.168.43.160:4444/grid/register -browser “browserName=chrome,maxInstances=2”

To connect on Ubuntu machine chrome driver  from hub (windows)


java -Dwebdriver.chrome.driver=”/chromedriver” -jar /selenium-server-standalone-3.13.0.jar -port 5555 -role node -hub http://192.168.2.63:4444/grid/register -browser “browserName=chrome,maxInstances=2,platform=linux”

To copy in linux 

cp -r /locationcopyfrom /locationtocopy <filename> /<destinationlocation>

cp -r /locationcopyfrom /locationtocopy
If password was there 

Sudo 
Enter password 
cp -r /locationcopyfrom /locationtocopy


java -Dwebdriver.gecko.driver="C:\geckodriver.exe" -jar selenium-server-standalone-3.13.0.jar -role webdriver -hub http://192.168.2.63:4444/grid/register -port 5566


Step 6
Go to the Selenium Grid web interface and refresh the page. You should see something like this.







Here 3 nodes are connect with single hub 



Designing Test Scripts That Can Run on the Grid
Test script to run from hub and execute on ubuntu 
Logic is here 
On your test base class, create the object of 
1. threadlocal<RemoteWebDriver>
In normal testng concept in before test 
Where it will take a browser as an argument 
So supply browser as parameter from tesing.xml
Method starts 
2. Create a instance of remotewebdrive = null then 
3. Then logic to choose between the browser 
if(browser.equals(“chrome”){
}
Else if(browser.equals(“firefox”){
}
Create xml 
<suite name ="" >
	<test name ="">
		<classes>
			<class name ="com.clavax.novusloyality.mainBase.BaseClass"/>
		</classes>
	</test>
</suite>




To design test scripts that will run on the grid, we need to use DesiredCapabilites and the RemoteWebDriverobjects.
DesiredCapabilites is used to set the type of browser and OS that we will automate
RemoteWebDriver is used to set which node (or machine) that our test will run against.
To use the DesiredCapabilites object, you must first import this package

To use the RemoteWebDriver object, you must import these packages.

Using the DesiredCapabilites Object
Go to the Grid's web interface and hover on an image of the browser that you want to automate. Take note of the platform, and the browserName showed by the tooltip.
 
 

 



