# BoojProject
Android Code Test

Goal:
Create a simple application that will parse the JSON returned in the link below and populate a list view.  
Each list view row should contain the realtor’s photo, name, and phone number.  
A second page should be displayed when a row is clicked, showing a larger image of the realtor and additional information (such as their office phone number, cell number, office name).

Accomplished:
1) Setup Project to work on both mobile phones and tablets using Fragmentation
    - Tablets have both the realtor list & realtor view presented to user on a single screen
    - Phones handle the list fragment first, then if user clicks on one sends user to a more detailed view of item in another fragment
    - Tablet/Phone device has its own separate layout files to provide optimal UX
2) Implemented a Recyclerview to handle list of Realtors. 
3) Integrated LoopJ library to provide Asyncronous callback Http client to obtain information from endpoint
4) Integrated Picasso library to hadle image downloading/caching/transformation for application images
    - Also integrated another 3rd party picasso-transformations library to provide CropCircle for list view images
5) Implemented a Singleton design pattern to handle list of realtors to be used in the listview and itemview fragments
