# Double-Pendulum-

A visual of a 10,000 double pendulums simulation. The pendulums can be run on Euler's method as well as runge Kutta of Order 4. By default they are set to run on Euler's Method due to lesser time complexity. 

The following code also maps rotational kinetic energy of all initial angular positions for a double pendulum. This results in an intriguing visual pattern depicting the chaotic nature of the double pendulum.
The colors of the energy goes from dark to bright with increasing energies. The colour scheme for energies is as follows-
  > Black - 0-5 units
  > Purple - 6-10 units
  > Dark Blue - 11-15 units
  > Sky Blue - 16-20 units
  > Green - 21-30 units
  > Yellow - 31-50 units
  > Orange - 51-70 units
  > Red - 71- 90 units
  > Pink - 91 - 130 units
  > White - all values > 130 units
In the visual we can see that regions with smaller initial angles are more predictable and can be moddled with a simpler equation.

The following project was entirely coded in Java. By default the main function will run the visual 10,000 double pendulums. Simply change the variable `choice` to `true` to run the map of all kinetic energies.

Visuallizing chaotic systems result in increasingly interesting patterns.
