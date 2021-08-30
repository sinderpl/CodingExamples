# -*- coding: utf-8 -*-
"""
Created on Mon Aug 30 15:49:24 2021

@author: alann
"""

arr = [[1,1,0,1,0],
[0,1,1,1,0],
[1,1,1,1,0],
[0,1,1,1,1]]

def largestSquare(arr ) -> int:
    if len(arr) < 1 or len(arr[0]) < 1:
        return 0
    
    largest = 0
    cache = [[0 for i in range(len(arr[0]))] for j in range(len(arr))]
    
    for i, iVal  in enumerate(arr):
        for j, jVal in enumerate(iVal):
            if jVal:
                if not i or not j:
                    cache[i][j] = jVal
                else:
                    currentMin = None
                    currentMin = min(currentMin, cache[i-1][j]) if currentMin != None else cache[i-1][j]
                    currentMin = min(currentMin, cache[i-1][j-1]) if currentMin != None else cache[i-1][j-1]
                    currentMin = min(currentMin, cache[i][j-1]) if currentMin != None else cache[i][j-1]
                    
                    cache[i][j] = currentMin + 1
                largest = max(largest, cache[i][j])
    return largest



largest = largestSquare(arr)
print(largest)



"""
    if we are allowed to modify original array we can do it in constant space
"""

arr = [[1,1,0,1,0],
[0,1,1,1,0],
[1,1,1,1,0],
[0,1,1,1,1]]

def largestSquare(arr ) -> int:
    if len(arr) < 1 or len(arr[0]) < 1:
        return 0
    
    largest = 0
    
    for i, iVal  in enumerate(arr):
        for j, jVal in enumerate(iVal):
            if jVal:
                if not i or not j:
                    arr[i][j] = jVal
                else:
                    arr[i][j] = 1 + min(arr[i-1][j], arr[i-1][j-1],arr[i][j-1])
                largest = max(largest, arr[i][j])
    return largest



largest = largestSquare(arr)
print(largest)