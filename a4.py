'''
 NAME: 		ANAND   	and    PIYUSH AGGARWAL
 ROLL NO:  2017218		     	  2017356
 GROUP:		 A-1			    	A-1
 ---------------------------------------------------------------------------
	________  _______   
    |__   __| |  ____|     /``\     |``\  /``|       |````````|
	   | |	  |  |__      /    \    |   \/   |       ```````| | 
  	   | |	  |  ___|    /  /\  \   |        |       |``````  |
	   | |    |  |___   /  /--\  \  |  |\/|  |       |  |``````
	   |_|	  |______| /__/    \__\ |__|  |__|   of  |  ``````| 
													 ``````````
	  Anand                   and 				Piyush Aggarwal
     2017218 										2017356
   				   Group : A-1 (Both Teammates)
 											 
___________________________________________________________________________
				
				HOMEWORK 4: RANK OF A MATRIX
___________________________________________________________________________
'''

def swapRows(A,row1,row2):
	"""
	The function swapRows(A,row1,row2) performs a swap between two rows of a given
	matrix.
	The function takes 3 arguments:
		--> A represents the matrix
		--> row1 and row2 are indices of the rows to swap. The possible values for the arguments row1 and
		row2 are 0, ..., nrows - 1, where nrows in number of rows in A
	Sample:
	A=[[1,2,3],[4,5,6],[7,8,9]]
	swapRows(A,0,2) results in A changed to [[7,8,9],[4,5,6],[1,2,3]]
	"""
	x=A[row1]
	A[row1]=A[row2]
	A[row2]=x

def Row_Transformation(A,x,row1,row2):
	"""
	This function Row_Transformation(A, x, row1, row2 ) performs row transformation on
	matrix A by transforming as
	row2 --> row2 + x * row1
	Preconditions:
	--> A is a matrix containing integers
	--> x is of type double
	--> The possible values for the arguments row1 and row2 are 0, ..., nrows - 1, where nrows in number
	of rows in A
	Sample:
	A=[[1,2,3],[4,5,6],[7,8,9]]	
	Row_Transformation(A,3,0,2) results in A changed to [[1,2,3],[4,5,6],[10,14,18]]
	"""
	N=len(A[0])
	for i in range(N):
		A[row2][i]=A[row2][i] + (x * A[row1][i])


def MatrixRank(A):
	"""
	This function supports finding rank of a given
	matrix. In the module define a function MatrixRank(A) that
	--> takes a nested list A(to represent a matrix) as an argument and
	--> returns an integer representing the rank of A
	--> Preconditions: A is a matrix containing integers
	"""

	M=len(A)
	N=len(A[0])
	rank=min(M,N)
	i=0
	while (i<rank):
		if(A[i][i]!=0):

			for j in range(M):
				if(j!=i):
					x=-1*(A[j][i]/A[i][i])
					Row_Transformation(A,x,i,j)
			i+=1		
		elif(A[i][i]==0):
			flag=0
			sw=-1
			for j in range(i+1,M):
				if(A[j][i]!=0):
					sw=j
					flag=1
					break
			if(flag==1):
				swapRows(A,i,sw)
			if(flag==0):
				for k in range(M):
					a=A[k][i]
					A[k][i]=A[k][N-1]
					A[k][N-1]=a	
				rank-=1
	return(rank)				
				
 
# if __name__ == '__main__':
# #	"""
# 	M=int(input('Enter the no. of rows : '))
# 	N=int(input('Enter the no. of columns : '))
# 	print('Enter the values of the matrix : ')
# 	mat=[]
# 	for i in range(M):
# 		t=[]
# 		t=list(map(int,input().split()))
# 		mat.append(t)
# #	"""

# #	M=3
# #	N=3
# #	mat=[[1,2,3],[4,5,6],[7,8,9]]

# 	print('The rank of the matrix is : ',MatrixRank(mat))