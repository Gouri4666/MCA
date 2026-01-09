try:
        a = int( input (' Enter numerator : ' ) )
        b = int( input (' Enter denominator : ' ) )
        print('%d / %d = %f' % (a,b,a/b))
except (ZeroDivisionError, ValueError) as e:
        print(e)
else:
        print('Division successful')
finally:
        print('Executed always')
