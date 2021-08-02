package customerimporter

import (
	"log"
	"testing"
)

func TestCustomerDomainSuccess(t *testing.T) {

	failureScenarios := [][]string{
		{"", "", "email@example.co.jp", ""},
		{"", "", "firstname-lastname@example.com", ""},
		{"", "", "_______@example.com", ""},
		{"", "", "email@123.123.123.123", ""},
		{"", "", "email@example.name", ""},
	}

	for _, line := range failureScenarios {
		_, err := getCustomerDomain(line)
		if err != nil {
			t.Fail()
			t.Logf("Expected the customer parsing to succeed, a error has occured instead %s ", line)
			log.Fatal(err)
		}
	}
}

func TestCustomerDomainFailures(t *testing.T) {

	failureScenarios := [][]string{
		{"", "", "email", ""},
		{"", "", "84575,", ""},
		{"", "", "@@", ""},
		{"", "", "dfd@.com", ""},
		{"", "", "", ""},
		{"", ""},
		{"", "", "------@", ""},
	}

	for _, line := range failureScenarios {
		_, err := getCustomerDomain(line)
		if err == nil {
			t.Fail()
			t.Logf("Expected the customer parsing read to fail, a error has not been thrown %s ", line)
			log.Fatal(err)
		}
	}
}

func TestReadFileExists(t *testing.T) {
	fileName := "../data/customers.csv"
	_, err := ReadFileContents(fileName)

	if err != nil {
		t.Fail()
		t.Logf("Expected the file read to succed, a error has occured instead %s", fileName)
		log.Fatal(err)
	}
}

func TestReadFileDoesNotExist(t *testing.T) {
	fileName := "../data/.csv"
	_, err := ReadFileContents(fileName)
	if err == nil {
		t.Fail()
		t.Logf("Expected the file read to fail, the error should not be empty %s", fileName)
		log.Fatal(err)
	}
}
