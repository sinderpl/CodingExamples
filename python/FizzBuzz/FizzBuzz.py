class FizzBuzz:

    def __init__(self):
        self.output = []




    def calculate_fizzBuzz(self, size):

        #Count from 1 to 100 inclusive
        for num in range(1, size+1):
            #If the number is a multiple of 3 and 5
            #print the Fizzbuzz keyword
            if(num%5 is 0 and num%3 is 0):
                self.output.append("FizzBuzz")
            #If the number is a multiple of 3
            #Print Fizz
            elif(num%3 is 0):
                self.output.append("Fizz")
            #If the numebr is a multiple of 5
            #Print the Buzz keyword
            elif(num%5 is 0):
                self.output.append("Buzz")
            #Otherwise just print the number
            else:
                self.output.append(num)

    def print_fizzBuzz(self):
        for element in self.output:
            print element


if __name__ == '__main__':
    print("Welcome to FizzBuzz");
    x = FizzBuzz()
    x.calculate_fizzBuzz(100)
    x.print_fizzBuzz()
