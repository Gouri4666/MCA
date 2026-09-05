
#         * 
#        * * 
#       * * *
#      * * * *
#     * * * * *
#    * * * * * *
n=5
for i in range(n+1):
    for j in range(2*n-1,i,-1):
        print(" ",end="")
    for k in range(j):
        print("* ",end="")
    print()