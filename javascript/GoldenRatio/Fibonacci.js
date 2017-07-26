// Calculates the first N numbers in the Fibonacci sequence
// Based on seeds of F1 = 1 & F2 = 1



//Seed variables
var f1 = 1, f2 = 1

//Const size
//Used const so recursion wont cause stack overflow
//Javascript does not have tail call optimization
//Tail call optimization - No need to keep track of the multiplication
// it needs after the call returns
// Eg =
// no tail recursion = (* 3 (* 2 (* 1 (fact 0))))
// tail recursive = (fact-tail 2 3)
const size = 25

//Variable storing the sequence
var sequence = [f1, f2]


//Calculates the Fibonacci sequence
function calculateFibonacci(size){
  //Use the seed value as initial in the for loop
    for ( let x = 0; x <= size-2; x++){
        //Calculate the output by adding the two values
        var output = f1 + f2
        //Assign the old output to f1
        f1 = f2
        //Assign the new output to the f2 value
        //For the calculation in the next iteration
        f2 = output
        //Add the output to the array
        sequence.push(output)
    }
}

//Main
calculateFibonacci(size)
console.log(sequence)
