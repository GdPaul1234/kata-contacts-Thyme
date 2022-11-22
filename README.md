# Contacts database

*Goal: measure performance of a simple application in two scenarios -
with and without a SQL index*

# Step 1 - measure performance without an index

Run the main application with a small number of contacts (<100)
see various readme by languages on how to do that.

You'll get an error message because the code is not complete, so start by implementing the `TODO` comments.

Create a document matching the size of the database with the duration of
the query (in milliseconds):

| size       | time (in ms) |
|------------|--------------|
| 10         | 0            |
| 100        | 1            |
| 10,000     | 1            |
| 50,000     | 7            |
| 100,000    | 13           |
| 1,000,000  | 99           |
| 10,000,000 | 998          |

You'll probably notice the code does not work when n gets big (=~ 1,000,000).

Inserting contacts one by one will be to slow, but inserting 1 million
contacts at once will probably not work either. You'll have to be
smart :)


Make a graph from the table. Does the result match what you would expect ?

> Yes.
> Without index, we need to do a full table scan.
> 
> As a result, the time to find the last record increase linearly with the
> number of records.

# Step 2 - measure performance with an index

Redo the measurements, but this time, create an index *before* inserting the contacts:

```sql
CREATE TABLE contacts(
  id INTEGER PRIMARY KEY,
  name TEXT NOT NULL,
  email TEXT NOT NULL
);

CREATE UNIQUE INDEX index_contacts_email ON contacts(email);
```

Make a graph for the new result. Does it match what you would expect ?
