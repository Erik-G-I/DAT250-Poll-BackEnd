## Link to dockerfile
https://github.com/Erik-G-I/DAT250-Poll-BackEnd/blob/main/dockerfile

## Link to jpa-tutorial with docker and postgres
https://github.com/Erik-G-I/dat250-jpa-tutorial


## Report

### postgres
I already had docker and postgres installed. After i had edited the java source code in the jpa-tutorial to connect to a postgres database, i ran the tests to see what happened. This failed as there was no active db to connect to.

Image

So to set up a new container with postgres and connect it to the jpa-tutorial assignment i ran this command:
` docker run --name postgres -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=postgres -v /Users/erikingebrigtsen/Documents/UIB/DAT250/dat250-jpa-tutorial/schema.up.sql:/docker-entrypoint-initdb.d/schema.up.sql -d postgres`

This sets the name of the container to "postgres" and exposes the port "5432" to the outside environment.
The enviroment variables `POSTGRES_USER` and `POSTGRES_PASSWORD` sets an admin user for the database.
The volume variable copies my local file "schema.up.sql" into the docker container.

After this the tests Pass
Image



### Dockerfile
When running building the docker image it is important to expose the port to the system so you can run HTTP requests to it.

For this i used `docker run -d -p 8080:8080 expass7

It took some time to get familiar with docker, but i think i got a baisc understanding of it in the end.
