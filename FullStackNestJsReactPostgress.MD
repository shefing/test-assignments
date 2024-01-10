FullStack-Test Requirements 

Create a Full Stack application using NestJs, React, Docker, AWS, and PostgreSQL. 

Backend (NestJs) 

UsersAPI: Create a NestJs API that fetches data from https://jsonplaceholder.typicode.com/users. The API should return user data with the following fields: name, email, company name. 

PostsAPI: Create another API that fetches posts of a selected user from https://jsonplaceholder.typicode.com/posts. 

NewPostAPI: Add an API endpoint that allows users to create a new post. The new post should be added to the list of posts for the user. 

Frontend (React) 

UsersTable: The home page is a table of users, which shows data fetched from your UsersAPI, with the following columns: name, email, company name. 

UserPosts: Upon selection of a user, display a list of posts posted by the selected user on the right side of the screen (get data from your PostsAPI). 

NewPost: Add a "Create post" button to UserPosts that will open a dialog where the user can enter details to create the post. After the post is created, the list of posts for the user (UserPosts) will be updated with the new post. 

Bonus points for: 

Error handling when fetching data from the API. What should the user get? What do you do as the system in such a case? 

A loading indicator while fetching data from the API. 

The application to be responsive and look good on both desktop and mobile. 

Add a search box which will filter the table by name or email. 

Docker & AWS 

Containerize your application using Docker. 

Deploy your application on AWS. 

PostgreSQL 

Instead of using https://jsonplaceholder.typicode.com/users and https://jsonplaceholder.typicode.com/posts, use PostgreSQL to store and retrieve users and posts data. 

Recommendations 

Try to produce a professional-looking page so use a component library such as Material-UI, Ant Design, or anything else you like. 

Create an easy-to-read code, and ensure you do understand your own code, since our interview will focus on that code. 

Structure the project in a way that promotes scalability and maintainability. 

Make sure the project is built okay and no debugger and development logs are left in the code and no errors in the console. 

Use comments in the code to explain the things you do there. 

Make use of the latest features of NestJs and React like hooks. 

Important 

The Git project must be complete and work independently. We test the project using the following tools: 

pnpm (As package manager) 

Node v18.12.0 (LTS) 

So, I do recommend testing the GIT locally on a clean server to make sure project dependencies are correct and the project is built and runs okay. 
