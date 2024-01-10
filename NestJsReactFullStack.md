This test is an opportunity for you to demonstrate your development skills and for us to be exposed to them. Please create a public GitHub repo to post your submission.

Create a Full Stack application using [NestJS](https://nestjs.com/), [React](https://react.dev/), [Docker](https://www.docker.com/), [AWS EC2](https://aws.amazon.com/ec2/), and [PostgreSQL](https://www.postgresql.org/). 

**NestJs Backend** 

* UsersAPI: Create a NestJs API that fetches data from https://jsonplaceholder.typicode.com/users. The API should return user data with the following fields: name, email, company name. 
* PostsAPI: Create another API that fetches posts of a selected user from https://jsonplaceholder.typicode.com/posts. 
* NewPostAPI: Add an API endpoint that allows users to create a new post. The new post should be added to the list of posts for the user.

***NestJs Decorators***

Custom Decorator: Create a custom decorator that logs the execution time the method it's applied to. This decorator should print the name of the method and the time it took to execute. Apply this time execution log decorator to all API's.

***NestJs Interceptors***

Logging Interceptor: Implement a logging interceptor that logs details about each incoming HTTP request and the corresponding response. The log should include the HTTP method, the URL, the request payload, the response status, and the response payload.

***PostgreSQL*** 

Instead of using https://jsonplaceholder.typicode.com/users and https://jsonplaceholder.typicode.com/posts, use PostgreSQL to store and retrieve users and posts data. 

***TypeORM***

Entity Relationships: Define entities for User and Post with a one-to-many relationship (one user can have many posts). Use TypeORM decorators to define the entities and the relationship.
CRUD Operations: Implement CRUD (Create, Read, Update, Delete) operations for the User and Post entities using TypeORM.

**Docker** 

Containerize your application (backend NodeJS/Nest and Database) using Docker and Docker compose and make the image accessible to the public in [DockerHub](https://hub.docker.com/). 

**React Frontend** 

UsersTable: The home page is a table of users, which shows data fetched from your UsersAPI, with the following columns: name, email, company name. 
UserPosts: Upon selection of a user, display a list of posts posted by the selected user on the right side of the screen (get data from your PostsAPI). 
NewPost: Add a "Create post" button to UserPosts that will open a dialog where the user can enter details to create the post. After the post is created, the list of posts for the user (UserPosts) will be updated with the new post. 

**Bonus points for:**
* Error handling when fetching data from the API. What should the user get? What do you do as the system in such a case? 

* loading indicator while fetching data from the API. 

* The application to be responsive and look good on both desktop and mobile. 

* Add a search box which will filter the table by name or email.
  
* Containerize the React application and add it to the Docker compose

**Recommendations** 

* Try to produce a professional-looking page so use a component library such as Material-UI, Ant Design, or anything else you like. 

* Create an easy-to-read code, and ensure you do understand your own code, since our interview will focus on that code. 

* Structure the project in a way that promotes scalability and maintainability. 

* Make sure the project is built okay and no debugger and development logs are left in the code and no errors in the console. 

* Use comments in the code to explain the things you do there. 

* Make use of the latest features of NestJs and React like hooks. 

**Final thoughts**

What's missing in this application to make it production grade ?
Please refer to any non functional requirements you addressed in applications you developped.

**Important** 

The Git project must be complete and work independently. We test the project using the following tools: 

pnpm (As package manager) 

Node v18.12.0 (LTS) 

So, I do recommend testing the GIT locally on a clean server to make sure project dependencies are correct and the project is built and runs okay. 


