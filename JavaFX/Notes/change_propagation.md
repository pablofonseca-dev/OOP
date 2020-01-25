# Change Propagation 

Generator is the component which triggers the change in length variables. 

Cunsomer receives the value from perimeter variable. When our

cunsomer needs to perimeter, it can force the perimeter variable to recalculate

based on latest length values. Calculation has to take place every time cunsomer

need the data. Otherwise, there can be change in one length triggered by generator, 

making the perimeter value invalid. So, in this approach, it is always prudent 

to get the latest lengths and recalculate the perimeter. Mind you, I'm not talking

about the race condition that can occur in multithreaded enviroment. I'm talking about

a simple case of handling change propagation. This approach will ensure that perimeter is 

always valued when the value is returned to the customer. However, there is a problem 

with this approach. There can be chance that they call to get latest lengths or to see

if there are changes to the lenghts costly operation. In such a case, trying to find out if there is an

update every time cunsomer needs, is going to be innefficient and undesirable. We can follow another approach. 

When our generator triggered the change in one of the lengths, it can automatically communicate the perimeter by 

sending an invalidation signal that there is a change in one of it's lengths. That perimeter will be getting 

the latest values of these and recalculates the value. In this approach, there is no need to find out if 

there is any change in the length. It becomes simple data. However many times the cunsomer may need it, the perimeter

won't be recalculated. But this approach is not entirely full proof. It is just perimeter for now. Later on it can be area

as well. Then our application can involve to calculate heights. It can find out angles different of their same size. The 

generator becomes bloated with so many triggers and having logic of all invalitations doesn't help it either. Either 

of the scenarios is not ideal. JavaFX has come up with a different approach of properties. Properties are just wrappers 

around the regular data but they are additionaly wrap up with the change's detection mechanism. Whichever component wants 

to be notified about the change in a specific property will subscribe to it. The property will make sure that it communicates

with the listener waiting to be notified. For example, imagine A, B and C are lengths of a triangle. Perimeter needs all three, 

while area also need three lenghts. Assuming that the triangle is rectangle triangle, to find out cosine of angle A, we need to find 

the radio of hypotenuse and it's at sine side are B and C. So it just need to subscribe to only two of those lengths. Cosine B and 

C also follow the same pattern. If generator has to take care of this, lot of code is necessary. The property pattern award

such boilerplate code. 
 

