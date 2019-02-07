# Assignemnt 1
## Shopping List App



### This assignment deomstrates navigating to a second activitiy and returning some state from that second activity. It also requires maintaining state through activity lifecycle changes, and responsive design that works well in all orientations and with different sizes of phones and tablets. 

Create a simple shopping-list app with a main activity for the list the user is building, and a second
activity for a list of common shopping items.

* The main activity should contain the list to build, which should be made up of ten
empty TextView elements that show the item and count.
* An Add Item button on the main activity launches a second activity that contains a list of ten
common shopping items (Cheese, Rice, Apples, and so on). Use Button elements to display
the items.
* Choosing an item returns the user to the main activity, and updates a TextView to include the
chosen item. If the item has not been chosen add it to the list, if the item has already been
chosen increment it’s count.
* Implement “up-navigation” to return to the main activity without choosing an item.
Use an Intent to pass information from one Activity to another. Make sure that the current state of the
shopping list is saved when the user rotates the device. Have different layouts for both horizontal
orientation, vertical orientation, and tablets.


Use appropriate layouts, your layouts should work on most phone shapes and sizes without
modification (use no fixed sizes). All resources should be in resource files (no hard-coded strings,
they should all be in strings.xml).

Push your completed project on the master branch. The last commit before the due date is what will be marked. 

Melanie