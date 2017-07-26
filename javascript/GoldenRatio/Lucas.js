// Calculates the first N numbers in the Lucas sequence
// Based on seeds of L1 = 2 & L2 = 1



//Seed variables
var l1 = 2, l2 = 1;

//Const size
//Used const so recursion wont cause stack overflow
//Javascript does not have tail call optimization
//Tail call optimization - No need to keep track of the multiplication
// it needs after the call returns
// Eg =
// no tail recursion = (* 3 (* 2 (* 1 (fact 0))))
// tail recursive = (fact-tail 2 3)
const size = 25;

//Variable storing the sequence
var sequence = [l1, l2];


//Calculates the Fibonacci sequence
function calculateLucas(size){
  //Use the seed value as initial in the for loop
    for (let x = 0; x <= size-2; x++){
        //Calculate the output by adding the two values
        var output = l1 + l2;
        //Assign the old output to l1
        l1 = l2;
        //Assign the new output to the l2 value
        //For the calculation in the next iteration
        l2 = output;
        //Add the output to the array
        sequence.push(output);
    }
}

//Simple function for returning the calculated sequence
function returnSequence(){
  return sequence;
}

//Main
calculateLucas(size);
console.log(returnSequence());
//console.log(sequence)
