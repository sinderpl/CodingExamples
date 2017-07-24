import unittest
from FizzBuzz import FizzBuzz

class TestFizzBuzz(unittest.TestCase):

    def test_output(self):
        #Set up test size
        #In this case 15 because it allows to check all possibilites
        # "Fizz,Buzz , FizzBuzz and a normal number"
        testSize = 15

        #Set up the test class and its calculations
        fizzBuzz = FizzBuzz()
        fizzBuzz.calculate_fizzBuzz(testSize)

        output = fizzBuzz.output

        self.assertEqual(output[0], 1, 'The predicted number was incorrect.')
        self.assertEqual(output[2], 'Fizz', 'The predicted output was incorrect.')
        self.assertEqual(output[4], 'Buzz', 'The predicted output was incorrect.')
        self.assertEqual(output[14], 'FizzBuzz', 'The predicted output was incorrect.')

if __name__ == '__main__':
    unittest.main()
