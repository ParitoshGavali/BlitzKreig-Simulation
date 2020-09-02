from mpl_toolkits.mplot3d import Axes3D
import matplotlib.pyplot as plt
import csv

fig = plt.figure()
ax = Axes3D(fig)

x,y,z = [],[],[]

with open('data.csv' , 'r') as file :
    reader = csv.reader(file)
    c = 0
    for row in reader :
        if c > 0 :
            x.append(float(row[0])*100) , y.append(int(row[1])) , z.append(int(row[2]))
        c+=1

ax.scatter(x, y, z, c='r', marker='o')

ax.set_xlabel('P')
ax.set_ylabel('W')
ax.set_zlabel('T')

plt.show()
