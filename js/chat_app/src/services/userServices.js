export const userServices = {
  getAllUsers: async (adminToken) => {
    try {
      const data = await fetch('/api/users', {
        method: 'GET',
        headers: {
          'content-type': 'application/json',
          'Auth-Token': adminToken
        }
      });

      const response = data.json();

      return response;
    } catch (error) {
      console.log(error);
    }
  },
  createUser: async (adminToken, username, password, adminId) => {
    try {
      await fetch('/api/users', {
        method: 'POST',
        headers: {
          'content-type': 'application/json',
          'Auth-Token': adminToken
        },
        body: JSON.stringify({
          adminId,
          username,
          password
        })
      });
    } catch (error) {
      console.log(error);
    }
  }
};
