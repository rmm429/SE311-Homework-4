To run this program without an IDE, download and execute the JAR file under the Releases section.

There are two separate Java projects contained - CalculatorClient and LogServer.
To run either program, run the Driver.java file in the "src/se311" folder contained within either of the project directories.
The main() method is included here for both.

Notes:

	The Server needs to be run first before the Calculator Client can connect to it.
	However, the Calculator can still function wihtout the Server.
	The console of the Calculator Client will output whether or not it has connected to the Server.
	Please wait for confirmaiton in the Calculator console that either a connection was established or not before performing operations.
	If executing the JAR, the calculator will not accpet input for a couple of seconds until it has either connected to the Server or determined it can not.

	The Server will display an equation every time it is received from any Client as well as a tally of the total calcuations performed before it.

	The Calculator Client does not display intermediate results.
	This means that, for example, doing 3+2+1 will not first show the result of 3+2 (5) before doing the +1.

	Furthermore, the Calculator automatically goes back to the start and clears previous results after performing a calculation.
	This means that you cannot use a previous calculation as the first operand in a new calculation.
	For example, 1+2*3 = 7, and pressing +1 after this will not calculate 8, but rather start a new calculation.

Soruces used to assist development:

	BigDecimal: https://www.geeksforgeeks.org/bigdecimal-class-java/
	Rounding Float: https://www.baeldung.com/java-round-decimal-number
