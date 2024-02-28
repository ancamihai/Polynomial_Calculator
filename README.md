# POLYNOMIAL CALCULATOR
## DESCRIPTION
$~~$ A **Java Desktop application** which has the role of a polynomial calculator. Through a dedicated _graphical user interface_ (implemented with **Java Swing**) a person can _enter polynomials_, __select operations_ to apply on them: 
* addition
* subtraction
* multiplication
* division
* derivative
* integral 

and _view the results_ of their actions on the screen.

Notes: 
* The users are allowed to _reset the fields_ of the _input_ polynomials (and of the _result_ one).
* A polynomial is considered to be **correctly introduced** if its composed of _monomials_, where a _monomial_ has the following structure: _[+ for positive numbers (excluding the first monomial)][integer][opt: X[opt: ^natural number]]_.\
Any other structure, any other characters or empty fields for the considered polynomials will generate a pop-up saying that the input has a bad format.

## STRUCTURE

$~~$  **OOP** design of the application - The project is based on a _layered architecture_, which has the following advantages:
  1. **Code Maintenance** is easy: we can easily determine any kind of change in the code
  2. **Security**: the data-providing package isn’t affected by the other packages
  3. **Ease of development**: building time taken by the application will be small as all the layers can work together at the same time
     
&nbsp;

$~~$  The project has 3 packages + the _Main class_ (its purpose is to run the application):
  1. **Data Models** – contains the classes _modeling the application data_ \
$~~~~~~~~~~~~~~~~~~~~~~~~$- in this app: the **Polynomial** class
  2. **Graphical User Interface** – contains the classes implementing the _graphical user interface_
  3. **Business Logic** – contains the class implementing the _mathematical functionality_ (**Operations** class) and also the one _transforming the inputs_ of the graphical user interface _into the required data_ (**Parsing** class)

&nbsp;

**FULL DOCUMENTATION OF THE PROJECT** - _Documentation.pdf_
