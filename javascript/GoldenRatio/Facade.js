//A simplified facade interface that calculates all the sequences

var Facade = {
  fibonacci : null,
  lucas: null,
  goldenRation: null
}


//Calculates the Fibonacci sequence
function calculateFibonacci(size){

  sequence = [];
  f1 = 1, f2 = 1;
  //Use the seed value as initial in the for loop
    for ( let x = 0; x <= size-2; x++){
        //Calculate the output by adding the two values
        output = f1 + f2;
        //Assign the old output to f1
        f1 = f2;
        //Assign the new output to the f2 value
        //For the calculation in the next iteration
        f2 = output;
        //Add the output to the array
        sequence.push(output);
    }
    //return the results
    return sequence;
}

//Calculates the Fibonacci sequence
function calculateLucas(size){

    sequence = [];
    l1 = 2,  l2 = 1;
    //Use the seed value as initial in the for loop
    for (let x = 0; x <= size-2; x++){
        //Calculate the output by adding the two values
        output = l1 + l2;
        //Assign the old output to l1
        l1 = l2;
        //Assign the new output to the l2 value
        //For the calculation in the next iteration
        l2 = output;
        //Add the output to the array
        sequence.push(output);
    }
    //Return the results
    return sequence;
}

//Calculates the Golden Ratio
function calculateGoldenRatio(size, phi){
  //Stores the results
  sequence = [];
  //Add the initial number
  sequence.push(Math.round(phi));
  for(let x = 1; x <= size; x++){
      //Multiply phi to the power of n
      //Round up and set as output variable
      output = Math.round(Math.pow(phi, x));
      sequence.push(output);
  }
  //Return result
  return sequence;
}

function run(){
  //var facade = new Facade();
  //facade.calculate(25);
  console.log(calculateFibonacci(25));
}

run();
