# Double-Pendulum-

A visual of a 10,000 double pendulums simulation. The pendulums can be run on Euler's method as well as runge Kutta of Order 4. By default they are set to run on Euler's Method due to lesser time complexity. 

Initial divergence
![image](https://user-images.githubusercontent.com/70505388/188737815-c0fb1347-9161-4dbb-b1cf-982bbd10a231.png)

Geater divergence
![image](https://user-images.githubusercontent.com/70505388/188738007-752c3003-bc40-46c7-be9c-654b949fe456.png)



The following code also maps rotational kinetic energy of all initial angular positions for a double pendulum. This results in an intriguing visual pattern depicting the chaotic nature of the double pendulum.
The colors of the energy goes from dark to bright with increasing energies. The colour scheme for energies is as follows-

1.   Black - 0-5 units,
2.   Purple - 6-10 units,
3.   Dark Blue - 11-15 units,
4.   Sky Blue - 16-20 units,
5.   Green - 21-30 units,
6.   Yellow - 31-50 units,
7.   Orange - 51-70 units,
8.   Red - 71- 90 units,
9.   Pink - 91 - 130 units,
10.  White - all values > 130 units,
  
In the visual we can see that regions with smaller initial angles are more predictable and can be moddled with a simpler equation.

The following project was entirely coded in Java. By default the main function will run the visual 10,000 double pendulums. Simply change the variable `choice` to `true` to run the map of all kinetic energies.

Visuallizing chaotic systems result in increasingly interesting patterns.
![image](https://user-images.githubusercontent.com/70505388/188736825-980c70ad-72ca-4716-8642-f908273e341d.png)
