package main
import "fmt"

//Function creating the size array
func calculateFizzBuzz(int size) {

  for num := 0; num <= size; num++{
    //Check whether the number is a multiple
    //of both 3 and 5 for FizzBuzz
    if( num%3 == 0 && num%5 == 0){
      output.append("FizzBuzz")
    }
  }
}

func main()  {
  //Amount of numbers to count to
  var size int = 100
  var output [size]String



  fmt.Println("Hello")
}
