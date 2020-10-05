# Assignment

1.  Create a HTML page for converting form fields into JSON string
    fields are:

        loanAccountType:    RADIO-BUTTONs: Mortgage, Personal, Appliance
        loanAccNumber:      TEXTFIELD
        Customer-FirstName: TEXTFIELD
        Customer-LastName:  TEXTFIELD
        Outstanding:        TEXTFIELD

2.  While converting to JSON string type, make sure "firstName" and "lastName" are NESTED object/properties

3.  String should be like:
    { "loanAccountType": "Personal", "loanAccNumber": 10029, 
        "Customer": {"firstName" : "Xyz", "lastName":"pqr" }, "Outstanding": 120000 }