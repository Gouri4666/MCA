month = int( input (' Enter month: ') )
try:
    if month < 1 or month > 12:
        raise ValueError( ' Invalid Month ' )
    print(' Valid Month ')
except Exception as e:
    print(e)
