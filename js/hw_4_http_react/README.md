### Task

- Implement simple chat that replicates the video
- Find a way to add a timestamp to each message, like this:

```
[Bob (Tue, 8:40 PM)] Hi all
[Joe (Tue, 8:41 PM)] Hi
```

### Setup

- Run client by `yarn start`
- Run server (in a separate terminal window) by `yarn server`

### Backend

This backend supports only two endpoint:

- `POST /api/chat`
- `GET /api/chat`

#### `POST /api/chat`

It can be used to create a new message. It expects for body of the following shape:

```
{
  user: string
  message: string
}
```

E.g.

```
{
  user: 'Joe',
  message: 'Hi all'
}
```

You can supply more data to it, if needed, but `user` and `message` fields are mandatory.

#### `GET /api/chat`

It can be used to fetch all chat messages in array shape. E.g:

```
[
  {
    user: 'Joe',
    message: 'Hi all'
  },
  {
    user: 'Bob',
    message: 'Hi'
  },
]
```

#### Hints

- This backend expects `Content-Type` HTTP header to be set as `application/json` - otherwise it won't work.
- This backend works with JSON format only - remember to `JSON.stringify` request body before sending it via `fetch`. Also remember to pipe the response through `response.json()` when receiving data from server.
- If you need to clear chat history, open `server/storage.json` file and manually write empty array `[]` to it.
- If you want to play around with backend implementation, use `yarn server:dev` command instead of `yarn server`.
- Make sure to poll server for updates every once in a while (e.g. every two seconds) to ensure that all the latest messages have been loaded.
- If using `<form onSubmit>`, remember to call `e.preventDefault()` to override the default form submission behavior.
