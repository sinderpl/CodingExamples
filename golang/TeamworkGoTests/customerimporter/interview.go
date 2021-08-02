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
	"strings"
)

const (
	fileNotOpened = "The selected file could not be opened"
	fileNotRead   = "The selected file could not be read correctly"
	emailNotFound = "The email could not be found: "
)

type custData struct {
	Name   string
	Email  string
	Gender string
	IP     string
}

// Parse file content and validate for any errors
func ParseFileContent(fileContent [][]string) map[string]int {

	customerDomains := make(map[string]int)
	for _, line := range fileContent[1 : len(fileContent)-2] {
		// custEmail := line[2]
		custDomain, err := getCustomerDomain(line)

		if err != nil {
			fmt.Println(err)
		} else {
			customerDomains[custDomain] += 1
		}
	}
	return customerDomains
}

func getCustomerDomain(line []string) (string, error) {
	email, err := mail.ParseAddress(line[2])
	if err != nil {
		return "", err
	}

	lastAt := strings.LastIndex(email.Address, "@")
	domain := email.Address[lastAt+1:]
	if domain != "" {
		return domain, nil
	}
	return "", errors.New(emailNotFound + line[2])
}

// Reads in the specified file and returns the contents
func ReadFileContents(fileName string) ([][]string, error) {

	csvFile, err := os.Open(fileName)
	if err != nil {
		return nil, errors.New(fileNotOpened)
	}

	defer csvFile.Close()

	csvLines, err := csv.NewReader(csvFile).ReadAll()
	if err != nil {
		return nil, errors.New(fileNotRead)
	}

	return csvLines, nil
}

//Unrelated
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
