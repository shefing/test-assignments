# Angular-test-assignment

Create an Angular single-page application.

1. **UsersTable** - The home page is a table of users, which shows data from https://jsonplaceholder.typicode.com/users, with the following columns: name, email, company name. 
2. Add the ability to filter the table by name and email.

3. **UserPosts** - Upon selection of user display a list of posts posted by the selected user on the right side of the screen
(get data from https://jsonplaceholder.typicode.com/posts - see also Filtering resources). 

4. **NewPost** - Add Create post button to **UserPosts** that will open a dialog where user can enter details to create the post 
(see Creating a resource in https://jsonplaceholder.typicode.com/guide/ - note that resource will not be really created on the server but it will be faked as if) ,
Please add validation to the dialog.
After post is created the list of posts for the user (**UserPosts**) will be updated with new post.

**Bonus points for:**

5. Error handling when fetching data from the API , what should the user get ? what do you do as the system in such case ?

6. A loading indicator while fetching data from the API.
   
7. The application to be responsive and look good on both desktop and mobile.
   
9. Add search box which will filter the table by name or email.

# Recommendations
1. Try to produce a professional looking page so use a component library such as  https://material-ui.com/, https://ant.design/, or anything else you like.
2. Create an easy to read code, and ensure you do understand your own code, since our interview will focus on that code
3. Structure the project in a way that promotes scalability and maintainability
4. Make sure the project build is o.k. and no debugger and development logs are left in the code and no errors or warnings in the console.
5. Use comments in the code to explain the untrivial aspects of the code
6. Make best use of most updated Angular framework

# Important
We will test your work by cloning your code and build it locally. Make sure you leave a code that has no other dependencies than thoses specified in the project. We do recommend to test the GIT locally on clean server to make sure project dependencies are correct and project is built and runs o.k.
