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
	"sort"
	"strings"
)

const (
	fileNotOpened = "The selected file could not be opened"
	fileNotRead   = "The selected file could not be read correctly"
	emailNotFound = "The email could not be found at cell: "
)

func SortDomains(customerDomains map[string]int) PairList {
	keys := make(PairList, len(customerDomains))
	idx := 0

	for key, value := range customerDomains {
		keys[idx] = Pair{key, value}
		idx++
	}

	sort.Sort(sort.Reverse(keys))

	return keys
}

// Sort interface implementation
type Pair struct {
	Key   string
	Value int
}

type PairList []Pair

func (p PairList) Len() int           { return len(p) }
func (p PairList) Less(i, j int) bool { return p[i].Value < p[j].Value }
func (p PairList) Swap(i, j int)      { p[i], p[j] = p[j], p[i] }

// Parse file content and validate for any errors
func FilterCustomerDomains(fileContent [][]string) map[string]int {
	customerDomains := make(map[string]int)
	for _, line := range fileContent[1:len(fileContent)] {
		custDomain, err := getCustomerDomain(line)
		if err != nil {
			fmt.Println(err)
		} else {
			customerDomains[custDomain] += 1
		}
	}
	return customerDomains
}

// Attempt to read the customer domain
func getCustomerDomain(line []string) (string, error) {
	if len(line) <= 2 {
		return "", errors.New(emailNotFound)
	}
	email, err := mail.ParseAddress(line[2])
	if err != nil {
		// Could attempt to parse the email ourselves here since the checker could be limited
		// to a strict set of rules
		return "", errors.New(emailNotFound + line[2])
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
type custData struct {
	Name   string
	Email  string
	Gender string
	IP     string
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
