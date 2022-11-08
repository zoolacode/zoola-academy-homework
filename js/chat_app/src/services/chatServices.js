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
  // getAllChats: async ({authToken}) => {
  //   query(`/api/chats`, 'POST', authToken);
  // },
  getChat: async ({chatId, authToken}) => {
    query(`/api/chats/${chatId}`, 'GET', authToken);
  }
};
