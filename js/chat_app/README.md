# Running product demo

To run the product demo:

```
yarn demo
```

Only a single admin user will be created, use the following credentials to log in:

```
username: admin
password: admin
```

## Starting development

```
yarn dev:client
yarn backend
```

Or `yarn dev:backend` if you want to debug backend.

# Chat Backend Documentation

## Authentication endpoints

### `POST /api/login`

Returns authentication token as well as user ID.

(Notice: this is a very trivial authentication - token lifetime is infinite, and a token is not validated against the user ID. In real-world projects authentication will most likely be more sophisticated.)

Request body shape:

```
{
  username: string
  password: string
}
```

Response body shape:

```
{
  isAdmin: boolean
  authToken: string
  user: {
    id: string
    username: string
  }
}
```

## Chat endpoints

All of the following endpoints expect authentication token to be present in HTTP header `auth-token`.

### `GET /api/chats`

Get all chats.

### `GET /api/chats/:chatId`

Get chat by ID.

### `POST /api/chat`

Create chat. Accepts JSON of the following shape:

```
{
  title: string
}
```

Returns the created chat object.

### `POST /api/chat/:chatId/messages`

Add chat message. Expected request payload shape:

```
{
  message: string
  authorId: string
}
```

Returns chat object.

### `POST /api/chat/:chatId/attachments`

Uploads a file to chat.

Expects request payload of `FormData` type. (see MDN for reference https://developer.mozilla.org/en-US/docs/Web/API/FormData).

```
const formData = new FormData();
formData.append('file', fileObject)
// ...
fetch({body: formData})
```

Returns chat object with `chat.attachment` as upload ID. Use `/static/${chat.attachment}` URL to load the file.

### `POST /api/chat/:chatId/members`

Add chat message. Expected request payload shape:

```
{
  members: Array<string>
}
```

Returns chat object.

(Hint: the notation above is TypeScript and it can be interpreted as "an array of strings")

## Users endpoints

### `POST /api/users`

Creates a user. Only admin users can use this endpoint. To obtain `adminId` use `POST /api/login` with admin user credentials:

```
username: admin
password: admin
```

Expected payload:

```
{
  adminId: string
  username: string,
  password: string
}
```

Returns the created user.

### `GET /api/users`

Get all users.

### `GET /api/users/:userId`

Get user by ID.

### `GET /api/users/:userId/chats`

Get all chats where the user is a member.
