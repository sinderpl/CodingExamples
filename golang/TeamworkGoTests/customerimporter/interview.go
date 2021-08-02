// package customerimporter reads from the given customers.csv file and returns a
// sorted (data structure of your choice) of email domains along with the number
// of customers with e-mail addresses for each domain.  Any errors should be
// logged (or handled). Performance matters (this is only ~3k lines, but *could*
// be 1m lines or run on a small machine).
package customerimporter

import (
	"encoding/csv"
	"errors"
	"fmt"
	"net/mail"
	"os"
)

const (
	notOpened = "The selected file could not be opened"
	notRead   = "The selected file could not be read correctly"
)

type custData struct {
	Name   string
	Email  string
	Gender string
	IP     string
}

// Parse file content and validate for any errors
func ParseFileContent(fileContent [][]string) []string {

	for _, line := range fileContent[1:30] {
		// custEmail := line[2]

	}
	return nil

}

func getCustomerDomain(line []string) (string, error) {
	// domain = nil

	// Test the correct cell
	domain, err := mail.ParseAddress(line[2])

	if err != nil {
		fmt.Println(err)
	}

	fmt.Println(domain)
	// If not found in cell test other ones
	// for _, cell := range line{

	// }

	return "domain", nil
}

// Reads in the specified file and returns the contents
func ReadFileContents(fileName string) ([][]string, error) {

	csvFile, err := os.Open(fileName)
	if err != nil {
		return nil, errors.New(notOpened)
	}

	defer csvFile.Close()

	csvLines, err := csv.NewReader(csvFile).ReadAll()
	if err != nil {
		return nil, errors.New(notRead)
	}

	return csvLines, nil
}

func printCustomers(fileContent [][]string) {
	for _, line := range fileContent[1:] {
		cust := custData{
			Name:   line[0] + " " + line[1],
			Email:  line[2],
			Gender: line[3],
			IP:     line[4],
		}
		fmt.Println(cust)
	}
}
