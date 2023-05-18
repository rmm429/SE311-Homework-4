This project contains two components, a Calculator Client and Log Server.  The Calculator can perform addition, subtraction, multiplication, and division on whole numbers.  The Log Server ouptuts all successfully-executed expressions and calculations.
The Calculator utilizes a MVC structure: the Model updates the View, the Controller manipulates the Model, and the View supplies the Controller. Additionally, four patterns are utilized: Composite, Visitor, Observer, and State.
The Composite Pattern utilizes an expression interface as a Component, concrete arithmetic expressions as Composites, and an atomic expression as a Leaf.
The Visitor Pattern is utilized in the Composite Pattern — the Composites and Leaf listed above can accept a visitor. A visitor interface is utilized as the Visitor and there are two Concrete Visitors: compute and print. The former will perform the calculation and the latter will construct a string from the entire expression entered. These visitors rely on the expression tree created within the State Pattern.
The Observer Pattern is utilized within the MVC. The View is the Subject and will create the UI for the calculator, which the Controller relies on. The Controller is the Observer — it will listen for an action from the calculator UI (View) and update the Model. The Model is the Context and will construct the expression tree and update the calculator UI (View).
The State Pattern is utilized within the Model (Context) and an expression tree will be created based on what the user enters as an expression and in what order. As each button is clicked, the State is shifted and the expression tree is built. There are 8 Concrete States, each determining what State to move to based on which button was clicked in the calculator UI. This state machine will also handle errors.
The Server utilizes the string constructed by the print Visitor to log all successful calculations entered by the user. This also includes the number of successful calculations as well as the entire expression itself.

--

To run this program without an IDE, download and execute the JAR file under the Releases section.

There are two separate Java projects contained - CalculatorClient and LogServer.
To run either program, run the Driver.java file in the "src/se311" folder contained within either of the project directories.
The main() method is included here for both.

Notes:

	The Server needs to be run first before the Calculator Client can connect to it.
	However, the Calculator can still function wihtout the Server.
	The console of the Calculator Client will output whether or not it has connected to the Server.
	Please wait for confirmaiton in the Calculator console that a connection to the Server was established or not before performing operations.
	If executing the JAR, the Calculator will not accpet input for a couple of seconds until it has either connected to the Server or determined it cannot.

	The Server will display an equation every time it is received from any Client as well as a tally of the total calcuations performed before it.

	The Calculator Client does not display intermediate results.
	This means that, for example, doing 3+2+1 will not first show the result of 3+2 (5) before doing the +1.

	Furthermore, the Calculator automatically goes back to the start and clears previous results after performing a calculation.
	This means that you cannot use a previous calculation as the first operand in a new calculation.
	For example, 1+2*3 = 7, and pressing +1 after this will not calculate 8, but rather start a new calculation.

Soruces used to assist development:

	BigDecimal: https://www.geeksforgeeks.org/bigdecimal-class-java/
	Rounding Float: https://www.baeldung.com/java-round-decimal-number
