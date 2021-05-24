# -*- coding: utf-8 -*-
"""
Created on Thu Mar 25 11:25:39 2021

@author: alann
"""
import requests
from datetime import datetime

apiKey = '65837ca6772c3e676cacc80f5428'

def filterByCountry(partners) -> dict():
    """
    This can be done on the fly but I felt like it would be too much nesting.
    """
    countries = dict()
    for partner in partners:
        countries.setdefault(partner['country'],[]).append(partner)
    return countries


def checkDatesForCountry(country):
    availabilityDates = dict()
    mostAvailableDate = None
    mostAvailableDateEmails = set()
    for partner in country:
        """
        That pesky edge case where the input was simpy a 'U'
        More defensive programming could be utilised in case the nested objects are malformed .
        Especially when it comes to formatting the dates down below
        """
        if isinstance(partner, dict):
            for idx,date in enumerate(partner['availableDates']):
                """
                    Assuming dates are sorted, I check if the next day is at most 1 day away,
                    otherwise that partner is not available for the consecutive dates
                """
                if idx+1 < len(partner['availableDates']): 
                    nextDate = datetime.strptime(partner['availableDates'][idx+1], "%Y-%m-%d").toordinal()
                    currDate = datetime.strptime(date, "%Y-%m-%d").toordinal()
                    if (nextDate - currDate) == 1:
                        availabilityDates.setdefault(date,[]).append(partner['email'])
                        """
                            Keep track of the most common date and the people available for that day,
                            if the lengths are equal, the earliest date is considered based on ordinal values
                        """
                        if(len(availabilityDates[date]) == len(mostAvailableDateEmails)):
                            if currDate < datetime.strptime(mostAvailableDate, "%Y-%m-%d").toordinal():
                                mostAvailableDate = date
                                mostAvailableDateEmails = availabilityDates[date]
                        elif len(availabilityDates[date]) > len(mostAvailableDateEmails):
                            mostAvailableDate = date
                            mostAvailableDateEmails = availabilityDates[date]
    return mostAvailableDate, mostAvailableDateEmails

def constructResponse(countries):
    responseObject = {}
    countryList = []
    for country in countries:
        countryResponse = {}
        date, emails = checkDatesForCountry(countries[country])
        countryResponse['attendeeCount'] = len(emails)
        countryResponse['attendees'] = emails
        countryResponse['name'] = country
        countryResponse['startDate'] = date if date != None else 'null' 
        countryList.append(countryResponse)
    responseObject['countries'] = countryList
    return responseObject

listOfPartners = requests.get('https://candidate.hubteam.com/candidateTest/v3/problem/dataset?userKey='+apiKey);

countries = filterByCountry(listOfPartners.json()['partners'])
payload = constructResponse(countries)

headers={'Content-type':'application/json', 'Accept':'application/json'}
res = requests.post('https://candidate.hubteam.com/candidateTest/v3/problem/result?userKey='+apiKey,json = payload, headers = headers)
print(res.content)



