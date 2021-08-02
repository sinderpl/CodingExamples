package main

import (
	"TeamWorkGoTests/customerimporter"
	"fmt"
)

const fileName = "data/customers.csv"

func main() {
	fileContent, err := customerimporter.ReadFileContents(fileName)
	if err != nil {
		fmt.Println(err)
	} else {
		uniqueDomains := customerimporter.FilterCustomerDomains(fileContent)
		fmt.Println(customerimporter.SortDomains(uniqueDomains))
	}
}
