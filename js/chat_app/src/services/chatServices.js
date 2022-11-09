export const chatServices = {
  createChat: async (title, authToken) => {
    try {
      const data = await fetch('/api/chats', {
        method: 'POST',
        headers: {
          'content-type': 'application/json',
          'Auth-Token': authToken
        },
        body: JSON.stringify({
          title
        })
      });

      const response = await data.json();

      return response;
    } catch (error) {
      console.log(error);
    }
  },

  addChatMembers: async (chatId, authToken, members) => {
    try {
      await fetch(`/api/chats/${chatId}/members`, {
        method: 'POST',
        headers: {
          'content-type': 'application/json',
          'Auth-Token': authToken
        },
        body: JSON.stringify({
          members
        })
      });
    } catch (error) {
      console.log(error);
    }
  },
  getChatById: async (chatId, authToken) => {
    try {
      // eslint-disable-next-line no-debugger
      debugger;
      const data = await fetch(`/api/chats/${chatId}`, {
        method: 'GET',
        headers: {
          'content-type': 'application/json',
          'Auth-Token': authToken
        }
      });

      const response = await data.json();

      return response;
    } catch (error) {
      console.log(error);
    }
  },

  getMessageByChatId: async () => {
    try {
      await fetch(`/api/chats/${chatId}`, {
        method: 'GET',
        headers: {
          'content-type': 'application/json',
          'Auth-Token': authToken
        },
      })
        .then((res) => res.json())
        .then((data) => {
          messagesList(data.messages);
        });
    } catch (error) {
      console.log(error);
    }
  },

  sendMessageByChatId: async (chatId, authToken, message, authorId) => {
    try {
      await fetch(`/api/chats/${chatId}/messages`, {
        method: 'POST',
        headers: {
          'content-type': 'application/json',
          'Auth-Token': authToken
        },
        body: JSON.stringify({
          authorId,
          message
        })
      });
    } catch (error) {
      console.log(error);
    }
  },

  sendUploadsByChatId: async (chatId, authToken, data) => {
    const formData = new FormData();
    formData.append('file', data);
    formData.append('authorToken', token);
    try {
      await fetch(`/api/chats/${chatId}/attachments`, {
        method: 'POST',
        body: formData,
        headers: {
          'auth-token': authToken
        },
      });
    } catch (error) {
      console.log(error);
    }
  },
};
