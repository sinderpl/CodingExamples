print("Welcome to FizzBuzz");

# Amount of numbers to count to
size = 100;

#Count from 1 to 100 inclusive
for num in range(1, size+1):
    #If the number is a multiple of 3 and 5
    #print the Fizzbuzz keyword
    if(num%5 is 0 and num%3 is 0):
        print("FizzBuzz")
    #If the number is a multiple of 3
    #Print Fizz
    elif(num%3 is 0):
        print("Fizz")
    #If the numebr is a multiple of 5
    #Print the Buzz keyword
    elif(num%5 is 0):
        print("Buzz")
    #Otherwise just print the number
    else:
        print(num)
