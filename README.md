WESTERN GOVERNORS UNIVERSITY

D287 – JAVA FRAMEWORKS

Introduction:
This project will be completed through the Intellij application. Here I will be adding notes that 
reference changes made for parts C-J and where to locate them.

C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
- changed title on line 14 to "My Sandwich Shop"
- changed shop name on line 19 to "Breaking Bread"
- changed "Parts" on line 22 to "Build Your Own Sandwich"
- changed "Products" on line 54 to "Sandwiches"


D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
- added about.html to templates
- added a button to the About Us webpage on the mainscreen. line 20
- added a button to the mainscreen, titled "Home" to the about us page. line 16
- added an AboutController file in the controllers folder to map the webpages

E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
- added 5 parts to bootstrap file - lines 45-91
- added 5 products to bootstrap file - lines 93-104


F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.
- added buy now button next to update and delete buttons to mainscreen - line 87-88
- added purchaseconfirmation html file to include purchase successful output
- added outofstock html file to include out of stock output for failures
- added buyproduct controller to map button to purchase confirmation and out of stock

G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.
- added two Min values to Part java file - lines 32-35
- created getter and setter methods for minInv and maxInv to Part java file - line 115-130
- added minInv and maxInv to each part in the bootstrap file - lines 52-53. 62-63, 71-72, 80-81, 89-90
- added additional text to InhousePartForm for minInv and maxInv - lines 24-28
- added additional text to OutsourcedPartForm for minInv and maxInv - lines 25-29
- modified the application.properties url to jdbc:h2:file:~/sandwiches-products-db - line 6
- modified code in part.java to enforce min and max values - lines 136-154

H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.
- created inventory, maximum, and minimum validator files
- modified inhousepartform and outsourcepartform to show error messages - lines 32-36, 32-36
- modified part file to apply minimum and maximum validators - lines 3-4, 20-21

I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
added two test to PartTest to check that the inventory is within the minimum and maximum values - lines 41-57

J.  Remove the class files for any unused validators in order to clean your code.
- deleted DeletePartValidation and ValidDelete validators