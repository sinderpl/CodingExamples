console.log("Hello ! Welcome to FizzBuzz");

//The number of iterations to go through
var size = Number(100);

//For loop iterating from 1 to size(100)
for(num = 1; num <= size; num++){
  //Check whether the number is a multiple of both
  // 3 and 5
  if(num%3==0 && num%5==0)
    console.log("FizzBuzz");
  //Check whether the number is a multiple of 3
  else if (num%3==0)
    console.log("Fizz");
  //Check whether the number is a multiple of 5
  else if (num%5==0)
    console.log("Buzz");
  //Print the number instead of a string
  else
    console.log(num);
}
