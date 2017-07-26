//Calculates the GoldenRatio of phi to the power of n


//Phi is assumed to be 1.618
const phi = 1.618
//Size of the sequence
const size = 25

//Array to store the sequence
var sequence = []

//Calculates the Golden Ratio
function calculateGoldenRatio(size, phi){
  sequence.push(Math.round(phi))
  for(let x = 1; x <= size; x++){
      var output = Math.round(Math.pow(phi, x))
      sequence.push(output)
  }
}

calculateGoldenRatio(size, phi)
console.log(sequence)
