Hospital Simulator by José Chavarria


There are two ways to run some test cases:

1- command line

- Build application with maven "mvn clean install"
- got to target folder and execute the command "java -cp hospital-simulator.jar com.edgelab.hospital.Application F P"

2- Via Parametrized Test

- Go to com.edgelab.hospital.ApplicationTest and execute as Junit Test
- Fell Free to add more cases in data() method
    - Add a new element of the return array {status, drugs , expected result}
    - Example , {"H,F,F,F,F,D", "As", "F:0,H:5,D:0,T:0,X:1"}
    
 