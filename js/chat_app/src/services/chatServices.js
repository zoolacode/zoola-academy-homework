import { query } from './utils/utils';

export const chatServices = {
  createChat: async (title, authToken) => {
    const body = {
      title
    };
    const response = await query('/api/chats', 'POST', authToken, body);
    return response;
  },
  addChatMembers: async (chatId, authToken, members) => {
    const body = {
      members
    };
    query(`/api/chats/${chatId}/members`, 'POST', authToken, body);
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

  sendUploadsByChatId: async (chatId, authToken, fileObject) => {
    const formData = new FormData();
    formData.append('file', fileObject);
    try {
      await fetch(`/api/chats/${chatId}/attachments`, {
        method: 'POST',
        headers: {
          'Auth-Token': authToken
        },
        body: formData,
      });
    } catch (error) {
      console.log(error);
    }
  },
};


