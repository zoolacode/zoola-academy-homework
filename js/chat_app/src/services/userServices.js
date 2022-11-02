import { query } from './utils/utils';

export const userServices = {
  getAllUsers: async (authToken) => query('/api/users', 'GET', authToken),
  createUser: async (authToken, username, password, adminId) => {
    const body = {
      username,
      password,
      adminId
    };
    query('/api/users', 'POST', authToken, body);
  },
  getUserById: async (userId, authToken) => query(`/api/users/${userId}`, 'GET', authToken)
};
