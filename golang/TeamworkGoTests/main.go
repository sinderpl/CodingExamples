package main

import (
	"TeamWorkGoTests/customerimporter"
	"fmt"
)

const fileName = "data/customers.csv"

func main() {
	fileContent, err := customerimporter.ReadFileContents(fileName)
	fmt.Println(err)
	uniqueDomains := customerimporter.ParseFileContent(fileContent)
	fmt.Println(uniqueDomains)

}
